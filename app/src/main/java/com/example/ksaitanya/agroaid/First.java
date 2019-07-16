package com.example.ksaitanya.agroaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import java.util.Timer;
import java.util.TimerTask;

public class First extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        timer();

       }
    private void timer() {
        int dur=3000;
        Timer timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run()
            {
                Intent intent;
                intent = new Intent(First.this, Home.class);
                startActivity(intent);

            }
        },dur);
    }
}
