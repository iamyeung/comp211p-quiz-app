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

        QuizApp logic = (QuizApp) getApplicationContext();
        if (logic.p1 != null)
        {
            displayPlayer1Score(logic.p1.getName(), logic.p1.getScore());
        }
        if (!logic.getIsSinglePlayer() && logic.p2 != null)
        {
            displayPlayer2Score(logic.p2.getName(), logic.p2.getScore());
        }
        displayAllScores(logic.getPlayerHistory(5));
    }

    public void displayAllScores(Player[] players) {
        String highScore = "";
        for (int i = 0; i <= players.length - 1; i++) {
            highScore += players[i].getName() + ": " + players[i].getScore() + "\n";
        }
        TextView allHighScores = (TextView) findViewById(R.id.allHighScores);
        allHighScores.setText(highScore);
    }

    public void displayPlayer1Score(String name, int score)
    {
        TextView player1NameAndScore  = (TextView) findViewById(R.id.player1NameAndScore);
        player1NameAndScore.setText(name + ": " + score);
    }

    public void displayPlayer2Score(String name, int score)
    {
        TextView player2NameAndScore  = (TextView) findViewById(R.id.player2NameAndScore);
        player2NameAndScore.setText(name + ": " + score);
    }

}