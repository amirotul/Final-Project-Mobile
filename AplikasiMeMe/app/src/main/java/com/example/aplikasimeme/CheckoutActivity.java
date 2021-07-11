package com.example.aplikasimeme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aplikasimeme.Util.AppController;
import com.example.aplikasimeme.Util.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CheckoutActivity extends AppCompatActivity {

    EditText produk, jumlah, harga, total, nama, nohp, alamat, ongkir;
    Button hitung, btnlanjut, btnbatal;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        produk = (EditText) findViewById(R.id.inp_produk);
        jumlah = (EditText) findViewById(R.id.inp_jumlah);
        harga = (EditText) findViewById(R.id.inp_harga);
        total = (EditText) findViewById(R.id.inp_total);
        nama = (EditText) findViewById(R.id.inp_nama);
        nohp = (EditText) findViewById(R.id.inp_nohp);
        alamat = (EditText) findViewById(R.id.inp_alamat);
        ongkir = (EditText) findViewById(R.id.inp_ongkir);

        hitung = (Button) findViewById(R.id.hitung);
        btnlanjut = (Button) findViewById(R.id.btnlanjut);
        btnbatal = (Button) findViewById(R.id.btnbatal);
        pd = new ProgressDialog(CheckoutActivity.this);

        /*get data from intent*/
        Intent data = getIntent();
        final int update = data.getIntExtra("update", 0);
        String intent_nama = data.getStringExtra("produk");
        String intent_jumlah = data.getStringExtra("jumlah");
        String intent_total = data.getStringExtra("total");
        String intent_nama_pembeli = data.getStringExtra("nama");
        String intent_alamat_pembeli = data.getStringExtra("alamat");
        String intent_no_pembeli = data.getStringExtra("nohp");
        /*end get data from intent*/


        /*kondisi update / insert*/
        if (update == 1) {
            btnlanjut.setText("Update Data");
            produk.setText(intent_nama);
            jumlah.setText(intent_jumlah);
            total.setText(intent_total);
            nama.setText(intent_nama_pembeli);
            alamat.setText(intent_alamat_pembeli);
            nohp.setText(intent_no_pembeli);

        }

        btnlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (update == 1) {
                    Update_data();
                } else {
                    simpanData();
                }
            }
        });

        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(CheckoutActivity.this, MainActivity.class);
                startActivity(main);
            }
        });

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((jumlah.getText().length() > 0) &&
                        (harga.getText().length() > 0) &&
                        (ongkir.getText().length() > 0)) {
                    double jumlah1 = Double.parseDouble(jumlah.getText().toString());
                    double harga1 = Double.parseDouble(harga.getText().toString());
                    double ongkir1 = Double.parseDouble(ongkir.getText().toString());
                    double result = jumlah1 * harga1 + ongkir1;
                    total.setText(Double.toString(result));
                } else {
                    Toast toast = Toast.makeText(CheckoutActivity.this, "Mohon Masukkan jumlah dan harga produk", Toast.LENGTH_LONG);

                    toast.show();
                }
            }
        });

    }


    private void Update_data() {
        pd.setMessage("Update Data");
        pd.setCancelable(false);
        pd.show();

        StringRequest updateReq = new StringRequest(Request.Method.POST, Server.URL_UPDATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.cancel();
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(CheckoutActivity.this, "pesan : Pesanan Anda Berhasil", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity(new Intent(CheckoutActivity.this, MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Toast.makeText(CheckoutActivity.this, "pesan : Pesanan Anda Gagal", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("produk", produk.getText().toString());
                map.put("jumlah", jumlah.getText().toString());
                map.put("total", total.getText().toString());
                map.put("nama", nama.getText().toString());
                map.put("alamat", alamat.getText().toString());
                map.put("nohp", nohp.getText().toString());

                return map;
            }
        };

        AppController.getInstance().addToRequestQueue(updateReq);
    }

    private void simpanData()
    {
        pd.setMessage("Menyimpan Data");
        pd.setCancelable(false);
        pd.show();

        StringRequest sendData = new StringRequest(Request.Method.POST, Server.URL_INSERT_PESANAN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.cancel();
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(CheckoutActivity.this, "pesan : "+   res.getString("message") , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity( new Intent(CheckoutActivity.this,MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Toast.makeText(CheckoutActivity.this, "pesan : Gagal melakukan registrasi", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("produk", produk.getText().toString());
                map.put("jumlah", jumlah.getText().toString());
                map.put("total", total.getText().toString());
                map.put("nama", nama.getText().toString());
                map.put("alamat", alamat.getText().toString());
                map.put("nohp", nohp.getText().toString());

                return map;
            }
        };

        AppController.getInstance().addToRequestQueue(sendData);
    }
}

