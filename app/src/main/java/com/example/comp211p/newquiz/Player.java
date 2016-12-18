package com.example.comp211p.newquiz;

import java.util.HashSet;

/**
 * Created by annet on 04.12.2016.
 */

public class Player {
    private String name;
    private int score;
    private HashSet<Integer> questionsAnswered;

    Player(String name)
    {
        this.name = name;
        score = 0;
        questionsAnswered = new HashSet<Integer>();
    }

    public String getName()
    {
        return this.name;
    }

    public int getScore()
    {
        return this.score;
    }

    private void addScore()
    {
        this.score += 1;
    }

    public void answerQuestion(int num, boolean correct)
    {
        if (correct) {
            addScore();
        }
        questionsAnswered.add(num);
    }

    public HashSet<Integer> getQuestionsAnswered()
    {
        return this.questionsAnswered;
    }
}
