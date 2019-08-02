package com.herpan.kotajalutour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListWisata extends AppCompatActivity implements AdapterWisata.OnItemClickListener{
    public static final String EXTRA_URL = "gambar";
    public static final String EXTRA_CREATOR = "nama_wisata";
    public  static final String EXTRA_DESKRIPSI = "deskripsi";
    public  static final String EXTRA_LONGITUDE = "longitude";
    public  static final String EXTRA_LATIRUDE = "latirude";



    DatabaseReference reference;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<Wisata> list;
    AdapterWisata adapterWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);
        progressBar = findViewById(R.id.progess);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Wisata>();

        reference = FirebaseDatabase.getInstance().getReference().child("Wisata");
        reference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Wisata w = dataSnapshot1.getValue(Wisata.class);
                    list.add(w);
                }

                adapterWisata = new AdapterWisata(ListWisata.this, list);
                recyclerView.setAdapter(adapterWisata);
                adapterWisata.setOnItemClickListener(ListWisata.this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Intent detail = new Intent(this, DetailWisata.class);
        Wisata clik = list.get(position);

        detail.putExtra(EXTRA_URL, clik.getGambar());
        detail.putExtra(EXTRA_CREATOR, clik.getNama_wisata());
        detail.putExtra(EXTRA_DESKRIPSI, clik.getDeskripsi());
        startActivity(detail);
    }
}
