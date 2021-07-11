package com.example.aplikasimeme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    Button btn_logout, btn_lanjut;
    TextView txt_id, txt_username, txt_password, txt_email, txt_name;
    String id, name, username, password, email;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    public static final String TAG_PASSWORD = "password";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_name = (TextView) findViewById(R.id.txt_name);
        txt_username = (TextView) findViewById(R.id.txt_username);
        txt_password = (TextView) findViewById(R.id.txt_password);
        txt_email = (TextView) findViewById(R.id.txt_email);
        btn_logout = (Button) findViewById(R.id.btn_logout);
        btn_lanjut = (Button) findViewById(R.id.btn_lanjut);

        sharedpreferences = getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        name = getIntent().getStringExtra(TAG_NAME);
        username = getIntent().getStringExtra(TAG_USERNAME);
        password = getIntent().getStringExtra(TAG_PASSWORD);
        email = getIntent().getStringExtra(TAG_EMAIL);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(LoginActivity.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_NAME, null);
                editor.putString(TAG_USERNAME, null);
                editor.putString(TAG_PASSWORD, null);
                editor.putString(TAG_EMAIL, null);
                editor.commit();

                Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });
        btn_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produkdua = new Intent(LogoutActivity.this, MainActivity.class);
                startActivity(produkdua);
            }
        });
    }
}
