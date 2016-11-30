package com.example.comp211p.newquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Timer;
import java.util.TimerTask;

public class QuizInterface extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button skipButton;
    private Button cheatButton;
    private Button returnButton;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //this is the code for delaying the launch task.
    private Handler mHandler = new Handler();
    private Runnable mLaunchTask = new Runnable () {
        public void run() {
            goToQuestionPage();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_quiz_interface);
        findViewById(R.id.answerText).setVisibility(View.INVISIBLE); //reveals the answer to the gamer

        returnButton = (Button) findViewById(R.id.returnButton);
        trueButton = (Button) findViewById(R.id.trueButton);
        falseButton = (Button) findViewById(R.id.falseButton);
        skipButton = (Button) findViewById(R.id.skipButton);
        cheatButton = (Button) findViewById(R.id.cheatButton);

        selectedButton();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void selectedButton(){
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizInterface.this, R.string.incorrectMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                cheatButton.setEnabled(false);
                skipButton.setEnabled(false);
                //you can change the length of time by which the launch task is delayed - currently 500ms
                mHandler.postDelayed(mLaunchTask, 3500);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizInterface.this, R.string.correctMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                cheatButton.setEnabled(false);
                skipButton.setEnabled(false);
                //you can change the length of time by which the launch task is delayed - currently 500ms
                mHandler.postDelayed(mLaunchTask, 3500);
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizInterface.this, R.string.skipMessage, Toast.LENGTH_SHORT).show();
                goToQuestionPage();
                //there is no need to add a mHandler.postDelayed method here because the skip button will directly link you back to the Question Page
            }
        });
        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizInterface.this, R.string.cheatMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                cheatButton.setEnabled(false);
                skipButton.setEnabled(false);
                mHandler.postDelayed(mLaunchTask, 3500);
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToQuestionPage();
            }
        });
    }

    public void revealAnswer() {
        findViewById(R.id.answerText).setVisibility(View.VISIBLE);
        TranslateAnimation animation = new TranslateAnimation(0, 0, 2000, 0);
        animation.setDuration(500);
        findViewById(R.id.answerText).startAnimation(animation);
    }

    public void goToQuestionPage() {
        Intent in = new Intent(getApplicationContext(), QuestionPage.class);
        startActivity(in);
    }

    /*
    public void onClickTrue(View view) {
        Toast.makeText(QuizInterface.this, R.string.incorrectMessage, Toast.LENGTH_SHORT).show();
        revealAnswer();
        falseButton.setEnabled(false);
        //you can change the length of time by which the launch task is delayed - currently 500ms
        mHandler.postDelayed(mLaunchTask, 3500);
    }

    public void onClickFalse(View view) {
        Toast.makeText(QuizInterface.this, R.string.correctMessage, Toast.LENGTH_SHORT).show();
        revealAnswer();
        //you can change the length of time by which the launch task is delayed - currently 500ms
        mHandler.postDelayed(mLaunchTask, 3500);
    }

    public void onClickSkip(View view) {
        Toast.makeText(QuizInterface.this, R.string.skipMessage, Toast.LENGTH_SHORT).show();
        goToQuestionPage();
        //there is no need to add a mHandler.postDelayed method here because the skip button will directly link you back to the Question Page
    }

    public void onClickCheat(View view) {
        Toast.makeText(QuizInterface.this, R.string.cheatMessage, Toast.LENGTH_SHORT).show();
        revealAnswer();
        mHandler.postDelayed(mLaunchTask, 3500);
    }

    public void onClickReturn(View view) {
        goToQuestionPage();
    }

    */

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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("QuizInterface Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
