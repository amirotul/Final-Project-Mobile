package com.example.aplikasimeme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityProdukSatu extends AppCompatActivity {

    Button btnbeli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produksatu);

        btnbeli = (Button) findViewById(R.id.btnbeli);

        btnbeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produk = new Intent(ActivityProdukSatu.this, CheckoutActivity.class);
                startActivity(produk);
            }
        });

    }
}
