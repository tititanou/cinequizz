package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        String versionName = BuildConfig.VERSION_NAME;
        AboutInfo aboutInfo = new AboutInfo("Ciné quiz","M Boris Cassel","Tania","Antoine","Laurent",versionName);
        TextView infoView = findViewById(R.id.infoView);
        infoView.setText(aboutInfo.toString());
        TextView versionView = findViewById(R.id.versionView);
        versionView.setText(versionName);
        goToHome();


    }

    private void goToHome() {
        final Intent intent = new Intent(this,HomeActivity.class);

        ImageView homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
