package com.example.comp211p.newquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionSelectionPage extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button quitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_selection_page);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), QuizInterface1.class);
                startActivity(in);
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), QuizInterface1.class);
                startActivity(in);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), QuizInterface1.class);
                startActivity(in);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), QuizInterface1.class);
                startActivity(in);
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), QuizInterface1.class);
                startActivity(in);
            }
        });

        /*quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), StartScreen.class);
                startActivity(in);
            }
        });*/
    }

    public void goToScorePage()
    {
        //TODO
        // will be accesses when logic says game is done
    }

    /**
     * Repeats the game for player 2. Starts by going to the Question Selection page.
     */
    public void startPlayer2()
    {
        QuizApp logic = (QuizApp) getApplicationContext();
        // switch from player 1 to player 2
        logic.switchPlayer();

        // TODO: REPEAT ALL QUESTIONS FOR PLAYER 2 (go to question selection page)
    }

    /**
     * Disables one of the five question buttons (should be used when question is already answered)
     * @param num Number of the question button to be disabled: 1-5
     */
    public void disableButton(int num)
    {
        if (num>=0 && num <= 5) {
            //TODO
            // will be accessed when a question has been answered
        }
    }

}
