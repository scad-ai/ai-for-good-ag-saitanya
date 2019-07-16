package com.example.ksaitanya.agroaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class Plant extends Activity {
    Button b;
    TextView aboutRice,aboutWheat,aboutLemon,aboutMirch,aboutTomato,aboutMaize,aboutSugercane,aboutCoffee,aboutTea,aboutRose,aboutAloevera;
    Button rice,wheat,lemon,mirch,tomato,maize,sugercane,tea,coffee,rose,aloevera;
    ImageButton  upr,upw,upl,upm,upt,upma,ups,upc,upte,upro,upa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        addListenerOnButton();
        aboutRice = (TextView) findViewById(R.id.aboutr);
        aboutWheat = (TextView) findViewById(R.id.aboutw);
        aboutLemon = (TextView) findViewById(R.id.aboutl);
        aboutMirch = (TextView) findViewById(R.id.aboutm);
        aboutTomato = (TextView) findViewById(R.id.aboutt);
        aboutMaize = (TextView) findViewById(R.id.aboutma);
        aboutSugercane = (TextView) findViewById(R.id.abouts);
        aboutCoffee = (TextView) findViewById(R.id.aboutc);
        aboutTea = (TextView) findViewById(R.id.aboutte);
        aboutRose = (TextView) findViewById(R.id.aboutro);
        aboutAloevera = (TextView) findViewById(R.id.abouta);

        rice = (Button) findViewById(R.id.ricepic);
        wheat = (Button) findViewById(R.id.wheatpic);
        lemon = (Button) findViewById(R.id.lemonpic);
        mirch = (Button) findViewById(R.id.mirchpic);
        tomato = (Button) findViewById(R.id.tomatopic);
        maize = (Button) findViewById(R.id.maizepic);
        sugercane = (Button) findViewById(R.id.sugercanepic);
        coffee = (Button) findViewById(R.id.coffeepic);
        tea = (Button) findViewById(R.id.teapic);
        rose = (Button) findViewById(R.id.rosepic);
        aloevera = (Button) findViewById(R.id.aloepic);

        upr = (ImageButton) findViewById(R.id.upr);
        upw = (ImageButton) findViewById(R.id.upw);
        upl = (ImageButton) findViewById(R.id.upl);
        upt = (ImageButton) findViewById(R.id.upt);
        upm = (ImageButton) findViewById(R.id.upm);
        upma = (ImageButton) findViewById(R.id.upma);
        ups = (ImageButton) findViewById(R.id.ups);
        upc = (ImageButton) findViewById(R.id.upc);
        upte = (ImageButton) findViewById(R.id.upte);
        upro = (ImageButton) findViewById(R.id.upro);
        upa = (ImageButton) findViewById(R.id.upa);

        rice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upr.setVisibility(View.VISIBLE);
                aboutRice.setVisibility(View.VISIBLE);
                aboutRice.setMaxLines(Integer.MAX_VALUE);
            }
        });
        wheat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upw.setVisibility(View.VISIBLE);
                aboutWheat.setVisibility(View.VISIBLE);
                aboutWheat.setMaxLines(Integer.MAX_VALUE);
            }
        });
        lemon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upl.setVisibility(View.VISIBLE);
                aboutLemon.setVisibility(View.VISIBLE);
                aboutLemon.setMaxLines(Integer.MAX_VALUE);
            }
        });
        mirch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upm.setVisibility(View.VISIBLE);
                aboutMirch.setVisibility(View.VISIBLE);
                aboutMirch.setMaxLines(Integer.MAX_VALUE);
            }
        });
        tomato.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upt.setVisibility(View.VISIBLE);
                aboutTomato.setVisibility(View.VISIBLE);
                aboutTomato.setMaxLines(Integer.MAX_VALUE);
            }
        });
        maize.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upma.setVisibility(View.VISIBLE);
                aboutMaize.setVisibility(View.VISIBLE);
                aboutMaize.setMaxLines(Integer.MAX_VALUE);
            }
        });
        sugercane.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ups.setVisibility(View.VISIBLE);
                aboutSugercane.setVisibility(View.VISIBLE);
                aboutSugercane.setMaxLines(Integer.MAX_VALUE);
            }
        });
        coffee.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upc.setVisibility(View.VISIBLE);
                aboutCoffee.setVisibility(View.VISIBLE);
                aboutCoffee.setMaxLines(Integer.MAX_VALUE);
            }
        });
        tea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upt.setVisibility(View.VISIBLE);
                aboutTea.setVisibility(View.VISIBLE);
                aboutTea.setMaxLines(Integer.MAX_VALUE);
            }
        });
        rose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upro.setVisibility(View.VISIBLE);
                aboutRose.setVisibility(View.VISIBLE);
                aboutRose.setMaxLines(Integer.MAX_VALUE);
            }
        });
        aloevera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                upa.setVisibility(View.VISIBLE);
                aboutAloevera.setVisibility(View.VISIBLE);
                aboutAloevera.setMaxLines(Integer.MAX_VALUE);
            }
        });

        upr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upr.setVisibility(View.GONE);
                aboutRice.setVisibility(View.GONE);
            }
        });
        upl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upl.setVisibility(View.GONE);
                aboutLemon.setVisibility(View.GONE);
            }
        });
        upw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upw.setVisibility(View.GONE);
                aboutWheat.setVisibility(View.GONE);
            }
        });
        upm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upm.setVisibility(View.GONE);
                aboutMirch.setVisibility(View.GONE);
            }
        });
        upt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upt.setVisibility(View.GONE);
                aboutTomato.setVisibility(View.GONE);
            }
        });
        upma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upma.setVisibility(View.GONE);
                aboutMaize.setVisibility(View.GONE);
            }
        });
        ups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ups.setVisibility(View.GONE);
                aboutSugercane.setVisibility(View.GONE);
            }
        });
        upc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upc.setVisibility(View.GONE);
                aboutCoffee.setVisibility(View.GONE);
            }
        });
        upte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upte.setVisibility(View.GONE);
                aboutTea.setVisibility(View.GONE);
            }
        });
        upro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upro.setVisibility(View.GONE);
                aboutRose.setVisibility(View.GONE);
            }
        });
        upa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                upa.setVisibility(View.GONE);
                aboutAloevera.setVisibility(View.GONE);
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
        intent = new Intent(Plant.this, Info.class);
        startActivity(intent);
    }
}
