package com.example.aplikasimeme;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnbelanja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbelanja = (Button) findViewById(R.id.btnbelanja);

        btnbelanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produk = new Intent(MainActivity.this, ProdukActivity.class);
                startActivity(produk);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.hubungi) {
            startActivity(new Intent(this, HubungiActivity.class));
        } else if (item.getItemId() == R.id.produk) {
            startActivity(new Intent(this, ProdukActivity.class));
        } else if (item.getItemId() == R.id.logout) {
            startActivity(new Intent(this, LogoutActivity.class));
        } else if (item.getItemId() == R.id.profil) {
            startActivity(new Intent(this, LoginActivity.class));
        }

        return true;
    }
}