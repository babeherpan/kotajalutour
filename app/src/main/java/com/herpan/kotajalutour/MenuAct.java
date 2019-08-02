package com.herpan.kotajalutour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuAct extends AppCompatActivity {
    LinearLayout btn_wst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_wst=findViewById(R.id.btn_wst);
        btn_wst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wisata = new Intent(MenuAct.this, ListWisata.class);
                startActivity(wisata);
            }
        });
    }
}
