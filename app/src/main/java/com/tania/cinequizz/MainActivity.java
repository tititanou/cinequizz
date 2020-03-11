package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button validateButton;
    private TextView msgTextView;
    private TextView question;
    Answer answer = new Answer (R.drawable.poudlard,"image", "De quel film est tirée cette image ?","Harry Potter", "robinonekenoby", "tania");
    Answer answer2 = new Answer(R.raw.polish_oss,"audio", "De quel film est tiré cet extrait audio?","OSS 117", "Le père noël est une ordure","Need for speed");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("CineQuizz");
        msgTextView = findViewById(R.id.msgTextView);
        validateButton = findViewById(R.id.validateButton);
        question = findViewById(R.id.questionTextView);

        mediaTest();

        Button buttonPlayer = findViewById(R.id.buttonPlayer);
        buttonPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMedia();

            }
        });

        ImageView filmImageView = findViewById(R.id.filmImageView);
        filmImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageZoom();

            }
        });

        // creation des questions/reponses
        question.setText(answer.getQuestion());
        List<String> answered = init(answer);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            ((RadioButton)radioGroup.getChildAt(i)).setText(String.valueOf(answered.get(i)));
        }

        Log.i("MainActivity", "onCreate: ");
        
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int id = radioGroup.getCheckedRadioButtonId();
             RadioButton radioButton = findViewById(id);
            CharSequence radioAnswer = radioButton.getText();
             checkAnswer(radioAnswer);
            }
        });
    }

    /**
     * grows image in other activity
     */
    private void imageZoom(){
        final Intent intent = new Intent(this,ZoomActivity.class);
        intent.putExtra("image",answer);
        startActivity(intent);
    }

    /**
     * if audio media shows only button play else shows only image media
     */
    private void mediaTest(){
        if(answer.getMediaType().equals("audio")){
            findViewById(R.id.filmImageView).setVisibility(View.INVISIBLE);
            findViewById(R.id.buttonPlayer).setVisibility(View.VISIBLE);
        }else{
            findViewById(R.id.filmImageView).setVisibility(View.VISIBLE);
            findViewById(R.id.buttonPlayer).setVisibility(View.INVISIBLE);
        }

    }

    /**
     * This function play the media in raw
     */
    private void playMedia() {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.polish_oss);
        mp.start();
    }

    /**
     * This function checks the answer.
     * @param answered type : CharSequence. From radioButton.getText.
     * return nothing. but display a message and swap the button 'validate' to 'question suivante'.
     */

    private void checkAnswer(CharSequence answered) {
        validateButton.setText("Question suivante");
        if (answered.equals(answer.getRightAnswer())) {
            msgTextView.setText("Bonne réponse !");
        } else {
            msgTextView.setText("La bonne réponse était \""+answer.getRightAnswer()+"\".");
        }
    }


    /**
     * This function initialize the game
     * @return a list of answers
     */
    public List<String> init (Answer answer){
        // on met les réponses dans un tab
        ArrayList<String> answered = new ArrayList<String>();
        answered.add(answer.getRightAnswer());
        answered.add(answer.getFalseAnswer1());
        answered.add(answer.getFalseAnswer2());
        Collections.shuffle(answered);
        return answered;
    }



}
