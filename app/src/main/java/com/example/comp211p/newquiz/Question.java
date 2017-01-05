package com.example.comp211p.newquiz;

/**
 * Created by annet on 18.12.2016.
 */

public class Question {
    private String q;
    private String a;
    private boolean t;

    Question (String q, String a, boolean t)
    {
        this.q = q;
        this.a = a;
        this.t = t;
    }

    public boolean isTrue()
    {
        return this.t;
    }

    public String getQuestion()
    {
        return this.q;
    }

    public String getAnswer()
    {
        return this.a;
    }
}
