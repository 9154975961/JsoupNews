package com.example.jsoupnews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private Document doc;
    private String url = "https://lenta.ru/";
    private Runnable runnable;
    private Thread secondThread;

    private TextView textView0, textView1, textView2
            ,textView3, textView4, textView5, textView6
            ,textView7, textView8, textView9, textView10;

    private ImageView iv1, iv2, iv3, iv4, iv5, iv6
            , iv7, iv8, iv9, iv10;

    public static int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView0 = findViewById(R.id.tv_Main0);

        textView1 = findViewById(R.id.tv_Main1);
        iv1 = findViewById(R.id.iv1);
        iv1.setClipToOutline(true);
        View ll1 = findViewById(R.id.ll1);
        View.OnClickListener ll1GoTo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Ll1.class);
                startActivity(intent);
                page = 1;
            }
        };
        ll1.setOnClickListener(ll1GoTo);

        textView2 = findViewById(R.id.tv_Main2);
        iv2 = findViewById(R.id.iv2);
        iv2.setClipToOutline(true);

        textView3 = findViewById(R.id.tv_Main3);
        iv3 = findViewById(R.id.iv3);
        iv3.setClipToOutline(true);

        textView4 = findViewById(R.id.tv_Main4);
        iv4 = findViewById(R.id.iv4);
        iv4.setClipToOutline(true);

        textView5 = findViewById(R.id.tv_Main5);
        iv5 = findViewById(R.id.iv5);
        iv5.setClipToOutline(true);

        textView6 = findViewById(R.id.tv_Main6);
        iv6 = findViewById(R.id.iv6);
        iv6.setClipToOutline(true);

        textView7 = findViewById(R.id.tv_Main7);
        iv7 = findViewById(R.id.iv7);
        iv7.setClipToOutline(true);

        textView8 = findViewById(R.id.tv_Main8);
        iv8 = findViewById(R.id.iv8);
        iv8.setClipToOutline(true);

        textView9 = findViewById(R.id.tv_Main9);
        iv9 = findViewById(R.id.iv9);
        iv9.setClipToOutline(true);

        textView10 = findViewById(R.id.tv_Main10);
        iv10 = findViewById(R.id.iv10);
        iv10.setClipToOutline(true);


        init();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        textView0.setText(doc.title());

        Elements newsAll = doc.select("div.last24");

        Element newpaper = newsAll.get(0);
        Elements qwerty = newpaper.children();

        int count = newpaper.childNodeSize();

        for (int i = 0; i < count; i++) {
            Links.addLinks(qwerty.get(i).select("a").attr("href").toLowerCase());
        }

        textView1.setText(qwerty.get(1).text());
        Picasso.get().load(qwerty.get(1).children().get(0).select("img").attr("src")).into(iv1);

        if (count>2) {
            textView2.setText(qwerty.get(2).text());
            Picasso.get().load(qwerty.get(2).children().get(0).select("img").attr("src")).into(iv2);

            View ll2 = findViewById(R.id.ll2);
            View.OnClickListener ll2GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 2;
                }
            };
            ll2.setOnClickListener(ll2GoTo);
        }
        if (count>3) {
            textView3.setText(qwerty.get(3).text());
            Picasso.get().load(qwerty.get(3).children().get(0).select("img").attr("src")).into(iv3);

            View ll3 = findViewById(R.id.ll3);
            View.OnClickListener ll3GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 3;
                }
            };
            ll3.setOnClickListener(ll3GoTo);

        }
        if (count>4) {
            textView4.setText(qwerty.get(4).text());
            Picasso.get().load(qwerty.get(4).children().get(0).select("img").attr("src")).into(iv4);

            View ll4 = findViewById(R.id.ll4);
            View.OnClickListener ll4GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 4;
                }
            };
            ll4.setOnClickListener(ll4GoTo);

        }
        if (count>5) {
            textView5.setText(qwerty.get(5).text());
            Picasso.get().load(qwerty.get(5).children().get(0).select("img").attr("src")).into(iv5);

            View ll5 = findViewById(R.id.ll5);
            View.OnClickListener ll5GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 5;
                }
            };
            ll5.setOnClickListener(ll5GoTo);

        }
        if (count>6) {
            textView6.setText(qwerty.get(6).text());
            Picasso.get().load(qwerty.get(6).children().get(0).select("img").attr("src")).into(iv6);

            View ll6 = findViewById(R.id.ll6);
            View.OnClickListener ll6GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 6;
                }
            };
            ll6.setOnClickListener(ll6GoTo);

        }
        if (count>7) {
            textView7.setText(qwerty.get(7).text());
            Picasso.get().load(qwerty.get(7).children().get(0).select("img").attr("src")).into(iv7);

            View ll7 = findViewById(R.id.ll7);
            View.OnClickListener ll7GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 7;
                }
            };
            ll7.setOnClickListener(ll7GoTo);

        }
        if (count>8) {
            textView8.setText(qwerty.get(8).text());
            Picasso.get().load(qwerty.get(8).children().get(0).select("img").attr("src")).into(iv8);

            View ll8 = findViewById(R.id.ll8);
            View.OnClickListener ll8GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 8;
                }
            };
            ll8.setOnClickListener(ll8GoTo);
        }
        if (count>9) {
            textView9.setText(qwerty.get(9).text());
            Picasso.get().load(qwerty.get(9).children().get(0).select("img").attr("src")).into(iv9);

            View ll9 = findViewById(R.id.ll9);
            View.OnClickListener ll9GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 9;
                }
            };
            ll9.setOnClickListener(ll9GoTo);

        }
        if (count>10) {
            textView10.setText (qwerty.get(10).text());
            Picasso.get().load(qwerty.get(10).children().get(0).select("img").attr("src")).into(iv10);

            View ll10 = findViewById(R.id.ll10);
            View.OnClickListener ll10GoTo = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Ll1.class);
                    startActivity(intent);
                    page = 10;
                }
            };
            ll10.setOnClickListener(ll10GoTo);

        }

    }

    public void init (){
        runnable = new Runnable() {
            @Override
            public void run() {
                getWeb();
            }
        };
        secondThread = new Thread(runnable);
        secondThread.start();
    }

    public void getWeb(){
        try {
            doc = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
