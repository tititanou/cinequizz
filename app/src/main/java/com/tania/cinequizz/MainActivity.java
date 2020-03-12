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

    private static final int STATE_INIT = 1;
    private static final int STATE_VALIDATED = 2;
    private Button validateButton;
    private TextView msgTextView;
    private TextView question;
    private boolean nextQuestion = true;

    private int state = STATE_INIT;

    Answer answer1= new Answer(R.drawable.poudlard, "image", "De quel film est tirée cette image ?", "Harry Potter", "robinonekenoby", "tania");
    Answer answer2 = new Answer(R.raw.polish_oss, "audio", "De quel film est tiré cet extrait audio?", "OSS 117", "Le père noël est une ordure", "Need for speed");
    Answer answer3 = new Answer(R.drawable.avatar, "image","De quel film est tirée cette image ?","Avatar","Alien","Mars Attack");
    Answer answer4 = new Answer(R.drawable.belle_bete_cocteau,"image","De quel film est tirée cette image ?","La belle et la bête","Peau d'Âne", "Le Magicien D'Oz");
    Answer answer5 = new Answer(R.drawable.bridget_jones,"image","De quel film est tirée cette image ?","Le Journal de Bridget Jones", "Bye Bye Love","Retour a Cold Mountain";
    Answer answer6 = new Answer(R.drawable.cage_aux_folles, "image","De quel film est tirée cette image ?","La Cage aux Folles","La Cage Dorée","Le Placard")
    Answer answer7 = new Answer(R.drawable.edward_mains_argent,"image","De quel film est tirée cette image ?","Edward aux Mains D'argent", "La Reine des Neiges","Dark Shadows");
    Answer answer8 = new Answer(R.drawable.etrange_noel_mr_jack,"image","De quel film est tirée cette image ?","L'Etrange Noël de Mr.Jack","Les Noces Funèbres","Frankenweenie");
    Answer answer9 = new Answer(R.drawable.fifty_shades_grey,"image","De quel film est tirée cette image ?","50 Nuances de Grey","After","Vous Avez un Message");
    Answer answer10 = new Answer(R.drawable.grande_vadrouille,"image","De quel film est tirée cette image ?","La Grande Vadrouille","La 7eme Compagnie","Les Gendarmes à St Tropez");
    Answer answer11 = new Answer(R.drawable.kingkong,"image","De quel film est tirée cette image ?","KingKong","La Planète des Singes","Godzilla");
    Answer answer12 = new Answer(R.drawable.pretty_woman,"image","De quel film est tirée cette image ?","Pretty Woman","Le Sourire de Mona Lisa","Erine Brockovich");
    Answer answer13 = new Answer(R.drawable.mala_educacion,"image","De quel film est tirée cette image ?","La Mauvaise Education","Camping","Coup de Tête");
    Answer answer14 = new Answer(R.drawable.lauwrence_arabie,"image","De quel film est tirée cette image ?","Lauwrence D'Arabie","Ben Hûr", "Gandhi");
    Answer answer15 = new Answer(R.drawable.slumdog_millionnaire,"image","De quel film est tirée cette image ?","SlumDog Millionaire","Indian Palace","Salaam Bombay");
    Answer answer16 = new Answer(R.drawable.titanic,"image","De quel film est tirée cette image ?","Titanic","Poséidon","La Forme de l'Eau");
    Answer answer17 = new Answer(R.drawable.seigneur_des_anneaux,"image","De quel film est tirée cette image ?","Le Seigneur des Anneaux","Le Hobbit","Harry Potter");


// met en place une liste de questions

// un compteur
// une fonction qui incrémente ce compteur et chnage le texte du bouton

    public List<String> questions(){
        
    }


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

        ArrayList<Answer> quizz = new ArrayList<>();
        quizz.add(answer1);
        quizz.add(answer2);
        quizz.add(answer3);
        quizz.add(answer4);
        quizz.add(answer5);
        quizz.add(answer6);
        quizz.add(answer7);
        quizz.add(answer8);
        quizz.add(answer9);
        quizz.add(answer10);
        quizz.add(answer11);
        quizz.add(answer12);
        quizz.add(answer13);
        quizz.add(answer14);
        quizz.add(answer15);
        quizz.add(answer16);
        quizz.add(answer17);

        ImageView filmImageView = findViewById(R.id.filmImageView);
        filmImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageZoom();

            }
        });

        // creation des questions/reponses
        question.setText(answer1.getQuestion());
        List<String> answered = init(answer1);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            ((RadioButton) radioGroup.getChildAt(i)).setText(String.valueOf(answered.get(i)));
        }

        Log.i("MainActivity", "onCreate: ");

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == STATE_INIT) {
                    int id = radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = findViewById(id);
                    CharSequence radioAnswer = radioButton.getText();
                    checkAnswer(radioAnswer);
                    validateButton.setText("Question suivante");
                    state = STATE_VALIDATED;
                }
                else if (state == STATE_VALIDATED) {
                    validateButton.setText("Nouvel écran");

                }
            }
        });

    }


    /**
     * grows image in other activity
     */
    private void imageZoom() {
        final Intent intent = new Intent(this, ZoomActivity.class);
        intent.putExtra("image", answer1);
        startActivity(intent);
    }

    /**
     * if audio media shows only button play else shows only image media
     */
    private void mediaTest() {
        if (answer1.getMediaType().equals("audio")) {
            findViewById(R.id.filmImageView).setVisibility(View.INVISIBLE);
            findViewById(R.id.buttonPlayer).setVisibility(View.VISIBLE);
        } else {
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
     *
     * @param answered type : CharSequence. From radioButton.getText.
     *                 return nothing. but display a message and swap the button 'validate' to 'question suivante'.
     */

    private void checkAnswer(CharSequence answered) {
        if (answered.equals(answer1.getRightAnswer())) {
            msgTextView.setText("Bonne réponse !");
        } else {
            msgTextView.setText("La bonne réponse était \"" + answer1.getRightAnswer() + "\".");
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
    public List<String> init(Answer answer) {
        // on met les réponses dans un tab
        ArrayList<String> answered = new ArrayList<String>();
        answered.add(answer.getRightAnswer());
        answered.add(answer.getFalseAnswer1());
        answered.add(answer.getFalseAnswer2());
        Collections.shuffle(answered);
        return answered;
    }


}
