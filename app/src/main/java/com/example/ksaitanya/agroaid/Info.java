package com.example.ksaitanya.agroaid;

import android.app.*;
import android.content.*;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;

public class Info extends Activity implements LocationListener{
    Button b,c;
    int dur;
    ImageButton w,t,p,n;
    LocationManager locationManager;
    Dialog myDialog;
    public static String lat,lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        myDialog = new Dialog(this);
        addListenerOnButton();
        getLocation();
    }
            void getLocation() {
            try {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                lon= String.valueOf(location.getLongitude());
                lat= String.valueOf(location.getLatitude());

            }
            catch(SecurityException e) {
                e.printStackTrace();
            }
        }
    @Override
    public void onLocationChanged(Location location) {
    }
    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(Info.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(Info.this, Home.class);
        startActivity(intent);
    }
    public void AboutInfo(View v) {
        myDialog.setContentView(R.layout.about_info);
        c = (Button) myDialog.findViewById(R.id.close);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        TextView about = (TextView) myDialog.findViewById(R.id.abouttext);
        String msg="ABOUT GUIDE\n" +
                "\n" +
                "This is the guide where you can read information on\n" +
                "\t-> Current weather conditions at your location\n" +
                "\t-> How to plant different plants\n" +
                "\t-> Major tools used in agriculture and gardening.\n" +
                "\t-> Nutrition content in different plants.\n\n" +
                "Choose an option to option the information you want to read.\n" +
                "1. Current weather conditions at your location\n" +
                "Here you can view , provided you have internet connectivity through WiFi or Mobile Network.\n" +
                "2. How to plant different plants.\n" +
                "Get step by step instructions on how to plant various plants including rice, wheat, tea  and many more. These instructions will guide you through plantation indoors as well as outdoors.\n" +
                "3. Major tools used in agriculture and gardening.\n" +
                "Do you want to know what a certain tool is used for in a field or garden? Here you can get basic information on the tools.\n" +
                "4. Nutrition content in different plants\n" +
                "Understand the different nutrients present in various plants by selection this option.\n" +
                "\n" +
                "Exit this tutorial to continue with the app.";
        about.setText(msg);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void addListenerOnButton() {
        b = (Button) findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), Home.class);
                startActivity(intent);
            }
        });
        w = (ImageButton) findViewById(R.id.weather);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lat==null || lon==null)
                    dur=2000;
                else
                dur=0;
                Timer timer=new Timer();
                timer.schedule(new TimerTask(){
                    @Override
                    public void run()
                    {
                        Intent intent;
                        intent = new Intent(Info.this, Weather.class);
                        startActivity(intent);

                    }
                },dur);
            }
        });
        t = (ImageButton) findViewById(R.id.tools);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), Tool.class);
                startActivity(intent);
            }
        });
        p = (ImageButton) findViewById(R.id.plant);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), Plant.class);
                startActivity(intent);
            }
        });
        n = (ImageButton) findViewById(R.id.nutriinfo);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), Nutrients.class);
                startActivity(intent);
            }
        });
    }
}
