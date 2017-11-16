package com.firefly.v2ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 9/16/17.
 */

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.image_view) ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);
        ButterKnife.bind(this);
        Picasso.with(this)
                .load("http://square.github.io/picasso/static/debug.png")
                .into(imageView);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        final TextView textView = (TextView) findViewById(R.id.text_view);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                if (!sharedPreferences.getBoolean("isLogin", false)) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                textView.setText("Welcome!");
            }
        }, 3000);
    }
}
