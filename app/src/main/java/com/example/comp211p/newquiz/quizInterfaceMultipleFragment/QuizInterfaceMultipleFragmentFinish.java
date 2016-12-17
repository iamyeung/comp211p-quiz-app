package com.example.comp211p.newquiz.quizInterfaceMultipleFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.comp211p.newquiz.HighScores;
import com.example.comp211p.newquiz.R;


public class QuizInterfaceMultipleFragmentFinish extends Fragment {

    public QuizInterfaceMultipleFragmentFinish() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.quiz_interface_multiple_fragment_finish, container, false);

        Button FinishButton = (Button) rootView.findViewById(R.id.finishButton);
        FinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HighScores.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
