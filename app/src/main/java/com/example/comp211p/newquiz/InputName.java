package com.example.comp211p.newquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class InputName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_name);

        final Button toQuestionPageButton;
        toQuestionPageButton = (Button) findViewById(R.id.toQuestionPageButton);

        toQuestionPageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EditText inputField = (EditText)findViewById(R.id.singlePlayerName);
                String playerName = inputField.getText().toString();
                // some error handling on user input
                boolean inputError = false;
                // cant be empty
                if (playerName.length() == 0){
                    inputError = true;
                    inputField.setError("A name is required!");
                }
                // max length
                if (playerName.length() > 8){
                    inputError = true;
                    inputField.setError("Name cannot be longer than 8 characters!");
                }
                // use regex to validate input
                Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                // no special character used (other than alpha numeric)
                if (p.matcher(playerName).find()) {
                    inputError = true;
                    inputField.setError("Only alphanumeric characters allowed!");
                }

                if (!inputError) {
                    QuizApp logic = (QuizApp) getApplicationContext();
                    // adds player to the game: if player 1 already exists and game is in multi-player
                    // mode, this adds player 2
                    logic.addPlayer(playerName);

                    if (logic.arePlayersReady()) {
                        Intent in = new Intent(getBaseContext(), QuestionSelectionPage.class);
                        startActivity(in);
                    } else {
                        // repeats input name for player 2
                        Intent in = new Intent(getBaseContext(), InputName.class);
                        startActivity(in);
                    }
                }
            }
        });
    }
}
