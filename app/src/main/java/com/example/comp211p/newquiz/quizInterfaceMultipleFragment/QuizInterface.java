package com.example.comp211p.newquiz.quizInterfaceMultipleFragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.comp211p.newquiz.R;

public class QuizInterface extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_interface_multiple_fragment);

    }

}
        //Don't delete
        /*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(topBarMenuContainer, new QuizInterfaceTopBarMenuFragment()).commit();
        }


    public void displayQuestion(String question, boolean correct, String answer)
    {
        // TODO
        // figure out how to change the strings for question, answer
    }

        */