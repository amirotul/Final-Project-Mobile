package com.example.aplikasimeme.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasimeme.CheckoutActivity;
import com.example.aplikasimeme.Model.ModelCheckout;
import com.example.aplikasimeme.R;

import java.util.List;


public class AdapterCheckout extends RecyclerView.Adapter<AdapterCheckout.HolderData> {
    private List<ModelCheckout> mItems ;
    private Context context;

    public AdapterCheckout(Context context, List<ModelCheckout> items)
    {
        this.mItems = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelCheckout md  = mItems.get(position);
        holder.tvproduk.setText(md.getProduk());
        holder.tvjumlah.setText(md.getJumlah());
        holder.tvtotal.setText(md.getTotal());
        holder.tvnama.setText(md.getNama());
        holder.tvalamat.setText(md.getAlamat());
        holder.tvnohp.setText(md.getNohp());

        holder.md = md;


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class HolderData extends RecyclerView.ViewHolder
    {
        TextView tvproduk, tvjumlah, tvtotal, tvnama, tvalamat, tvnohp;
        ModelCheckout md;

        public  HolderData (View view)
        {
            super(view);

            tvproduk = (TextView) view.findViewById(R.id.produk);
            tvjumlah = (TextView) view.findViewById(R.id.jumlah);
            tvtotal = (TextView) view.findViewById(R.id.total);
            tvnama = (TextView) view.findViewById(R.id.nama);
            tvalamat = (TextView) view.findViewById(R.id.alamat);
            tvnohp = (TextView) view.findViewById(R.id.nohp);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent update = new Intent(context, CheckoutActivity.class);
                    update.putExtra("update",1);
                    update.putExtra("produk",md.getProduk());
                    update.putExtra("jumlah",md.getJumlah());
                    update.putExtra("total",md.getTotal());
                    update.putExtra("nama",md.getNama());
                    update.putExtra("alamat",md.getAlamat());
                    update.putExtra("nohp",md.getNohp());

                    context.startActivity(update);
                }
            });
        }
    }
}
