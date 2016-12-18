package com.example.comp211p.newquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

    private Button singlePlayerButton;
    private Button twoPlayerButton;
    private Button highScoresButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        singlePlayerButton = (Button) findViewById(R.id.singlePlayerButton);
        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getApplicationContext();
                // start game in single-player mode
                logic.startSinglePlayer();
                Intent in = new Intent(getApplicationContext(), InputName.class);
                startActivity(in);
            }
        });

        twoPlayerButton = (Button) findViewById(R.id.twoPlayerButton);
        twoPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getApplicationContext();
                // start game in multi-player mode
                logic.startMultiPlayer();
                Intent in = new Intent(getApplicationContext(), InputName.class);
                startActivity(in);
            }
        });
        /*
        I did not name it MultiPlayerButton because it multi may mean more than two, and we are not aiming to make the game
        playable for 3+ players
        */

        highScoresButton = (Button) findViewById(R.id.highScoresButton);
        highScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), HighScores.class);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
