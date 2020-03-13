package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class EndActivity extends AppCompatActivity {

    private int score;
    private int quizzSize;
    private String level;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);


        // niveau difficulté
        // nombre bonne reponse/total
        // %age en fonction ud nombre de bonnes réponses


        this.score = getIntent().getIntExtra("score", 0);
        this.quizzSize = getIntent().getIntExtra("quizz size", 0);
        this.level = getIntent().getStringExtra("level");

        int result=(int) (((float)score/quizzSize) * 100.f);

        TextView resultTextView=findViewById(R.id.resultTextView);
        ImageView reussiteImageView=findViewById(R.id.reussiteImageView);
        if (result>=50){
            resultTextView.setText("Bravo! Tu as obtenu "+ result +"% de bonnes réponses.");
            reussiteImageView.setImageResource(R.drawable.congrat);
        }else{
            resultTextView.setText("Bouh!Tu n'as obtenu que "+result+"% de bonnes réponses.");
            reussiteImageView.setImageResource(R.drawable.stitch);
        }


        TextView difficultyTextView=findViewById(R.id.difficultyTextView);
        difficultyTextView.setText("niveau: "+level);

        TextView scoreTextView=findViewById(R.id.scoreTextView);
        scoreTextView.setText(score+"/"+quizzSize);

        ImageView homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }
        });

    }
    private void goToHome() {
        final Intent intent = new Intent(EndActivity.this,HomeActivity.class);
        startActivity(intent);

    }
}
