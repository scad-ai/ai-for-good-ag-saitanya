package com.example.ksaitanya.agroaid;

import android.Manifest;
import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends Activity{
    Button d, p, n, i, c,yes,no,cc,call1,call2,call3,msg1,msg2,msg3;
    private boolean useCamera2API;
    static String x;
    static String MODEL_FILE;
    static String LABEL_FILE;
    Dialog about,exit,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        about = new Dialog(this);
        exit=new Dialog(this);
        contact=new Dialog(this);
        addListenerOnButton();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED &&
           ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
           ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
           ActivityCompat.checkSelfPermission(getApplicationContext(),android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
           ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED &&
           ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,android.Manifest.permission.CAMERA,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.CALL_PHONE,
                    android.Manifest.permission.SEND_SMS}, 101);
        }
    }
    public void onBackPressed() {
        exit.setContentView(R.layout.popup_exit);
        yes=(Button) exit.findViewById(R.id.button);
        no=(Button) exit.findViewById(R.id.button2);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit.dismiss();
            }
        });
        exit.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        exit.show();
    }
    public void AboutUs(View v) {
        about.setContentView(R.layout.about_app);
        c = (Button) about.findViewById(R.id.close);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about.dismiss();
            }
        });
        about.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        about.show();
    }
    public void ContactUs(View v) {
        contact.setContentView(R.layout.popup_contact);
        cc = (Button) contact.findViewById(R.id.closec);
        call1 = (Button) contact.findViewById(R.id.call1);
        call2 = (Button) contact.findViewById(R.id.call2);
        call3 = (Button) contact.findViewById(R.id.call3);
        msg1 = (Button) contact.findViewById(R.id.msg1);
        msg2 = (Button) contact.findViewById(R.id.msg2);
        msg3 = (Button) contact.findViewById(R.id.msg3);
        contact.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        contact.show();
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact.dismiss();
            }
        });
        call1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:+917893855120")));
            }
        });
        call2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:+917893855120")));
            }
        });
        call3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:+917893855120")));
            }
        });
        msg1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7893855120"));
                smsIntent.putExtra("sms_body", "Hello!(Enter your question)");
                startActivity(smsIntent);
            }
        });
        msg2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7893855120"));
                smsIntent.putExtra("sms_body", "Hello!(Enter your question)");
                startActivity(smsIntent);
            }
        });
        msg3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7893855120"));
                smsIntent.putExtra("sms_body", "Hello!(Enter your question)");
                startActivity(smsIntent);
            }
        });
    }

    public void addListenerOnButton() {
        d = (Button) findViewById(R.id.disease);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(),ClassifierActivity.class);
                x="Disease";
                MODEL_FILE = "file:///android_asset/disease.pb";
                LABEL_FILE = "file:///android_asset/disease_labels.txt";
                startActivity(intent);
            }
        });
        p = (Button) findViewById(R.id.pest);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(),ClassifierActivity.class);
                x="Pest";
                MODEL_FILE = "file:///android_asset/pest.pb";
                LABEL_FILE = "file:///android_asset/pest_labels.txt";
                startActivity(intent);
            }
        });
        n = (Button) findViewById(R.id.nutrient);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(),ClassifierActivity.class);
                x="Nutrient";
                MODEL_FILE = "file:///android_asset/nutrient_deficiency.pb";
                LABEL_FILE = "file:///android_asset/nutrient_labels.txt";
                startActivity(intent);
            }
        });
        i = (Button) findViewById(R.id.info);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), Info.class);
                startActivity(intent);
            }
        });
    }

}

