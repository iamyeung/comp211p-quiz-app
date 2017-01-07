package com.example.comp211p.newquiz.quizInterfaceMultipleFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comp211p.newquiz.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

/**
 * Created by Spartan-JT on 13/12/2016.
 */

public class QuizInterfaceMultipleFragment5 extends Fragment {

    public QuizInterfaceMultipleFragment5() {
    }

    Fragment quizInterfaceMultipleFragment1;
    FragmentTransaction fragTransaction;
    private Button Q5;
    private Button trueButton;
    private Button falseButton;
    private Button skipButton;
    private Button cheatButton;
    private TextView answerText;

    //this is the code for delaying the launch task.
    private Handler mHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.quiz_interface_multiple_fragment_5, container, false);

        View view = inflater.inflate(R.layout.quiz_interface_top_bar_menu_fragment, container, false);
        Q5 = (Button)view.findViewById(R.id.question5);
        //declare all the buttons by finding the relevant ID - the ID name is set in the .xml file

        trueButton = (Button) rootView.findViewById(R.id.trueButton);
        falseButton = (Button) rootView.findViewById(R.id.falseButton);
        skipButton = (Button) rootView.findViewById(R.id.skipButton);
        cheatButton = (Button) rootView.findViewById(R.id.cheatButton);
        answerText = (TextView) rootView.findViewById(R.id.answerText);
        answerText.setVisibility(View.INVISIBLE);

        //selectedButton is a method that causes all the other buttons to be disabled once one button is chosen
        selectedButton();
        return rootView;
    }

    public void selectedButton() {
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.correctMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                disableAllButtons();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.incorrectMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                disableAllButtons();
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.skipTo1Message, Toast.LENGTH_SHORT).show();
                quizInterfaceMultipleFragment1 = new QuizInterfaceMultipleFragment1();
                fragTransaction = getFragmentManager().beginTransaction().add(R.id.container, quizInterfaceMultipleFragment1);
                fragTransaction.commit();
            }
        });
        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.cheatMessage, Toast.LENGTH_SHORT).show();
                revealAnswer();
                disableAllButtons();
            }
        });
    }

    public void revealAnswer() {
        answerText.setVisibility(View.VISIBLE);
        TranslateAnimation animation = new TranslateAnimation(0, 0, 2000, 0);
        //animation time for the text to pop up is 0.5 seconds, can change if you need
        animation.setDuration(500);
        answerText.startAnimation(animation);
    }

    public void disableAllButtons() {
        trueButton.setEnabled(false);
        falseButton.setEnabled(false);
        cheatButton.setEnabled(false);
        skipButton.setEnabled(false);
    }

}
