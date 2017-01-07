package com.example.comp211p.newquiz.quizInterfaceMultipleFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.comp211p.newquiz.QuizApp;
import com.example.comp211p.newquiz.R;

/**
 * Created by Spartan-JT on 13/12/2016.
 */

public class QuizInterfaceTopBarMenuFragment extends Fragment{

    //initialise the buttons on the topBarMenuFragment
    private Button Questions;
    private Button Q1;
    private Button Q2;
    private Button Q3;
    private Button Q4;
    private Button Q5;

    //initialise variable to allow us to change from one fragment page to another prgament page
    Fragment quizInterfaceQuestionSelectionPageFragment;
    Fragment quizInterfaceMultipleFragment1;
    Fragment quizInterfaceMultipleFragment2;
    Fragment quizInterfaceMultipleFragment3;
    Fragment quizInterfaceMultipleFragment4;
    Fragment quizInterfaceMultipleFragment5;
    FragmentTransaction fragTransaction;

    public QuizInterfaceTopBarMenuFragment () {

    }

    //transaction to switch the fragment screens
    public void commitTransaction (Fragment quizInterfaceFragmentNumber) {
        fragTransaction = getFragmentManager().beginTransaction().add(R.id.container, quizInterfaceFragmentNumber);
        fragTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_interface_top_bar_menu_fragment, container, false);

        //creating question page
        Questions = (Button)view.findViewById(R.id.buttonToQuestionSelectionPage);
        Q1 = (Button)view.findViewById(R.id.question1);
        Q2 = (Button)view.findViewById(R.id.question2);
        Q3 = (Button)view.findViewById(R.id.question3);
        Q4 = (Button)view.findViewById(R.id.question4);
        Q5 = (Button)view.findViewById(R.id.question5);

        //first instance to initialise to fragment screen 1
        quizInterfaceQuestionSelectionPageFragment = new QuizInterfaceQuestionSelectionPageFragment();
        commitTransaction (quizInterfaceQuestionSelectionPageFragment);

        TextView playerName  = (TextView)view.findViewById(R.id.player1Name);
        QuizApp logic = (QuizApp) getContext();
        if(logic.isPlayer1Active()) {
            playerName.setText("Welcome " + logic.p1.getName() + "!");
        } else {
            playerName.setText("Welcome " + logic.p2.getName() + "!");
        }

        Questions.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceQuestionSelectionPageFragment = new QuizInterfaceQuestionSelectionPageFragment();
                commitTransaction(quizInterfaceQuestionSelectionPageFragment);
            }
        });

        //when click button 1, it will go to QuizInterfaceMultipleFragment1
        Q1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment1 = new QuizInterfaceMultipleFragment1();
                commitTransaction(quizInterfaceMultipleFragment1);
            }
        });

        //when click button 2, it will go to QuizInterfaceMultipleFragment2
        Q2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment2 = new QuizInterfaceMultipleFragment2();
                commitTransaction(quizInterfaceMultipleFragment2);
            }
        });

        Q3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment3 = new QuizInterfaceMultipleFragment3();
                commitTransaction(quizInterfaceMultipleFragment3);
            }
        });

        Q4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment4 = new QuizInterfaceMultipleFragment4();
                commitTransaction(quizInterfaceMultipleFragment4);
            }
        });

        Q5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragment5 = new QuizInterfaceMultipleFragment5();
                commitTransaction(quizInterfaceMultipleFragment5);
            }
        });

        // disable buttons if questions have been answered
        // check which questions the active players has already answered
        if (logic.hasAnsweredQuestion(1)) disableButton(Q1);
        if (logic.hasAnsweredQuestion(2)) disableButton(Q2);
        if (logic.hasAnsweredQuestion(3)) disableButton(Q3);
        if (logic.hasAnsweredQuestion(4)) disableButton(Q4);
        if (logic.hasAnsweredQuestion(5)) disableButton(Q5);

        return view;
    }

    public void onActivityCreated (Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    public void disableButton(Button ButtonName)
    {
            ButtonName.setEnabled(false);
    }

}
