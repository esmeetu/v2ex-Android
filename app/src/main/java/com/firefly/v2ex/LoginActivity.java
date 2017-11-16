package com.firefly.v2ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 9/16/17.
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.login_btn)
    Button loginBtn;

    @BindView(R.id.register_btn)
    Button registerBtn;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAlreadyRegister()) {
                    Toast.makeText(v.getContext(), "Please register first!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String name = username.getText().toString();
                String pwd = password.getText().toString();
                if (TextUtils.isEmpty(name)
                        || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(v.getContext(), "Please input username and password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (name.equals(sharedPreferences.getString("username", ""))
                        && pwd.equals(sharedPreferences.getString("password", ""))) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                    sharedPreferences.edit().putBoolean("isLogin", true).commit();
                    finish();
                } else {
                    Toast.makeText(v.getContext(), "username and password is wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAlreadyRegister()) {
                    Toast.makeText(v.getContext(), "Please login!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(username.getText().toString())
                        || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(v.getContext(), "Please input username and password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                sharedPreferences.edit().putString("username", username.getText().toString()).commit();
                sharedPreferences.edit().putString("password", password.getText().toString()).commit();
                sharedPreferences.edit().putBoolean("isRegister", true).commit();
            }
        });
    }


    private boolean isAlreadyRegister() {
        return sharedPreferences.getBoolean("isRegister", false);
    }
}
