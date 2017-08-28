package com.firefly.v2ex;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firefly.v2ex.Topics.HotTopics;
import com.firefly.v2ex.net.Api;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by wangyapeng on 2017/8/28.
 */

public class MainActivity extends AppCompatActivity{

    TextView textView;

    Button button;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    textView.setText((String) msg.obj);
                    HotTopics topics = new Gson().fromJson((String) msg.obj, HotTopics.class);
                    //this is a java object
                    break;
                case 2:
                    textView.setText((String) msg.obj);
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.get_data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Api api = new Api();
                try {
                    String hotsJsonResponse = api.getHots();
                    handler.sendMessage(Message.obtain(handler, 1, hotsJsonResponse));
                } catch (IOException e) {
                    e.printStackTrace();
                    handler.sendMessage(Message.obtain(handler, 2, e.getMessage()));
                }
            }
        }).start();
    }
}
