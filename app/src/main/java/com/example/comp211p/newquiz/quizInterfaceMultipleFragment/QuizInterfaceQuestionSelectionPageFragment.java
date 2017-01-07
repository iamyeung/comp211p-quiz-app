package com.example.comp211p.newquiz.quizInterfaceMultipleFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.comp211p.newquiz.HighScores;
import com.example.comp211p.newquiz.QuizApp;
import com.example.comp211p.newquiz.QuizInterface1;
import com.example.comp211p.newquiz.R;

import static com.example.comp211p.newquiz.R.id.container;

/**
 * Created by Spartan-JT on 06/01/2017.
 */

public class QuizInterfaceQuestionSelectionPageFragment extends Fragment {

    private Button Q1;
    private Button Q2;
    private Button Q3;
    private Button Q4;
    private Button Q5;

    Fragment quizInterfaceMultipleFragment1;
    Fragment quizInterfaceMultipleFragment2;
    Fragment quizInterfaceMultipleFragment3;
    Fragment quizInterfaceMultipleFragment4;
    Fragment quizInterfaceMultipleFragment5;
    FragmentTransaction fragTransaction;


    public QuizInterfaceQuestionSelectionPageFragment () {

    }

    public void commitTransaction (Fragment quizInterfaceFragmentNumber) {
        fragTransaction = getFragmentManager().beginTransaction().add(container, quizInterfaceFragmentNumber);
        fragTransaction.commit();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_interface_question_selection_page_fragment, container, false);

        //creating question page
        Q1 = (Button)view.findViewById(R.id.question1);
        Q2 = (Button)view.findViewById(R.id.question2);
        Q3 = (Button)view.findViewById(R.id.question3);
        Q4 = (Button)view.findViewById(R.id.question4);
        Q5 = (Button)view.findViewById(R.id.question5);

        //when click button 1, it will go to QuizInterfaceMultipleFragment1
        Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment1 = new QuizInterfaceMultipleFragment1();
                commitTransaction(quizInterfaceMultipleFragment1);
            }
        });

        //when click button 2, it will go to QuizInterfaceMultipleFragment2
        Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment2 = new QuizInterfaceMultipleFragment2();
                commitTransaction(quizInterfaceMultipleFragment2);
            }
        });

        Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment3 = new QuizInterfaceMultipleFragment3();
                commitTransaction(quizInterfaceMultipleFragment3);
            }
        });

        Q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment4 = new QuizInterfaceMultipleFragment4();
                commitTransaction(quizInterfaceMultipleFragment4);
            }
        });

        Q5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment5 = new QuizInterfaceMultipleFragment5();
                commitTransaction(quizInterfaceMultipleFragment5);
            }
        });

        // disable buttons if questions have been answered
        QuizApp logic = (QuizApp) getContext();
        // check which questions the active players has already answered
        if (logic.hasAnsweredQuestion(1)) disableButton(Q1);
        if (logic.hasAnsweredQuestion(2)) disableButton(Q2);
        if (logic.hasAnsweredQuestion(3)) disableButton(Q3);
        if (logic.hasAnsweredQuestion(4)) disableButton(Q4);
        if (logic.hasAnsweredQuestion(5)) disableButton(Q5);

        if (logic.hasAnsweredQuestion(1) && logic.hasAnsweredQuestion(2) && logic.hasAnsweredQuestion(3) &&
                logic.hasAnsweredQuestion(4) && logic.hasAnsweredQuestion(5))
        {
            goToScorePage();
        }
        return view;
    }

    public void goToScorePage() {
        Intent intent = new Intent(getActivity(), HighScores.class);
        startActivity(intent);
    }

    /**
     * Repeats the game for player 2. Starts by going to the Question Selection page.
     */
    public void startPlayer2()
    {
        QuizApp logic = (QuizApp) getContext();
        // switch from player 1 to player 2
        logic.switchPlayer();

        // TODO: REPEAT ALL QUESTIONS FOR PLAYER 2 (go to question selection page)
    }

    /**
     * Disables one of the five question buttons (should be used when question is already answered)
     * param num Number of the question button to be disabled: 1-5
     */

    public void disableButton (Button ButtonName)
    {
        ButtonName.setEnabled(false);

        /*
        if (num>=0 && num <= 5) {
            //TODO
            // will be accessed when a question has been answered
        }
        */
    }

}
