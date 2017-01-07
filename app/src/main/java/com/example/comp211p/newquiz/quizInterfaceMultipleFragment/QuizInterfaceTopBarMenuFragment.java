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
    private Button Q1;
    private Button Q2;
    private Button Q3;
    private Button Q4;
    private Button Q5;
    private Button FINISH;

    //initialise variable to allow us to change from one fragment page to another prgament page
    Fragment questionFragment;
    Fragment quizInterfaceMultipleFragmentFinish;
    FragmentTransaction fragTransaction;

    public QuizInterfaceTopBarMenuFragment () {

    }

    //transaction to switch the fragment screens
    public void commitTransaction (Fragment quizInterfaceFragmentNumber) {
        fragTransaction = getFragmentManager().beginTransaction().replace(R.id.container, quizInterfaceFragmentNumber);
        fragTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_interface_top_bar_menu_fragment, container, false);

        Q1 = (Button)view.findViewById(R.id.Q1Button);
        Q2 = (Button)view.findViewById(R.id.Q2Button);
        Q3 = (Button)view.findViewById(R.id.Q3Button);
        Q4 = (Button)view.findViewById(R.id.Q4Button);
        Q5 = (Button)view.findViewById(R.id.Q5Button);
        FINISH = (Button)view.findViewById(R.id.finishButton);

        //first instance to initialise to fragment screen 1
        questionFragment = new QuizInterfaceFragment();
        fragTransaction = getFragmentManager().beginTransaction().add(R.id.container, questionFragment);
        fragTransaction.commit();


        TextView playerName  = (TextView)view.findViewById(R.id.player1NameAndScore);
        QuizApp logic = (QuizApp) getActivity().getApplicationContext();
        if(logic.isPlayer1Active()) {
            playerName.setText("Welcome " + logic.p1.getName() + "!");
        } else {
            playerName.setText("Welcome " + logic.p2.getName() + "!");
        }

        //when click button 1, it will go to QuizInterfaceFragment
        Q1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.setCurrentQuestion(1);
                questionFragment = new QuizInterfaceFragment();
                commitTransaction(questionFragment);
            }
        });

        //when click button 2, it will go to QuizInterfaceMultipleFragment2
        Q2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.setCurrentQuestion(2);
                questionFragment = new QuizInterfaceFragment();
                commitTransaction(questionFragment);
            }
        });

        Q3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.setCurrentQuestion(3);
                questionFragment = new QuizInterfaceFragment();
                commitTransaction(questionFragment);
            }
        });

        Q4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.setCurrentQuestion(4);
                questionFragment = new QuizInterfaceFragment();
                commitTransaction(questionFragment);
            }
        });

        Q5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizApp logic = (QuizApp) getActivity().getApplicationContext();
                logic.setCurrentQuestion(5);
                questionFragment = new QuizInterfaceFragment();
                commitTransaction(questionFragment);
            }
        });

        FINISH.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragmentFinish = new QuizInterfaceMultipleFragmentFinish();
                commitTransaction(quizInterfaceMultipleFragmentFinish);
            }
        });

        // disable buttons if questions have been answered
        // check which questions the active players has already answered
        if (logic.hasAnsweredQuestion(1)) Q1.setEnabled(false);
        if (logic.hasAnsweredQuestion(2)) Q2.setEnabled(false);
        if (logic.hasAnsweredQuestion(3)) Q3.setEnabled(false);
        if (logic.hasAnsweredQuestion(4)) Q4.setEnabled(false);
        if (logic.hasAnsweredQuestion(5)) Q5.setEnabled(false);

        return view;
    }

    public void onActivityCreated (Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    public void disableButton(Button QButtonNumber)
    {
        QButtonNumber.setEnabled(false);
        //QButtonNumber is a selection from Q1, Q2, Q3, Q4, Q5
    }

    public void disableAllButtons()
    {
        disableButton(Q1);
        disableButton(Q2);
        disableButton(Q3);
        disableButton(Q4);
        disableButton(Q5);
    }

}
