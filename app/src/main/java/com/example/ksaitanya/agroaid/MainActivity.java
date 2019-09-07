package com.example.ksaitanya.agroaid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class MainActivity extends Activity {

    private static final int SAMPLE_RATE = 16000;
    private static final int SAMPLE_DURATION_MS = 1000;
    private static final int RECORDING_LENGTH = (int) (SAMPLE_RATE * SAMPLE_DURATION_MS / 1000);
    private static final long AVERAGE_WINDOW_DURATION_MS = 500;
    private static final float DETECTION_THRESHOLD = 0.70f;
    private static final int SUPPRESSION_MS = 1500;
    private static final int MINIMUM_COUNT = 3;
    private static final long MINIMUM_TIME_BETWEEN_SAMPLES_MS = 30;
    private static final String LABEL_FILENAME = "file:///android_asset/conv_actions_labels.txt";
    private static final String MODEL_FILENAME = "file:///android_asset/conv_actions_frozen.pb";

    private static final String INPUT_DATA_NAME = "decoded_sample_data:0";

    private static final String SAMPLE_RATE_NAME = "decoded_sample_data:1";

    private static final String OUTPUT_SCORES_NAME = "labels_softmax";
    /* private static final String INPUT_DATA_NAME = "conv2d_1_input";
    private static final String SAMPLE_RATE_NAME = "sampleratename";
    private static final String OUTPUT_SCORES_NAME = "output_1";*/

    // UI elements.
    private static final int REQUEST_RECORD_AUDIO = 13;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private final ReentrantLock recordingBufferLock = new ReentrantLock();
    // Working variables.
    short[] recordingBuffer = new short[RECORDING_LENGTH];
    int recordingOffset = 0;
    boolean shouldContinue = true;
    boolean shouldContinueRecognition = true;
    private Button quitButton;
    private ListView labelsListView;
    private Thread recordingThread;
    private Thread recognitionThread;
    private TensorFlowInferenceInterface inferenceInterface;
    private List<String> labels = new ArrayList<String>();
    private List<String> displayedLabels = new ArrayList<>();
    private RecognizeCommands recognizeCommands = null;

    private TextView label,start;
    private Button rb;
    Button b,c,more;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set up the UI.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = findViewById(R.id.label);
        rb =  findViewById(R.id.rb);
        start = findViewById(R.id.sr);

        // Load the labels for the model, but only display those that don't start
        // with an underscore.
        String actualFilename = LABEL_FILENAME.split("file:///android_asset/")[1];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getAssets().open(actualFilename)));
            String line;
            while ((line = br.readLine()) != null) {
                labels.add(line);
                if (line.charAt(0) != '_') {
                    displayedLabels.add(line.substring(0, 1).toUpperCase() + line.substring(1));
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException("Problem reading label file!", e);
        }


        // Set up an object to smooth recognition results to increase accuracy.
        recognizeCommands =
                new RecognizeCommands(
                        labels,
                        AVERAGE_WINDOW_DURATION_MS,
                        DETECTION_THRESHOLD,
                        SUPPRESSION_MS,
                        MINIMUM_COUNT,
                        MINIMUM_TIME_BETWEEN_SAMPLES_MS);

        // Load the TensorFlow model.
        inferenceInterface = new TensorFlowInferenceInterface(getAssets(), MODEL_FILENAME);

        // Start the recording and recognition threads.
        requestMicrophonePermission();
        startRecognition();
    }

    public void AboutIdentify(View v) {
        myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.about_identity);
        TextView about = (TextView) myDialog.findViewById(R.id.aboutiden);
        c = (Button) myDialog.findViewById(R.id.close);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        String message= "TUTORIAL\n\nThis page will help you identify disease attack in plant and if any disease is identified, you can also view tips on how to treat it and contact expert for further advice, with just one click.\n" +
                    "Lets get started.\n\n" +
                    "To identify disease attack\n" +
                    "1. Take your phone close to the part of the plant you see the symptoms at. If there are no visible symptoms, put your phone just above a leaf.\n" +
                    "2. click the camera button so that the app can click the picture of the plant.\n" +
                    "3. Now wait till the app gives you results on the top.\n" +
                    "4. If it says \"Sorry! Cannot Recognize\", move your phone a little closer or far or change the angle and click again.\n" +
                    "5. When the app identifies a healthy plant or any disease, a plus (+) symbol will appear along with the result. Click on the plus to read more about what the app identified including fun facts, tips to treat disease and contact options.\n" +
                    "\nExit this tutorial to continue with the app.";

        about.setText(message);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void addListener(View v) {
        b = (Button) findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), Home.class);
                startActivity(intent);
            }
        });
/*        more = (Button) findViewById(R.id.button3);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), More.class);
                startActivity(intent);
            }
        });*/
    }
    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
    }

    private void requestMicrophonePermission() {
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{android.Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO);
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_RECORD_AUDIO
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startRecording();
            startRecognition();
        }
    }

    public synchronized void startRecording() {
        if (recordingThread != null) {
            return;
        }
        shouldContinue = true;
        recordingThread =
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                record();
                            }
                        });
        recordingThread.start();
    }

    public synchronized void stopRecording() {
        if (recordingThread == null) {
            return;
        }
        shouldContinue = false;
        recordingThread = null;
    }

    private void record() {
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_AUDIO);

        // Estimate the buffer size we'll need for this device.
        int bufferSize =
                AudioRecord.getMinBufferSize(
                        SAMPLE_RATE, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        if (bufferSize == AudioRecord.ERROR || bufferSize == AudioRecord.ERROR_BAD_VALUE) {
            bufferSize = SAMPLE_RATE * 2;
        }
        short[] audioBuffer = new short[bufferSize / 2];

        AudioRecord record =
                new AudioRecord(
                        MediaRecorder.AudioSource.DEFAULT,
                        SAMPLE_RATE,
                        AudioFormat.CHANNEL_IN_MONO,
                        AudioFormat.ENCODING_PCM_16BIT,
                        bufferSize);

        if (record.getState() != AudioRecord.STATE_INITIALIZED) {
            Toast.makeText(getApplicationContext(),"Audio Record can't initialize!",Toast.LENGTH_SHORT).show();
            return;
        }

        record.startRecording();

        // Loop, gathering audio data and copying it to a round-robin buffer.
        while (true) {
            rb.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        shouldContinue = true;
                        start.setText("Start recording");
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP){
                        start.setText("Find answer");
                        shouldContinue= false;
                    }
                    return true;
                }
            });

            if (shouldContinue){
                Log.d("Recording", "record: "+ shouldContinue);
                int numberRead = record.read(audioBuffer, 0, audioBuffer.length);
                int maxLength = recordingBuffer.length;
                int newRecordingOffset = recordingOffset + numberRead;
                int secondCopyLength = Math.max(0, newRecordingOffset - maxLength);
                int firstCopyLength = numberRead - secondCopyLength;
                // We store off all the data for the recognition thread to access. The ML
                // thread will copy out of this buffer into its own, while holding the
                // lock, so this should be thread safe.
                recordingBufferLock.lock();
                try {
                    System.arraycopy(audioBuffer, 0, recordingBuffer, recordingOffset, firstCopyLength);
                    System.arraycopy(audioBuffer, firstCopyLength, recordingBuffer, 0, secondCopyLength);
                    recordingOffset = newRecordingOffset % maxLength;
                } finally {
                    recordingBufferLock.unlock();
                }
            }
        }
    }

    public synchronized void startRecognition() {
        if (recognitionThread != null) {
            return;
        }
        recognitionThread =
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                recognize();
                            }
                        });
        recognitionThread.start();
    }

    private void recognize() {
        short[] inputBuffer = new short[RECORDING_LENGTH];
        float[] floatInputBuffer = new float[RECORDING_LENGTH];
        float[] outputScores = new float[labels.size()];
        String[] outputScoresNames = new String[]{OUTPUT_SCORES_NAME};
        int[] sampleRateList = new int[]{SAMPLE_RATE};

        // Loop, grabbing recorded data and running the recognition model on it.
        while (true) {
            if (!shouldContinue){
                Log.d("Recognising", "Recognize: "+ !shouldContinue);
                // The recording thread places data in this round-robin buffer, so lock to
                // make sure there's no writing happening and then copy it to our own
                // local version.
                recordingBufferLock.lock();
                try {
                    int maxLength = recordingBuffer.length;
                    int firstCopyLength = maxLength - recordingOffset;
                    int secondCopyLength = recordingOffset;
                    System.arraycopy(recordingBuffer, recordingOffset, inputBuffer, 0, firstCopyLength);
                    System.arraycopy(recordingBuffer, 0, inputBuffer, firstCopyLength, secondCopyLength);
                } finally {
                    recordingBufferLock.unlock();
                }

                // We need to feed in float values between -1.0f and 1.0f, so divide the
                // signed 16-bit inputs.
                for (int i = 0; i < RECORDING_LENGTH; ++i) {
                    floatInputBuffer[i] = inputBuffer[i] / 32767.0f;
                }

                // Run the model.
                inferenceInterface.feed(SAMPLE_RATE_NAME, sampleRateList);
                inferenceInterface.feed(INPUT_DATA_NAME, floatInputBuffer, RECORDING_LENGTH, 1);
                inferenceInterface.run(outputScoresNames);
                inferenceInterface.fetch(OUTPUT_SCORES_NAME, outputScores);

                // Use the smoother to figure out if we've had a real recognition event.
                long currentTime = System.currentTimeMillis();
                final RecognizeCommands.RecognitionResult result = recognizeCommands.processLatestResults(outputScores, currentTime);

                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                // If we do have a new command, highlight the right list entry.
                                if (!result.foundCommand.startsWith("_") && result.isNewCommand) {
                                    if(result.score>0.6){
                                    label.setText(result.foundCommand);}
                                    else{
                                        label.setText("Sorry! Cannot Recognize");
                                    }
                                }
                            }
                        });
                try {
                    // We don't need to run too frequently, so snooze for a bit.
                    Thread.sleep(MINIMUM_TIME_BETWEEN_SAMPLES_MS);
                } catch (InterruptedException e) {
                    // Ignore
                }


            }
        }

    }
}