package com.herpan.kotajalutour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.Exclude;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.MyViewHolder> {

    Context context;
    ArrayList<Wisata> wisata;
    private OnItemClickListener mListener;



    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public AdapterWisata(Context c, ArrayList<Wisata> w){
        context = c;
        wisata = w;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row_wisata,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nama_wisata.setText(wisata.get(position).getNama_wisata());
        Glide.with(context).load(wisata.get(position).getGambar()).fitCenter().crossFade().into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return wisata.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView nama_wisata;

        public MyViewHolder(View itemView) {
            super(itemView);
            nama_wisata= (TextView) itemView.findViewById(R.id.nama_wisata);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);
            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener !=null){
                        int position = getAdapterPosition();
                        if(position !=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }

                    }
                }
            }));

        }
    }


}
