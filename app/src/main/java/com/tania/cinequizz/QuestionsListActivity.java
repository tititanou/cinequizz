package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListActivity extends AppCompatActivity {

    private List<Answer> quizz;
    private AnswerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);

        quizz = new ArrayList<>();

        quizz.add(new Answer(R.drawable.thanos, "difficile","image","qu’elle est la réplique du moment de ce fil ?","je suis inéluctable ","je suis inévitable","je suis iron man "));
        quizz.add(new Answer(R.drawable.poudlard,"intermédiaire", "image", "De quel film est tirée cette image ?", "Harry Potter", "robinonekenoby", "tania"));
        quizz.add(new Answer(R.drawable.avatar, "facile","image","De quel film est tirée cette image ?","Avatar","Alien","Mars Attack"));
        quizz.add(new Answer(R.drawable.belle_bete_cocteau,"difficile","image","De quel film est tirée cette image ?","La belle et la bête","Peau d'Âne", "Le Magicien D'Oz"));
        quizz.add(new Answer(R.drawable.bridget_jones,"intermédiaire","image","De quel film est tirée cette image ?","Le Journal de Bridget Jones", "Bye Bye Love","Retour a Cold Mountain"));
        quizz.add(new Answer(R.drawable.cage_aux_folles, "difficile","image","De quel film est tirée cette image ?","La Cage aux Folles","La Cage Dorée","Le Placard"));
        quizz.add(new Answer(R.drawable.edward_mains_argent,"difficile","image","De quel film est tirée cette image ?","Edward aux Mains D'argent", "La Reine des Neiges","Dark Shadows"));
        quizz.add(new Answer(R.drawable.etrange_noel_mr_jack,"facile","image","De quel film est tirée cette image ?","L'Etrange Noël de Mr.Jack","Les Noces Funèbres","Frankenweenie"));
        quizz.add(new Answer(R.drawable.fifty_shades_grey,"facile","image","De quel film est tirée cette image ?","50 Nuances de Grey","After","Vous Avez un Message"));
        quizz.add(new Answer(R.drawable.grande_vadrouille,"intermédiaire","image","De quel film est tirée cette image ?","La Grande Vadrouille","La 7eme Compagnie","Les Gendarmes à St Tropez"));
        quizz.add(new Answer(R.drawable.kingkong,"facile","image","De quel film est tirée cette image ?","KingKong","La Planète des Singes","Godzilla"));
        quizz.add(new Answer(R.drawable.pretty_woman,"facile","image","De quel film est tirée cette image ?","Pretty Woman","Le Sourire de Mona Lisa","Erine Brockovich"));
        quizz.add(new Answer(R.drawable.mala_educacion,"difficile","image","De quel film est tirée cette image ?","La Mauvaise Education","Camping","Coup de Tête"));
        quizz.add(new Answer(R.drawable.lauwrence_arabie,"intermédiaire","image","De quel film est tirée cette image ?","Lauwrence D'Arabie","Ben Hûr", "Gandhi"));
        quizz.add(new Answer(R.drawable.slumdog_millionnaire,"intermédiaire","image","De quel film est tirée cette image ?","SlumDog Millionaire","Indian Palace","Salaam Bombay"));
        quizz.add(new Answer(R.drawable.titanic,"facile","image","De quel film est tirée cette image ?","Titanic","Poséidon","La Forme de l'Eau"));
        quizz.add(new Answer(R.drawable.seigneur_des_anneaux,"intermédiaire","image","De quel film est tirée cette image ?","Le Seigneur des Anneaux","Le Hobbit","Harry Potter"));
        quizz.add(new Answer(R.raw.cite_peur,"difficile","audio", "De quel film est tiré ce son ?", "La cité de la peur", "Camping", "Sans peur et sans reproche"));
        quizz.add(new Answer(R.raw.lebowski, "facile","audio","De quel film est tiré ce son ?", "The Big Lebowski", "Rain man", "Narnia"));
        quizz.add(new Answer(R.raw.matrix, "facile","audio","De quel film est tiré ce son ?", "Matrix", "Tron", "John Wick"));
        quizz.add(new Answer(R.raw.parrain2,"difficile", "audio","De quel film est tiré ce son ?", "Le Parrain 2", "Scarface", "Donnie Brasco"));
        quizz.add(new Answer(R.raw.pere_noel, "intermédiaire","audio","De quel film est tiré ce son ?", "Le père Noel est une ordure", "Les bronzés", "La beuze"));
        quizz.add(new Answer(R.raw.rabbi_jaccob, "intermédiaire","audio","De quel film est tiré ce son ?", "Rabbi Jacob", "Les gendarmes à Saint Tropez", "Fantomas"));
        quizz.add(new Answer(R.raw.star_wars, "facile","audio","De quel film est tiré ce son ?", "Star Wars", "Alien", "2001, l'Odyssée de l'espace"));
        quizz.add(new Answer(R.raw.terminator,"facile", "audio","De quel film est tiré ce son ?", "Terminator", "Star Trek", "Basic Instinct"));
        quizz.add(new Answer(R.raw.bronzes_ski_2,"facile", "audio","De quel film est tiré ce son ?", "Les bronzés font du ski", "La première étoile", "Rasta rocket"));
        quizz.add(new Answer(R.raw.cest_arrive, "difficile","audio","De quel film est tiré ce son ?", "C'est arrivé près de chez vous", "Dikkenek", "Le boulet"));
        quizz.add(new Answer(R.raw.la_haine,"intermédiaire", "audio","De quel film est tiré ce son ?", "La Haine", "Les misérables", "Banlieusards"));
        quizz.add(new Answer(R.raw.peril_jeune,"difficile", "audio","De quel film est tiré ce son ?", "Le péril jeune", "L'auberge espagnole", "Le professionnel"));
        quizz.add(new Answer(R.raw.pilote_avion,"facile", "audio","De quel film est tiré ce son ?", "Y a t il un pilote dans l'avion", "Maman, j'ai raté l'avion", "Sully"));
        quizz.add(new Answer(R.raw.amelie_poulain, "intermédiaire","audio","De quel film est tiré ce son ?", "La fabuleux destin d'Amélie Poulain", "Intouchables", "La Môme"));
        quizz.add(new Answer(R.raw.polish_oss,"intermédiaire", "audio", "De quel film est tiré cet extrait audio?", "OSS 117", "Le père noël est une ordure", "Need for speed"));

        adapter = new AnswerAdapter(quizz);

        for (int i=0; i<quizz.size(); i++){
            quizz.get(i);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
