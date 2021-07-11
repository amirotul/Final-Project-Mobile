package com.example.aplikasimeme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProdukActivity extends AppCompatActivity {

    Button btnproduk1, btnproduk2, btnproduk3, btnproduk4, btnproduk5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);

        btnproduk1 = (Button) findViewById(R.id.btnproduk1);
        btnproduk2 = (Button) findViewById(R.id.btnproduk2);
        btnproduk3 = (Button) findViewById(R.id.btnproduk3);
        btnproduk4 = (Button) findViewById(R.id.btnproduk4);
        btnproduk5 = (Button) findViewById(R.id.btnproduk5);

        btnproduk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produk = new Intent(ProdukActivity.this,ActivityProdukSatu.class);
                startActivity(produk);
            }
        });

        btnproduk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produkdua = new Intent(ProdukActivity.this,ActivityProdukDua.class);
                startActivity(produkdua);
            }
        });

        btnproduk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produktiga = new Intent(ProdukActivity.this,ActivityProdukTiga.class);
                startActivity(produktiga);
            }
        });
        btnproduk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produkempat = new Intent(ProdukActivity.this,ActivityProdukEmpat.class);
                startActivity(produkempat);
            }
        });

        btnproduk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produklima = new Intent(ProdukActivity.this,ActivityProdukLima.class);
                startActivity(produklima);
            }
        });
    }
}

