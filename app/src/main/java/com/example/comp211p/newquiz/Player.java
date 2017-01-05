package com.example.comp211p.newquiz;

import java.util.HashSet;

/**
 * Created by annet on 04.12.2016.
 */

public class Player {
    private String name;
    private int score;
    private HashSet<Integer> questionsAnswered;
    //to keep track of questions that the player has answered

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

    /**
     * add score point if question is answered correctly
     * @param num - number of question (0-5)
     * @param correct - if question is answered correctly
     */
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

    /**
     * based on num tells you whether question has already been answered
     * @param num - number of question
     * @return - true if already answered
     */
    public boolean hasAnsweredQuestion(int num)
    {
        return (this.questionsAnswered.contains(num));
    }

}
