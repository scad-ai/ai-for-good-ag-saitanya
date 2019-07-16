package com.example.ksaitanya.agroaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Nutrients extends Activity {
Button b;
    //TextView aboutRice,aboutWheat,aboutLemon,aboutMirch,aboutTomato,aboutMaize,aboutSugercane,aboutCoffee,aboutTea,aboutRose,aboutAloevera;
    ImageView plough,axe,barrel,weir,harrow,fork,hoe,roller,mower;
    Button rice,wheat,lemon,mirch,tomato,maize,sugercane,tea,coffee;
    ImageButton  upr,upw,upl,upm,upt,upma,ups,upc,upte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrients);
        addListenerOnButton();

        /*aboutRice = (TextView) findViewById(R.id.aboutr);
        aboutWheat = (TextView) findViewById(R.id.aboutw);
        aboutLemon = (TextView) findViewById(R.id.aboutl);
        aboutMirch = (TextView) findViewById(R.id.aboutm);
        aboutTomato = (TextView) findViewById(R.id.aboutt);
        aboutMaize = (TextView) findViewById(R.id.aboutma);
        aboutSugercane = (TextView) findViewById(R.id.abouts);
        aboutCoffee = (TextView) findViewById(R.id.aboutc);
        aboutTea = (TextView) findViewById(R.id.aboutte);
        aboutRose = (TextView) findViewById(R.id.aboutro);
        aboutAloevera = (TextView) findViewById(R.id.abouta);*/

        plough = (ImageView) findViewById(R.id.plough);
        axe = (ImageView) findViewById(R.id.axe);
        barrel = (ImageView) findViewById(R.id.barrel);
        weir = (ImageView) findViewById(R.id.weir);
        harrow = (ImageView) findViewById(R.id.harrow);
        fork = (ImageView) findViewById(R.id.fork);
        hoe = (ImageView) findViewById(R.id.hoe);
        roller = (ImageView) findViewById(R.id.roller);
        mower = (ImageView) findViewById(R.id.mower);

        rice = (Button) findViewById(R.id.ricepic);
        wheat = (Button) findViewById(R.id.wheatpic);
        lemon = (Button) findViewById(R.id.lemonpic);
        mirch = (Button) findViewById(R.id.mirchpic);
        tomato = (Button) findViewById(R.id.tomatopic);
        maize = (Button) findViewById(R.id.maizepic);
        sugercane = (Button) findViewById(R.id.sugercanepic);
        coffee = (Button) findViewById(R.id.coffeepic);
        tea = (Button) findViewById(R.id.teapic);

        upr = (ImageButton) findViewById(R.id.upr);
        upw = (ImageButton) findViewById(R.id.upw);
        upl = (ImageButton) findViewById(R.id.upl);
        upt = (ImageButton) findViewById(R.id.upt);
        upm = (ImageButton) findViewById(R.id.upm);
        upma = (ImageButton) findViewById(R.id.upma);
        ups = (ImageButton) findViewById(R.id.ups);
        upc = (ImageButton) findViewById(R.id.upc);
        upte = (ImageButton) findViewById(R.id.upte);

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upr.setVisibility(View.VISIBLE);
                plough.setVisibility(View.VISIBLE);
            }
        });
        wheat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upw.setVisibility(View.VISIBLE);
                axe.setVisibility(View.VISIBLE);
            }
        });
        lemon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upl.setVisibility(View.VISIBLE);
                hoe.setVisibility(View.VISIBLE);
            }
        });
        mirch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upm.setVisibility(View.VISIBLE);
                mower.setVisibility(View.VISIBLE);
            }
        });
        tomato.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upt.setVisibility(View.VISIBLE);
                roller.setVisibility(View.VISIBLE);
            }
        });
        maize.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upma.setVisibility(View.VISIBLE);
                barrel.setVisibility(View.VISIBLE);
            }
        });
        sugercane.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ups.setVisibility(View.VISIBLE);
                weir.setVisibility(View.VISIBLE);
            }
        });
        coffee.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upc.setVisibility(View.VISIBLE);
                harrow.setVisibility(View.VISIBLE);
            }
        });
        tea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upte.setVisibility(View.VISIBLE);
                fork.setVisibility(View.VISIBLE);
            }
        });


        upr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upr.setVisibility(View.GONE);
               plough.setVisibility(View.GONE);
            }
        });
        upl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upl.setVisibility(View.GONE);
                hoe.setVisibility(View.GONE);
            }
        });
        upw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upw.setVisibility(View.GONE);
                axe.setVisibility(View.GONE);
            }
        });
        upm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upm.setVisibility(View.GONE);
                mower.setVisibility(View.GONE);
            }
        });
        upt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upt.setVisibility(View.GONE);
                roller.setVisibility(View.GONE);
            }
        });
        upma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upma.setVisibility(View.GONE);
                barrel.setVisibility(View.GONE);
            }
        });
        ups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ups.setVisibility(View.GONE);
                weir.setVisibility(View.GONE);
            }
        });
        upc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upc.setVisibility(View.GONE);
                harrow.setVisibility(View.GONE);
            }
        });
        upte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upte.setVisibility(View.GONE);
                fork.setVisibility(View.GONE);
            }
        });
    }
    public void addListenerOnButton() {
        b = (Button) findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), Info.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(Nutrients.this, Info.class);
        startActivity(intent);
    }
}
