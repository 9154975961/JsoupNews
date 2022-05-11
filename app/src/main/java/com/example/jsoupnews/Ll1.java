package com.example.jsoupnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Ll1 extends AppCompatActivity {

    private ImageView ivSec;
    private TextView tvSec;
    private Runnable runnable;
    private Thread secondThread;
    private Document doc;
    private String url = "https://lenta.ru/"+Links.getLinks().get(MainActivity.page);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ll1);

        ivSec = findViewById(R.id.iv_sec);
        tvSec = findViewById(R.id.tv_sec);

        tvSec.setMovementMethod(new ScrollingMovementMethod());



        init();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Elements newsAll = doc.select("div.topic-body");

        Element newpaper = newsAll.get(0);
        Elements qwerty = newpaper.children();

        tvSec.setText(newsAll.text());
        Picasso.get().load(qwerty.get(2).select("img").attr("src").toLowerCase()).into(ivSec);
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