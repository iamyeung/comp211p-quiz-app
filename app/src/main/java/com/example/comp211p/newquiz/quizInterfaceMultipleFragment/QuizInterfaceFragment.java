package com.example.comp211p.newquiz.quizInterfaceMultipleFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comp211p.newquiz.QuestionSelectionPage;
import com.example.comp211p.newquiz.QuizApp;
import com.example.comp211p.newquiz.R;

/**
 * Created by Spartan-JT on 13/12/2016.
 */

public class QuizInterfaceFragment extends Fragment {

    public QuizInterfaceFragment() {
    }

    private Handler mHandler = new Handler();
    private Runnable mLaunchTask = new Runnable () {
        public void run() {
            goToQuestionPage();
        }
    };

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

        // This should replace all other fragments: questions should be loaded dynamically
        // display the correct question and answer
        QuizApp logic = (QuizApp) getActivity().getApplicationContext();
        displayQuestion(logic.getCurrentQuestionNumber(), rootView);

        //selectedButton is a method that causes all the other buttons to be disabled once one button is chosen
        selectedButton();
        return rootView;
    }

    public void goToQuestionPage() {
        Intent in = new Intent(getContext().getApplicationContext(), QuestionSelectionPage.class);
        startActivity(in);
    }

    public void selectedButton() {
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.answerQuestion(true);

                if (logic.getCurrentQuestion().isTrue())
                    Toast.makeText(getActivity(), R.string.correctMessage, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), R.string.incorrectMessage, Toast.LENGTH_SHORT).show();

                revealAnswer();
                disableAllButtons();

                mHandler.postDelayed(mLaunchTask, 2000);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.answerQuestion(false);

                if (logic.getCurrentQuestion().isTrue())
                    Toast.makeText(getActivity(), R.string.incorrectMessage, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), R.string.correctMessage, Toast.LENGTH_SHORT).show();

                revealAnswer();
                disableAllButtons();

                mHandler.postDelayed(mLaunchTask, 2000);
            }
        });
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Skipping Question", Toast.LENGTH_SHORT).show();
                //unsure if this intent button works. All skip button in QuizInterfaceFragment,2,3,4,5 jump directly
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

                mHandler.postDelayed(mLaunchTask, 2000);
            }
        });
    }

    public void displayQuestion(int questionNum, View v)
    {
        if (questionNum >= 1 && questionNum <=5) {
            try {
                TextView question = (TextView) v.findViewById(R.id.questionText);
                int resId = this.getResources().getIdentifier("Q"+questionNum, "string", getActivity().getApplicationContext().getPackageName());
                String qText = getString(resId);
                question.setText(qText);

                TextView answer = (TextView) v.findViewById(R.id.answerText);
                String aText = getString(this.getResources().getIdentifier("A"+questionNum, "string", getActivity().getApplicationContext().getPackageName()));
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