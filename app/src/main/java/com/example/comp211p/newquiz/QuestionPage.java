package com.example.comp211p.newquiz;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionPage extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), QuizInterface.class);
                startActivity(in);
            }
        });

        // Calling Application class
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        // Get singlePlayerName from global/application context
        final String singlePlayerName = globalVariable.getSinglePlayerName();
        TextView showGlobal = (TextView) findViewById(R.id.showGlobal);
        showGlobal.setText(singlePlayerName);
    }
}
