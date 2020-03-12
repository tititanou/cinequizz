package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView hV = findViewById(R.id.HomeView);
        hV.setText("CINE QUIZ");
        TextView hv = findViewById(R.id.HomeView);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/cinema_st.ttf");
        hv.setTypeface(custom_font);
        goToQuiz();
        goToAbout();
    }

    private void goToQuiz() {
        final Intent intent = new Intent(this,MainActivity.class);

        Button buttonQuiz = findViewById(R.id.ButtonQuiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void goToAbout() {
        final Intent intent = new Intent(this,AboutActivity.class);

        Button aboutBtn = findViewById(R.id.AboutBtn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
