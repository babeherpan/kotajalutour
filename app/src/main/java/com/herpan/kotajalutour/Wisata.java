package com.herpan.kotajalutour;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Wisata {
    private String nama_wisata;
    private String gambar;
    private String deskripsi;
    private String latirude;
    private String longitude;

    public Wisata() {
    }

    public Wisata(String nama_wisata, String gambar, String deskripsi, String latitude, String longitude) {
        this.nama_wisata = nama_wisata;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
        this.latirude = latitude;
        this.longitude = longitude;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama_wisata", nama_wisata);
        result.put("gamabar", gambar);
        result.put("deskripsi",deskripsi );
        result.put("latirude",latirude );
        result.put("longitude",deskripsi );
        return result;
    }

    public String getNama_wisata() {
        return nama_wisata;
    }

    public void setNama_wisata(String nama_wisata) {
        this.nama_wisata = nama_wisata;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLatirude() {
        return latirude;
    }

    public void setLatirude(String latitude) {
        this.latirude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
