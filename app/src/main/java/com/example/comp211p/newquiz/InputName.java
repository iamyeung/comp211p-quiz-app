package com.example.comp211p.newquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.comp211p.newquiz.quizInterfaceMultipleFragment.QuizInterfaceMultipleFragment;

public class InputName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_name);

        final Button toQuestionPageButton;
        toQuestionPageButton = (Button) findViewById(R.id.toQuestionPageButton);

        toQuestionPageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String singlePlayerName = ((EditText)findViewById(R.id.singlePlayerName)).getText().toString();
                QuizApp.singlePlayerName = singlePlayerName;
                Intent in = new Intent(getBaseContext(), QuizInterfaceMultipleFragment.class);
                startActivity(in);
            }
        });
    }
}
