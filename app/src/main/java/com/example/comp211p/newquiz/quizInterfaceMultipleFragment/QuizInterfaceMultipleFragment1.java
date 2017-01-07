package com.example.comp211p.newquiz.quizInterfaceMultipleFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comp211p.newquiz.HighScores;
import com.example.comp211p.newquiz.QuestionSelectionPage;
import com.example.comp211p.newquiz.QuizApp;
import com.example.comp211p.newquiz.QuizInterface1;
import com.example.comp211p.newquiz.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

/**
 * Created by Spartan-JT on 13/12/2016.
 */

public class QuizInterfaceMultipleFragment1 extends Fragment {

    public QuizInterfaceMultipleFragment1() {
    }

    private Button trueButton;
    private Button falseButton;
    private Button skipButton;
    private Button cheatButton;
    private TextView answerText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.quiz_interface_multiple_fragment_1, container, false);

        //declare all the buttons by finding the relevant ID - the ID name is set in the .xml file
        trueButton = (Button) rootView.findViewById(R.id.trueButton);
        falseButton = (Button) rootView.findViewById(R.id.falseButton);
        skipButton = (Button) rootView.findViewById(R.id.skipButton);
        cheatButton = (Button) rootView.findViewById(R.id.cheatButton);
        answerText = (TextView) rootView.findViewById(R.id.answerText);
        answerText.setVisibility(View.INVISIBLE);

        // TODO: This should replace all other fragements: questions should be loaded dynamically
        // display the correct question and answer
        QuizApp logic = (QuizApp) getActivity().getApplicationContext();
        displayQuestion(logic.getCurrentQuestion(), rootView);

        //selectedButton is a method that causes all the other buttons to be disabled once one button is chosen
        selectedButton();
        return rootView;
    }

    //currently we have the pop up text that displays correct, incorrect, skip and cheat.
    //the following code is copied over MultipleFragment1,MultipleFragment2, MultipleFragment3, MultipleFragment4, MultipleFragment5
    //except the changes with Incorrect, Correct, Skip, Cheat etc.

    public void selectedButton() {
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.answerQuestion(true);

                Toast.makeText(getActivity(), R.string.incorrectMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                disableAllButtons();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.answerQuestion(false);

                Toast.makeText(getActivity(), R.string.correctMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                disableAllButtons();
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.skipTo2Message, Toast.LENGTH_SHORT).show();
                //unsure if this intent button works. All skip button in QuizInterfaceMultipleFragment1,2,3,4,5 jump directly
                //to QuestionSelectionPage.class, otherwise the user can also choose the new button on the TopBarMenuFrgament
                Intent intent = new Intent(getActivity(), QuestionSelectionPage.class);
                startActivity(intent);
            }
        });
        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.cheatQuestion();

                Toast.makeText(getActivity(), R.string.cheatMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                disableAllButtons();
            }
        });
    }

    public void displayQuestion(int questionNum, View v)
    {
        if (questionNum >= 1 && questionNum <=5) {
            try {
                TextView question = (TextView) v.findViewById(R.id.questionText);
                String qText = getString(this.getResources().getIdentifier("Q"+questionNum, "String", getActivity().getApplicationContext().getPackageName()));
                question.setText(qText);

                TextView answer = (TextView) v.findViewById(R.id.answerText);
                String aText = getString(this.getResources().getIdentifier("A"+questionNum, "String", getActivity().getApplicationContext().getPackageName()));
                answer.setText(aText);
            } catch (NullPointerException npe) {
                Log.e("QIMF", "Null Pointer Exception caught: The given view does not have a question text.");
            }
        }
    }

    public void revealAnswer() {
        answerText.setVisibility(View.VISIBLE);
        TranslateAnimation animation = new TranslateAnimation(0, 0, 2000, 0);
        //animation time for the text to pop up is 0.2 seconds, can change if you need
        animation.setDuration(200);
        answerText.startAnimation(animation);
    }

    public void disableButton (Button buttonName){
        buttonName.setEnabled(false);
        //buttonName is a selection from (trueButton, falseButton, cheatButton, skipButton)
        //example: disableButton (skipButton)
    }

    public void disableAllButtons() {
        trueButton.setEnabled(false);
        falseButton.setEnabled(false);
        cheatButton.setEnabled(false);
        skipButton.setEnabled(false);
    }

}