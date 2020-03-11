package com.tania.cinequizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button validateButton;
    private TextView msgTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("CineQuizz");

        msgTextView = findViewById(R.id.msgTextView);
        validateButton = findViewById(R.id.validateButton);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        Log.i("MainActivity", "onCreate: ");
        
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int id = radioGroup.getCheckedRadioButtonId();
             RadioButton radioButton = findViewById(id);
             CharSequence answer = radioButton.getText();
             checkAnswer(answer);
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
    
}
