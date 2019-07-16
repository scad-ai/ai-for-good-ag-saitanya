package com.example.ksaitanya.agroaid;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.*;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.ColorDrawable;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.*;
import android.view.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import com.example.ksaitanya.agroaid.OverlayView.DrawCallback;
import com.example.ksaitanya.agroaid.env.*;

public class ClassifierActivity extends CameraActivity implements OnImageAvailableListener {

    protected static final boolean SAVE_PREVIEW_BITMAP = false;
    ImageButton cb;
    Button b,c,more;
    Dialog myDialog;
    private ResultsView resultsView;

    private Bitmap rgbFrameBitmap = null;
    private Bitmap croppedBitmap = null;
    private Bitmap cropCopyBitmap = null;

    private long lastProcessingTimeMs;

    private static final int INPUT_SIZE = 299;
    private static final int IMAGE_MEAN = 128;
    private static final float IMAGE_STD = 128.0f;
    private static final String INPUT_NAME = "Mul:0";
    private static final String OUTPUT_NAME = "final_result";
    private static final boolean MAINTAIN_ASPECT = true;
    private static final Size DESIRED_PREVIEW_SIZE = new Size(640, 480);
    private Integer sensorOrientation;
    private Classifier classifier;
    private Matrix frameToCropTransform;
    private Matrix cropToFrameTransform;
    private BorderedText borderedText;

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
        String message="";
        if(Home.x.equals("Disease"))
            message="TUTORIAL\n\nThis page will help you identify disease attack in plant and if any disease is identified, you can also view tips on how to treat it and contact expert for further advice, with just one click.\n" +
                    "Lets get started.\n\n" +
                    "To identify disease attack\n" +
                    "1. Take your phone close to the part of the plant you see the symptoms at. If there are no visible symptoms, put your phone just above a leaf.\n" +
                    "2. click the camera button so that the app can click the picture of the plant.\n" +
                    "3. Now wait till the app gives you results on the top.\n" +
                    "4. If it says \"Sorry! Cannot Recognize\", move your phone a little closer or far or change the angle and click again.\n" +
                    "5. When the app identifies a healthy plant or any disease, a plus (+) symbol will appear along with the result. Click on the plus to read more about what the app identified including fun facts, tips to treat disease and contact options.\n" +
                    "\nExit this tutorial to continue with the app.";
        else if(Home.x.equals("Pest"))
            message="TUTORIAL\n" +
                    "\nThis page will help you identify pest attack in plant and if any pest is identified, you can also view tips on how to treat it and contact expert for further advice, with just one click.\n" +
                    "Lets get started.\n\n" +
                    "To identify pest attack\n" +
                    "1. Take your phone close to the part of the plant you see the symptoms at. If there are no visible symptoms, put your phone just above a leaf.\n" +
                    "2. click the camera button so that the app can click the picture of the plant.\n" +
                    "3. Now wait till the app gives you results on the top.\n" +
                    "4. If it says \"Sorry! Cannot Recognize\", move your phone a little closer or far or change the angle and click again.\n" +
                    "5. When the app identifies a healthy plant or any pest, a plus (+) symbol will appear along with the result. Click on the plus to read more about what the app identified including fun facts, tips to get rid of the pest and contact options.\n" +
                    "\nExit this tutorial to continue with the app.";
        else if(Home.x.equals("Nutrient"))
            message="TUTORIAL\n" +
                    "\nThis page will help you identify nutrient deficiency in plant and if any deficiency is identified, you can also view tips on how to treat it and contact expert for further advice, with just one click.\n" +
                    "Lets get started.\n\n" +
                    "To identify nutrient deficiency\n" +
                    "1. Take your phone close to the part of the plant you see the symptoms at. If there are no visible symptoms, put your phone just above a leaf.\n" +
                    "2. click the camera button so that the app can click the picture of the plant.\n" +
                    "3. Now wait till the app gives you results on the top.\n" +
                    "4. If it says \"Sorry! Cannot Recognize\", move your phone a little closer or far or change the angle and click again.\n" +
                    "5. When the app identifies a healthy plant or any deficiency, a plus (+) symbol will appear along with the result. Click on the plus to read more about what the app identified including fun facts, tips to treat deficiency and contact options.\n" +
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
        more = (Button) findViewById(R.id.button3);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), More.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(ClassifierActivity.this, Home.class);
        startActivity(intent);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.camera_connection_fragment;
    }

    @Override
    protected Size getDesiredPreviewFrameSize() {
        return DESIRED_PREVIEW_SIZE;
    }

    private static final float TEXT_SIZE_DIP = 10;

    @Override
    public void onPreviewSizeChosen(final Size size, final int rotation) {
        final float textSizePx = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_DIP, getResources().getDisplayMetrics());
        borderedText = new BorderedText(textSizePx);
        borderedText.setTypeface(Typeface.MONOSPACE);
        classifier =
                TensorFlowImageClassifier.create(
                        getAssets(),
                        Home.MODEL_FILE,
                        Home.LABEL_FILE,
                        INPUT_SIZE,
                        IMAGE_MEAN,
                        IMAGE_STD,
                        INPUT_NAME,
                        OUTPUT_NAME);
        previewWidth = size.getWidth();
        previewHeight = size.getHeight();
        final Display display = getWindowManager().getDefaultDisplay();
        final int screenOrientation = display.getRotation();
        sensorOrientation = rotation + screenOrientation;
        rgbFrameBitmap = Bitmap.createBitmap(previewWidth, previewHeight, Config.ARGB_8888);
        croppedBitmap = Bitmap.createBitmap(INPUT_SIZE, INPUT_SIZE, Config.ARGB_8888);
        frameToCropTransform = ImageUtils.getTransformationMatrix(
                previewWidth, previewHeight,
                INPUT_SIZE, INPUT_SIZE,
                sensorOrientation, MAINTAIN_ASPECT);
        cropToFrameTransform = new Matrix();
        frameToCropTransform.invert(cropToFrameTransform);
        addCallback(
                new DrawCallback() {
                    @Override
                    public void drawCallback(final Canvas canvas) {
                        renderDebug(canvas);
                    }
                });
    }
    @Override
    protected void processImage() {
        rgbFrameBitmap.setPixels(getRgbBytes(), 0, previewWidth, 0, 0, previewWidth, previewHeight);
        final Canvas canvas = new Canvas(croppedBitmap);
        canvas.drawBitmap(rgbFrameBitmap, frameToCropTransform, null);
        // For examining the actual TF input.
        if (SAVE_PREVIEW_BITMAP) {
            ImageUtils.saveBitmap(croppedBitmap);
        }
        cb= (ImageButton) findViewById(R.id.button);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                more =(Button)findViewById(R.id.button3);
                final long startTime = SystemClock.uptimeMillis();
                final List<Classifier.Recognition> results = classifier.recognizeImage(croppedBitmap);
                lastProcessingTimeMs = SystemClock.uptimeMillis() - startTime;
                cropCopyBitmap = Bitmap.createBitmap(croppedBitmap);
                if (resultsView == null) {
                    resultsView = (ResultsView) findViewById(R.id.results);
                }
                float i=0;
                for (final Classifier.Recognition recog : results) {
                    if (recog.getConfidence() > i)
                        i = recog.getConfidence();
                }
                if(i>0.6)  more.setVisibility(View.VISIBLE);
                    else more.setVisibility(View.GONE);
                    resultsView.setResults(results);
                requestRender();
                readyForNextImage();

            }
        });

    }

    @Override
    public void onSetDebug(boolean debug) {
        classifier.enableStatLogging(debug);
    }

    private void renderDebug(final Canvas canvas) {
        if (!isDebug()) {
            return;
        }
        final Bitmap copy = cropCopyBitmap;
        if (copy != null) {
            final Matrix matrix = new Matrix();
            final float scaleFactor = 2;
            matrix.postScale(scaleFactor, scaleFactor);
            matrix.postTranslate(
                    canvas.getWidth() - copy.getWidth() * scaleFactor,
                    canvas.getHeight() - copy.getHeight() * scaleFactor);
            canvas.drawBitmap(copy, matrix, new Paint());

            final Vector<String> lines = new Vector<String>();
            if (classifier != null) {
                String statString = classifier.getStatString();
                String[] statLines = statString.split("\n");
                for (String line : statLines) {
                    lines.add(line);
                }
            }

            lines.add("Frame: " + previewWidth + "x" + previewHeight);
            lines.add("Crop: " + copy.getWidth() + "x" + copy.getHeight());
            lines.add("View: " + canvas.getWidth() + "x" + canvas.getHeight());
            lines.add("Rotation: " + sensorOrientation);
            lines.add("Inference time: " + lastProcessingTimeMs + "ms");

            borderedText.drawLines(canvas, 10, canvas.getHeight() - 10, lines);
        }
    }
}
