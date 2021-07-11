package com.example.aplikasimeme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity {

    Button btn_lanjut;
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
        setContentView(R.layout.activity_profil);

        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_name = (TextView) findViewById(R.id.txt_name);
        txt_username = (TextView) findViewById(R.id.txt_username);
        txt_password = (TextView) findViewById(R.id.txt_password);

        btn_lanjut = (Button) findViewById(R.id.btn_lanjut);

        sharedpreferences = getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        email = getIntent().getStringExtra(TAG_EMAIL);
        name = getIntent().getStringExtra(TAG_NAME);
        username = getIntent().getStringExtra(TAG_USERNAME);
        password = getIntent().getStringExtra(TAG_PASSWORD);


        txt_id.setText("Id : " + id);
        txt_name.setText("Nama : " + name);
        txt_email.setText("Email : " + email);
        txt_username.setText("Username : " + username);
        txt_password.setText("Password : " + password);


        btn_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produkdua = new Intent(ProfilActivity.this,MainActivity.class);
                startActivity(produkdua);
            }
        });
    }
}