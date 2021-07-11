package com.example.aplikasimeme.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasimeme.HubungiActivity;
import com.example.aplikasimeme.Model.ModelHubungi;
import com.example.aplikasimeme.R;

import java.util.List;


public class AdapterHubungi extends RecyclerView.Adapter<AdapterHubungi.HolderData> {
    private List<ModelHubungi> mItems ;
    private Context context;

    public AdapterHubungi(Context context, List<ModelHubungi> items)
    {
        this.mItems = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_hub,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelHubungi md  = mItems.get(position);
        holder.tvnama.setText(md.getNama());
        holder.tvemail.setText(md.getEmail());
        holder.tvpesan.setText(md.getMessage());

        holder.md = md;


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class HolderData extends RecyclerView.ViewHolder
    {
        TextView tvnama, tvemail, tvsubject, tvpesan;
        ModelHubungi md;

        public  HolderData (View view)
        {
            super(view);

            tvnama = (TextView) view.findViewById(R.id.nama);
            tvemail = (TextView) view.findViewById(R.id.email);
            tvsubject = (TextView) view.findViewById(R.id.subject);
            tvpesan = (TextView) view.findViewById(R.id.pesan);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent update = new Intent(context, HubungiActivity.class);
                    update.putExtra("update",1);
                    update.putExtra("name",md.getNama());
                    update.putExtra("email",md.getEmail());
                    update.putExtra("message",md.getMessage());

                    context.startActivity(update);
                }
            });
        }
    }
}
