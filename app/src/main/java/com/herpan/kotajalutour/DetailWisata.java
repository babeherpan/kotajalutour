package com.herpan.kotajalutour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.euicc.DownloadableSubscription;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.herpan.kotajalutour.ListWisata.EXTRA_CREATOR;
import static com.herpan.kotajalutour.ListWisata.EXTRA_DESKRIPSI;
import static com.herpan.kotajalutour.ListWisata.EXTRA_LATIRUDE;
import static com.herpan.kotajalutour.ListWisata.EXTRA_LONGITUDE;
import static com.herpan.kotajalutour.ListWisata.EXTRA_URL;

public class DetailWisata extends AppCompatActivity {
    TextView btnnavigasi;
    ArrayList<Wisata> wisata;
    AdapterWisata adapterWisata;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        wisata =  new ArrayList<Wisata>();

        Intent intent = getIntent();
        String gambar = intent.getStringExtra(EXTRA_URL);
        String nama_wisata = intent.getStringExtra(EXTRA_CREATOR);
        String deskripsi = intent.getStringExtra(EXTRA_DESKRIPSI);
        final String latirude = intent.getStringExtra(EXTRA_LATIRUDE);
         final String longitude = intent.getStringExtra(EXTRA_LONGITUDE);

        final ImageView img = findViewById(R.id.gambar);
        TextView nama = findViewById(R.id.nama_wisata);
        TextView desk = findViewById(R.id.deskripsi);

        Glide.with(this).load(gambar).fitCenter().into(img);
        nama.setText(nama_wisata);
        desk.setText(deskripsi);

        btnnavigasi = findViewById(R.id.navigasi);
        btnnavigasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + longitude + "," + latirude + "");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });



    }
}
