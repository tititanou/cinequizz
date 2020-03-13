package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomeActivity extends AppCompatActivity  {
    ArrayList<Answer> quizz= new ArrayList<>();

    Answer answer1= new Answer(R.drawable.poudlard,"intermédiaire", "image", "De quel film est tirée cette image ?", "Harry Potter", "robinonekenoby", "tania");
    Answer answer2 = new Answer(R.raw.polish_oss,"intermédiaire", "audio", "De quel film est tiré cet extrait audio?", "OSS 117", "Le père noël est une ordure", "Need for speed");
    Answer answer3 = new Answer(R.drawable.avatar,"facile", "image","De quel film est tirée cette image ?","Avatar","Alien","Mars Attack");
    Answer answer4 = new Answer(R.drawable.belle_bete_cocteau,"difficile","image","De quel film est tirée cette image ?","La belle et la bête","Peau d'Âne", "Le Magicien D'Oz");
    Answer answer5 = new Answer(R.drawable.bridget_jones,"intermédiaire","image","De quel film est tirée cette image ?","Le Journal de Bridget Jones", "Bye Bye Love","Retour a Cold Mountain");
    Answer answer6 = new Answer(R.drawable.cage_aux_folles, "difficile","image","De quel film est tirée cette image ?","La Cage aux Folles","La Cage Dorée","Le Placard");
    Answer answer7 = new Answer(R.drawable.edward_mains_argent,"difficile","image","De quel film est tirée cette image ?","Edward aux Mains D'argent", "La Reine des Neiges","Dark Shadows");
    Answer answer8 = new Answer(R.drawable.etrange_noel_mr_jack,"facile","image","De quel film est tirée cette image ?","L'Etrange Noël de Mr.Jack","Les Noces Funèbres","Frankenweenie");
    Answer answer9 = new Answer(R.drawable.fifty_shades_grey,"facile","image","De quel film est tirée cette image ?","50 Nuances de Grey","After","Vous Avez un Message");
    Answer answer10 = new Answer(R.drawable.grande_vadrouille,"intermédiaire","image","De quel film est tirée cette image ?","La Grande Vadrouille","La 7eme Compagnie","Les Gendarmes à St Tropez");
    Answer answer11 = new Answer(R.drawable.kingkong,"facile","image","De quel film est tirée cette image ?","KingKong","La Planète des Singes","Godzilla");
    Answer answer12 = new Answer(R.drawable.pretty_woman,"facile","image","De quel film est tirée cette image ?","Pretty Woman","Le Sourire de Mona Lisa","Erine Brockovich");
    Answer answer13 = new Answer(R.drawable.mala_educacion,"difficile","image","De quel film est tirée cette image ?","La Mauvaise Education","Camping","Coup de Tête");
    Answer answer14 = new Answer(R.drawable.lauwrence_arabie,"intermédiaire","image","De quel film est tirée cette image ?","Lauwrence D'Arabie","Ben Hûr", "Gandhi");
    Answer answer15 = new Answer(R.drawable.slumdog_millionnaire,"intermédiaire","image","De quel film est tirée cette image ?","SlumDog Millionaire","Indian Palace","Salaam Bombay");
    Answer answer16 = new Answer(R.drawable.titanic,"facile","image","De quel film est tirée cette image ?","Titanic","Poséidon","La Forme de l'Eau");
    Answer answer17 = new Answer(R.drawable.seigneur_des_anneaux,"intermédiaire","image","De quel film est tirée cette image ?","Le Seigneur des Anneaux","Le Hobbit","Harry Potter");
    Answer answer18= new Answer(R.raw.cite_peur,"difficile","audio", "De quel film est tiré ce son ?", "La cité de la peur", "Camping", "Sans peur et sans reproche");
    Answer answer19= new Answer(R.raw.lebowski,"facile","audio","De quel film est tiré ce son ?", "The Big Lebowski", "Rain man", "Narnia");
    Answer answer20=new Answer(R.raw.matrix, "facile","audio","De quel film est tiré ce son ?", "Matrix", "Tron", "John Wick");
    Answer answer21=new Answer(R.raw.parrain2,"difficile", "audio","De quel film est tiré ce son ?", "Le Parrain 2", "Scarface", "Donnie Brasco");
    Answer answer22=new Answer(R.raw.pere_noel, "intermédiaire","audio","De quel film est tiré ce son ?", "Le père Noel est une ordure", "Les bronzés", "La beuze");
    Answer answer23=new Answer(R.raw.rabbi_jaccob, "intermédiaire","audio","De quel film est tiré ce son ?", "Rabbi Jacob", "Les gendarmes à Saint Tropez", "Fantomas");
    Answer answer24=new Answer(R.raw.star_wars, "facile","audio","De quel film est tiré ce son ?", "Star Wars", "Alien", "2001, l'Odyssée de l'espace");
    Answer answer25=new Answer(R.raw.terminator,"facile", "audio","De quel film est tiré ce son ?", "Terminator", "Star Trek", "Basic Instinct");
    Answer answer26=new Answer(R.raw.bronzes_ski_2,"facile", "audio","De quel film est tiré ce son ?", "Les bronzés font du ski", "La première étoile", "Rasta rocket");
    Answer answer27=new Answer(R.raw.cest_arrive, "difficile","audio","De quel film est tiré ce son ?", "C'est arrivé près de chez vous", "Dikkenek", "Le boulet");
    Answer answer28=new Answer(R.raw.la_haine,"intermédiaire", "audio","De quel film est tiré ce son ?", "La Haine", "Les misérables", "Banlieusards");
    Answer answer29=new Answer(R.raw.peril_jeune,"difficile", "audio","De quel film est tiré ce son ?", "Le péril jeune", "L'auberge espagnole", "Le professionnel");
    Answer answer30=new Answer(R.raw.pilote_avion,"facile", "audio","De quel film est tiré ce son ?", "Y a t il un pilote dans l'avion", "Maman, j'ai raté l'avion", "Sully");
    Answer answer31=new Answer(R.raw.star_wars,"facile" ,"audio","De quel film est tiré ce son ?", "Star Wars", "Interstellar", "Seul sur Mars");
    Answer answer32=new Answer(R.raw.amelie_poulain, "intermédiaire","audio","De quel film est tiré ce son ?", "La fabuleux destin d'Amélie Poulain", "Intouchables", "La Môme");
    Answer answer33=new Answer(R.drawable.thanos, "difficile","image","qu’elle est la réplique du moment de ce fil ?","je suis inéluctable ","je suis inévitable","je suis iron man ");

    private int index;
    private int state;
    private int score;
    private static final int STATE_INIT=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /**
         * creation of our questions list
         */
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
        quizz.add(answer18);
        quizz.add(answer19);
        quizz.add(answer20);
        quizz.add(answer21);
        quizz.add(answer22);
        quizz.add(answer23);
        quizz.add(answer24);
        quizz.add(answer25);
        quizz.add(answer26);
        quizz.add(answer27);
        quizz.add(answer28);
        quizz.add(answer29);
        quizz.add(answer30);
        quizz.add(answer31);
        quizz.add(answer32);
        quizz.add(answer33);




        /**
         * initilization of the index and the score, shuffling of our questions list
         */
        initialization(quizz);
        shuffleList(quizz);
        final Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("quizz",quizz);
        intent.putExtra("state",state);
        intent.putExtra("index",index);
        intent.putExtra("score", score);
        TextView hV = findViewById(R.id.HomeView);
        hV.setText("CINE QUIZ");
        TextView hv = findViewById(R.id.HomeView);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/cinema_st.ttf");
        hv.setTypeface(custom_font);
        goToQuiz(intent);
        Button listButton= findViewById(R.id.listButton);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToList();
            }
        });

        goToAbout();

    }

    private void goToQuiz(final Intent intent) {
        Button buttonQuiz = findViewById(R.id.ButtonQuiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void goToList(){
        final Intent intent3 = new Intent(this, QuestionsListActivity.class);
        startActivity(intent3);
    }

    private void goToAbout() {
       final Intent intent2= new Intent(this,AboutActivity.class);
        Button aboutBtn = findViewById(R.id.AboutBtn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
    }


    public ArrayList<Answer> shuffleList(ArrayList<Answer> listing){
        Collections.shuffle(listing);
        return listing;

    }

    public void initialization (List<Answer> myList){
        //List<Answer> myListShuffled = shuffleList(myList);
        index = 0;
        state = STATE_INIT;
        score =0;
    }
}
