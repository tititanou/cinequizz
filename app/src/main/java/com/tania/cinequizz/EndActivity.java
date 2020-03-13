package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        float result=(score/quizzSize)*100;

        TextView resultTextView=findViewById(R.id.resultTextView);
        ImageView reussiteImageView=findViewById(R.id.reussiteImageView);
        if (result>=50){
            resultTextView.setText("Bravo! Tu as obtenu "+ result +"% de bonnes réponses.");
        }else{
            resultTextView.setText("Bouh!Tu n'as obtenu que "+result+"% de bonnes réponses.");
        }


        TextView difficultyTextView=findViewById(R.id.difficultyTextView);
        difficultyTextView.setText("niveau: "+level);

        TextView scoreTextView=findViewById(R.id.scoreTextView);
        scoreTextView.setText(score+"/"+quizzSize);



    }
}
