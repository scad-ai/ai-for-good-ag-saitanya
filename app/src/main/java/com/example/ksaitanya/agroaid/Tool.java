package com.example.ksaitanya.agroaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Tool extends Activity {
    Button b,pb,ab,bb,wb,hb,fb,hob,rb,sb,mb;
    TextView pt,at,bt,wt,ht,ft,hot,rt,st,mt;
    ImageView ppic,apic,bpic,wpic,hpic,fpic,hopic,rpic,spic,mpic;
    ImageButton pup,aup,bup,wup,hup,fup,houp,rup,sup,mup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool);
        addListenerOnButton();
        content();
    }

    private void content() {
        pb = (Button) findViewById(R.id.pb);
        ab = (Button) findViewById(R.id.ab);
        bb = (Button) findViewById(R.id.bb);
        wb = (Button) findViewById(R.id.wb);
        hb = (Button) findViewById(R.id.hb);
        fb = (Button) findViewById(R.id.fb);
        hob = (Button) findViewById(R.id.hob);
        rb = (Button) findViewById(R.id.rb);
        sb = (Button) findViewById(R.id.sb);
        mb = (Button) findViewById(R.id.mb);

        ppic = (ImageView) findViewById(R.id.ppic);
        apic = (ImageView) findViewById(R.id.apic);
        bpic = (ImageView) findViewById(R.id.bpic);
        wpic = (ImageView) findViewById(R.id.wpic);
        hpic = (ImageView) findViewById(R.id.hpic);
        fpic = (ImageView) findViewById(R.id.fpic);
        hopic = (ImageView) findViewById(R.id.hopic);
        rpic = (ImageView) findViewById(R.id.rpic);
        spic = (ImageView) findViewById(R.id.spic);
        mpic = (ImageView) findViewById(R.id.mpic);

        pt = (TextView) findViewById(R.id.pt);
        at = (TextView) findViewById(R.id.at);
        bt = (TextView) findViewById(R.id.bt);
        wt = (TextView) findViewById(R.id.wt);
        ht = (TextView) findViewById(R.id.ht);
        ft = (TextView) findViewById(R.id.ft);
        hot = (TextView) findViewById(R.id.hot);
        rt = (TextView) findViewById(R.id.rt);
        st = (TextView) findViewById(R.id.st);
        mt = (TextView) findViewById(R.id.mt);

        pup = (ImageButton) findViewById(R.id.pup);
        aup = (ImageButton) findViewById(R.id.aup);
        bup = (ImageButton) findViewById(R.id.bup);
        wup = (ImageButton) findViewById(R.id.wup);
        hup = (ImageButton) findViewById(R.id.hup);
        fup = (ImageButton) findViewById(R.id.fup);
        houp = (ImageButton) findViewById(R.id.houp);
        rup = (ImageButton) findViewById(R.id.rup);
        sup = (ImageButton) findViewById(R.id.sup);
        mup = (ImageButton) findViewById(R.id.mup);

        pb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pup.setVisibility(View.VISIBLE);
                pt.setVisibility(View.VISIBLE);
                pt.setMaxLines(Integer.MAX_VALUE);
                ppic.setVisibility(View.VISIBLE);
            }
        });
        ab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                aup.setVisibility(View.VISIBLE);
                at.setVisibility(View.VISIBLE);
                at.setMaxLines(Integer.MAX_VALUE);
                apic.setVisibility(View.VISIBLE);
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bup.setVisibility(View.VISIBLE);
                bt.setVisibility(View.VISIBLE);
                bt.setMaxLines(Integer.MAX_VALUE);
                bpic.setVisibility(View.VISIBLE);
            }
        });
        wb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wup.setVisibility(View.VISIBLE);
                wt.setVisibility(View.VISIBLE);
                wt.setMaxLines(Integer.MAX_VALUE);
                wpic.setVisibility(View.VISIBLE);
            }
        });
        hb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hup.setVisibility(View.VISIBLE);
                ht.setVisibility(View.VISIBLE);
                ht.setMaxLines(Integer.MAX_VALUE);
                hpic.setVisibility(View.VISIBLE);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                fup.setVisibility(View.VISIBLE);
                ft.setVisibility(View.VISIBLE);
                ft.setMaxLines(Integer.MAX_VALUE);
                fpic.setVisibility(View.VISIBLE);
            }
        });
        hob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                houp.setVisibility(View.VISIBLE);
                hot.setVisibility(View.VISIBLE);
                hot.setMaxLines(Integer.MAX_VALUE);
                hopic.setVisibility(View.VISIBLE);
            }
        });
        rb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                rup.setVisibility(View.VISIBLE);
                rt.setVisibility(View.VISIBLE);
                rt.setMaxLines(Integer.MAX_VALUE);
                rpic.setVisibility(View.VISIBLE);
            }
        });
        sb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sup.setVisibility(View.VISIBLE);
                st.setVisibility(View.VISIBLE);
                st.setMaxLines(Integer.MAX_VALUE);
                spic.setVisibility(View.VISIBLE);
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mup.setVisibility(View.VISIBLE);
                mt.setVisibility(View.VISIBLE);
                mt.setMaxLines(Integer.MAX_VALUE);
                mpic.setVisibility(View.VISIBLE);
            }
        });
        pup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pup.setVisibility(View.GONE);
                pt.setVisibility(View.GONE);
                ppic.setVisibility(View.GONE);
            }
        });
        aup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aup.setVisibility(View.GONE);
                at.setVisibility(View.GONE);
                apic.setVisibility(View.GONE);
            }
        });
        bup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bup.setVisibility(View.GONE);
                bt.setVisibility(View.GONE);
                bpic.setVisibility(View.GONE);
            }
        });
        wup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wup.setVisibility(View.GONE);
                wt.setVisibility(View.GONE);
                wpic.setVisibility(View.GONE);
            }
        });
        hup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hup.setVisibility(View.GONE);
                ht.setVisibility(View.GONE);
                hpic.setVisibility(View.GONE);
            }
        });
        fup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fup.setVisibility(View.GONE);
                ft.setVisibility(View.GONE);
                fpic.setVisibility(View.GONE);
            }
        });
        houp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                houp.setVisibility(View.GONE);
                hot.setVisibility(View.GONE);
                hopic.setVisibility(View.GONE);
            }
        });
        rup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rup.setVisibility(View.GONE);
                rt.setVisibility(View.GONE);
                rpic.setVisibility(View.GONE);
            }
        });
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sup.setVisibility(View.GONE);
                st.setVisibility(View.GONE);
                spic.setVisibility(View.GONE);
            }
        });
        mup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mup.setVisibility(View.GONE);
                mt.setVisibility(View.GONE);
                mpic.setVisibility(View.GONE);
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
        intent = new Intent(Tool.this, Info.class);
        startActivity(intent);
    }
}
