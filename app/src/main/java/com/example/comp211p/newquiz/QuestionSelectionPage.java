package com.example.comp211p.newquiz;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.comp211p.newquiz.quizInterfaceMultipleFragment.QuizInterfaceMultipleFragment;
import com.example.comp211p.newquiz.quizInterfaceMultipleFragment.QuizInterfaceMultipleFragment1;
import com.example.comp211p.newquiz.quizInterfaceMultipleFragment.QuizInterfaceMultipleFragment2;
import com.example.comp211p.newquiz.quizInterfaceMultipleFragment.QuizInterfaceMultipleFragment3;
import com.example.comp211p.newquiz.quizInterfaceMultipleFragment.QuizInterfaceMultipleFragment4;
import com.example.comp211p.newquiz.quizInterfaceMultipleFragment.QuizInterfaceMultipleFragment5;

public class QuestionSelectionPage extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_selection_page);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getApplicationContext();
                logic.setCurrentQuestion(1);
                Intent in = new Intent(getBaseContext(), QuizInterfaceMultipleFragment1.class);
                startActivity(in);
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getApplicationContext();
                logic.setCurrentQuestion(2);
                Intent in = new Intent(getBaseContext(), QuizInterfaceMultipleFragment2.class);
                startActivity(in);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getApplicationContext();
                logic.setCurrentQuestion(3);
                Intent in = new Intent(getBaseContext(), QuizInterfaceMultipleFragment3.class);
                startActivity(in);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getApplicationContext();
                logic.setCurrentQuestion(4);
                Intent in = new Intent(getBaseContext(), QuizInterfaceMultipleFragment4.class);
                startActivity(in);
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getApplicationContext();
                logic.setCurrentQuestion(5);
                Intent in = new Intent(getBaseContext(), QuizInterfaceMultipleFragment5.class);
                startActivity(in);
            }
        });

        // disable buttons if questions have been answered
        QuizApp logic = (QuizApp) getApplicationContext();
        // check which questions the active players has already answered
        if (logic.hasAnsweredQuestion(1)) button1.setEnabled(false);
        if (logic.hasAnsweredQuestion(2)) button2.setEnabled(false);
        if (logic.hasAnsweredQuestion(3)) button3.setEnabled(false);
        if (logic.hasAnsweredQuestion(4)) button4.setEnabled(false);
        if (logic.hasAnsweredQuestion(5)) button5.setEnabled(false);

        if (logic.isGameOver()) goToScorePage();
    }

    public void goToScorePage()
    {
        Intent in = new Intent(getApplicationContext(), HighScores.class);
        startActivity(in);
    }

    // DEPRECATED
    /**
     * Repeats the game for player 2. Starts by going to the Question Selection page.
     */
    /*public void startPlayer2()
    {
        // Switching player happens automatically when player1 has answered all questions
        QuizApp logic = (QuizApp) getApplicationContext();
        // switch from player 1 to player 2
        logic.switchPlayer();

        Intent in = new Intent(getApplicationContext(), QuestionSelectionPage.class);
        startActivity(in);
    }/*

    /**
     * Disables one of the five question buttons (should be used when question is already answered)
     * param num Number of the question button to be disabled: 1-5
     */

    public void disableButton(Button buttonNumber)
    {
        buttonNumber.setEnabled(false);
        //buttonNumber is a selection from Q1, Q2, Q3, Q4, Q5
        // will be accessed when a question has been answered
    }

    public void disableAllButtons()
    {
        disableButton(button1);
        disableButton(button2);
        disableButton(button3);
        disableButton(button4);
        disableButton(button5);
    }

}
