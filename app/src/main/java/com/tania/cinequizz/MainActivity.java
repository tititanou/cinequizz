package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("CineQuizz");
        msgTextView = findViewById(R.id.msgTextView);
        validateButton = findViewById(R.id.validateButton);
        question = findViewById(R.id.questionTextView);

        Answer answer = new Answer (R.drawable.poudlard, "De quel film est tirée cette image ?","Harry Potter", "robinonekenoby", "tania");

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
     * This function checks the answer.
     * @param answered type : CharSequence. From radioButton.getText.
     * return nothing. but display a message and swap the button 'validate' to 'question suivante'.
     */

    private void checkAnswer(CharSequence answered) {
        validateButton.setText("Question suivante");
        if (answered.equals("Harry Potter")) {
            msgTextView.setText("Bonne réponse !");
        } else {
            msgTextView.setText("La bonne réponse était \"Harry Potter\".");
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
