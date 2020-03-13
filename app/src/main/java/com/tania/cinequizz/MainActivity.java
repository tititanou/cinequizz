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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final int STATE_INIT = 1;
    private static final int STATE_VALIDATED = 2;
    private Button validateButton;
    private TextView msgTextView;
    private TextView question;
    private int index;
    private int score;
    private int state=STATE_INIT;
    private String level;
    ArrayList<Answer> quizz = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.index = getIntent().getIntExtra("index", 0);
        quizz = getIntent().getParcelableArrayListExtra("quizz");
        score = getIntent().getIntExtra("score", 0);
        final int questionNumber = index + 1;
        setTitle("CineQuizz \n" + questionNumber + "/" + quizz.size());


        /**
         * we set the actual score of the game
         */

        TextView verif = findViewById(R.id.textView);
        verif.setText("Votre score est de " + score);


        msgTextView = findViewById(R.id.msgTextView);
        validateButton = findViewById(R.id.validateButton);
        question = findViewById(R.id.questionTextView);

        /**
         *  we choose an object (an answer) in our list
         */

        final Answer answerChoosed = quizz.get(index);


        /**
         * we set the question to text view
         */
        question.setText(answerChoosed.getQuestion());


        /**
         * check the type of our data and set the media to the media view
         */
        if (mediaTest(answerChoosed).equals("audio")) {
            Button buttonPlayer = findViewById(R.id.buttonPlayer);
            buttonPlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playMedia(answerChoosed);

                }
            });

        } else if (mediaTest(answerChoosed).equals("image")) {
            ImageView filmImageView = findViewById(R.id.filmImageView);
            filmImageView.setImageResource(answerChoosed.getMedia());
            filmImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageZoom(answerChoosed);
                }
            });

        }

        /**
         * 1) we shuffle the order of our questions
         * 2) we set the answers to the view
         */
        List<String> answerToDisplay = shuffleAnswers(answerChoosed);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            ((RadioButton) radioGroup.getChildAt(i)).setText(String.valueOf(answerToDisplay.get(i)));
        }


        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == STATE_INIT) {
                    TextView tv = findViewById(R.id.textView);
                    tv.setVisibility(View.INVISIBLE);
                    int id = radioGroup.getCheckedRadioButtonId();
                    if (id==-1) {
                        Toast.makeText(MainActivity.this, "Veuillez selectionner une réponse!", Toast.LENGTH_SHORT)
                                .show();
                        return;
                    }
                    RadioButton radioButton = findViewById(id);
                    CharSequence radioAnswer = radioButton.getText();
                    checkAnswer(radioAnswer, answerChoosed);
                    if (questionNumber == quizz.size()) {
                        validateButton.setText("Afficher les résultats");
                    }else {
                    validateButton.setText("Question suivante");
                    }
                    state = STATE_VALIDATED;


                } else if (state == STATE_VALIDATED) {
                    if (questionNumber == quizz.size()) {
                        level = quizz.get(index).level;
                        Intent end = new Intent(MainActivity.this, EndActivity.class);
                        end.putExtra("index", index);
                        end.putExtra("quizz size", quizz.size());
                        end.putExtra("score", score);
                        end.putExtra("level", level);
                        startActivity(end);
                        finish();
                    } else {
                        TextView tv = findViewById(R.id.textView);
                        tv.setVisibility(View.INVISIBLE);
                        index = index + 1;
                        state = STATE_INIT;
                        final Intent intendo = new Intent(MainActivity.this, MainActivity.class);
                        intendo.putExtra("state", state);
                        intendo.putExtra("index", index);
                        intendo.putExtra("quizz", quizz);
                        intendo.putExtra("score", score);
                        startActivity(intendo);
                        finish();
                    }

                }
            }
        });

    }


    /**
     * grows image in other activity
     */
    private void imageZoom(Answer answer) {
        final Intent intent = new Intent(this, ZoomActivity.class);
        intent.putExtra("image", answer);
        startActivity(intent);
    }


    /**
     * This function checks the answer.
     *
     * @param answered type : CharSequence. From radioButton.getText.
     *                 return nothing. but display a message and swap the button 'validate' to 'question suivante'.
     */

    private void checkAnswer(CharSequence answered, Answer solution) {
        if (answered.equals(solution.getRightAnswer())) {
            msgTextView.setText("Bonne réponse !");
            score = score + 1;
        } else {
            msgTextView.setText("La bonne réponse était \"" + solution.getRightAnswer() + "\".");
        }
    }

    private void nextQuestion() {
        validateButton.setText("Question suivante");

    }


    /**
     * This function initialize the game
     *
     * @return a list of answers
     */
    public List<String> shuffleAnswers(Answer answer) {
        // on met les réponses dans un tab
        ArrayList<String> answered = new ArrayList<String>();
        answered.add(answer.getRightAnswer());
        answered.add(answer.getFalseAnswer1());
        answered.add(answer.getFalseAnswer2());
        Collections.shuffle(answered);
        return answered;
    }


    /**
     * if audio media shows only button play else shows only image media
     */
    private String mediaTest(Answer answer) {
        if (answer.getMediaType().equals("audio")) {
            findViewById(R.id.filmImageView).setVisibility(View.INVISIBLE);
            findViewById(R.id.buttonPlayer).setVisibility(View.VISIBLE);
            return "audio";

        } else {
            findViewById(R.id.filmImageView).setVisibility(View.VISIBLE);
            findViewById(R.id.buttonPlayer).setVisibility(View.INVISIBLE);
            return "image";
        }
    }


    /**
     * This function play the media in raw
     */
    private void playMedia(Answer answer) {
        MediaPlayer mp = MediaPlayer.create(this, answer.getMedia());
        mp.start();
    }

}
