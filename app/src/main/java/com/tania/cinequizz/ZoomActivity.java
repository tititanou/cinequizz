package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ZoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        Intent srcIntent = getIntent();
        Answer film = srcIntent.getParcelableExtra("image");
        ImageView img = findViewById(R.id.imageViewZoom);
        img.setImageResource(film.getMedia());
    }
}
