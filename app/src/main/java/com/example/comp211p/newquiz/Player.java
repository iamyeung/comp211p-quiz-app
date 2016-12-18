package com.example.comp211p.newquiz;

/**
 * Created by annet on 04.12.2016.
 */

public class Player {
    private String name;
    private int score;

    Player(String name)
    {
        this.name = name;
        score = 0;
    }

    public String getName()
    {
        return this.name;
    }

    public int getScore()
    {
        return this.score;
    }

    public void addScore()
    {
        this.score += 1;
    }
}
