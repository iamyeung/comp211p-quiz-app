package com.example.comp211p.newquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    TextView player1DisplayScore;
    int player1CalculateScore;
    int p1q1answer, p1q2answer, p1q3answer, p1q4answer, p1q5answer;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_scores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        calculatePlayer1Score();

        finishButton = (Button) findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), StartScreen.class);
                startActivity(in);
                resetValues();
            }
        });

        TextView player1name  = (TextView) findViewById(R.id.player1name);
        player1name.setText(QuizApp.singlePlayerName);
    }

    public void calculatePlayer1Score(){

        player1DisplayScore = (TextView)findViewById(R.id.player1score);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

        int p1q1answer = app_preferences.getInt("p1_answer_value1", 0);
        int p1q2answer = app_preferences.getInt("p1_answer_value2", 0);
        int p1q3answer = app_preferences.getInt("p1_answer_value3", 0);
        int p1q4answer = app_preferences.getInt("p1_answer_value4", 0);
        int p1q5answer = app_preferences.getInt("p1_answer_value5", 0);

        player1CalculateScore =  p1q1answer + p1q2answer + p1q3answer + p1q4answer + p1q5answer;
        player1DisplayScore.setText(player1CalculateScore + "/5");
    }

    public void resetValues() {
        final SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putInt("p1_answer_value1", 0);
        editor.putInt("p1_answer_value2", 0);
        editor.putInt("p1_answer_value3", 0);
        editor.putInt("p1_answer_value4", 0);
        editor.putInt("p1_answer_value5", 0);
        QuizApp.singlePlayerName = " ";
        editor.commit();
    }

}

        /*
        //Don't delete this code please.
        // Calling Application class
        final QuizApp app = (QuizApp) getApplicationContext();
        // Get singlePlayerName from global/application context
        final String storedSinglePlayerName = app.getSinglePlayerName();
        */