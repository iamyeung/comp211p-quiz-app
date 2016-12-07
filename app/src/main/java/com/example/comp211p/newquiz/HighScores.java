package com.example.comp211p.newquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Spartan-JT on 07/12/2016.
 */

public class HighScores extends AppCompatActivity {

    private Button finishButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_scores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        finishButton = (Button) findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), StartScreen.class);
                startActivity(in);
            }
        });

        // Calling Application class
        final QuizApp app = (QuizApp) getApplicationContext();
        // Get singlePlayerName from global/application context
        final String singlePlayerName = app.getSinglePlayerName();
        TextView showGlobal = (TextView) findViewById(R.id.player1name);
        showGlobal.setText(singlePlayerName);


    }
}
