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
    Fragment quizInterfaceMultipleFragment1;
    Fragment quizInterfaceMultipleFragment2;
    Fragment quizInterfaceMultipleFragment3;
    Fragment quizInterfaceMultipleFragment4;
    Fragment quizInterfaceMultipleFragment5;
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
        quizInterfaceMultipleFragment1 = new QuizInterfaceMultipleFragment1();
        fragTransaction = getFragmentManager().beginTransaction().add(R.id.container, quizInterfaceMultipleFragment1);
        fragTransaction.commit();


        TextView playerName  = (TextView)view.findViewById(R.id.player1NameAndScore);
        QuizApp logic = (QuizApp) getContext();
        if(logic.isPlayer1Active()) {
            playerName.setText("Welcome " + logic.p1.getName() + "!");
        } else {
            playerName.setText("Welcome " + logic.p2.getName() + "!");
        }

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

        FINISH.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                quizInterfaceMultipleFragmentFinish = new QuizInterfaceMultipleFragmentFinish();
                commitTransaction(quizInterfaceMultipleFragmentFinish);
            }
        });

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
