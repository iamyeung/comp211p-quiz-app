package com.example.comp211p.newquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SinglePlayerInputName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_input_name);

        final Button toQuestionPageButton;
        toQuestionPageButton = (Button) findViewById(R.id.toQuestionPageButton);
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        toQuestionPageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String singlePlayerName = ((EditText)findViewById(R.id.singlePlayerName)).getText().toString();
                globalVariable.setSinglePlayerName(singlePlayerName);
                Intent in = new Intent(getBaseContext(), QuestionPage.class);
                startActivity(in);
            }
        });
    }
}
