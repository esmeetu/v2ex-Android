package com.firefly.v2ex;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firefly.v2ex.Topics.HotTopic;
import com.firefly.v2ex.net.Api;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by wangyapeng on 2017/8/28.
 */

public class MainActivity extends AppCompatActivity {

//    TextView textView;
    ListView listView;

    Button button;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
//                    textView.setText((String) msg.obj);
                    try {
                        Type listType = new TypeToken<List<HotTopic>>(){}.getType();
//                        HotTopic[] topics = new Gson().fromJson((String) msg.obj, HotTopic[].class);
                        final List<HotTopic> topicItems = new Gson().fromJson((String) msg.obj, listType);
//                        TopicAdapter adapter = new TopicAdapter(MainActivity.this, R.layout.topic_item, topicItems);
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.hots);
                        StaggeredGridLayoutManager layoutManager =
                                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//                        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//                        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyclerView.setLayoutManager(layoutManager);
                        HotAdapter adapter = new HotAdapter(topicItems);
                        Log.d("size: ", String.valueOf(adapter.getItemCount()));
                        recyclerView.setAdapter(adapter);
                        //this is a java object
                    }catch (JsonParseException e) {
                        Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    break;
                case 2:
//                    textView.setText((String) msg.obj);
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = (TextView) findViewById(R.id.textview);
//        listView = (ListView) findViewById(R.id.hots);
        button = (Button) findViewById(R.id.get_data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getData();
                hotTask ht = new hotTask();
                ht.execute();
            }
        });
    }

    private class hotTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            Api api = new Api();
            try {
                String hotsJsonResponse = api.getHots();
                return hotsJsonResponse;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            try {
                Type listType = new TypeToken<List<HotTopic>>(){}.getType();
//                        HotTopic[] topics = new Gson().fromJson((String) msg.obj, HotTopic[].class);
                final List<HotTopic> topicItems = new Gson().fromJson((String) o, listType);
//                        TopicAdapter adapter = new TopicAdapter(MainActivity.this, R.layout.topic_item, topicItems);
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.hots);
                StaggeredGridLayoutManager layoutManager =
                        new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//                        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//                        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);
                HotAdapter adapter = new HotAdapter(topicItems);
                Log.d("size: ", String.valueOf(adapter.getItemCount()));
                recyclerView.setAdapter(adapter);
                //this is a java object
            }catch (JsonParseException e) {
                Toast.makeText(MainActivity.this, o.toString(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
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
