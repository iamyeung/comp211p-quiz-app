package com.example.comp211p.newquiz;

import android.app.Application;

public class QuizApp extends Application {

    private String singlePlayerName;
    private String twoPlayerName1;
    private String twoPlayerName2;

    public String getSinglePlayerName() {
        return singlePlayerName;
    }

    public void setSinglePlayerName (String aSinglePlayerName) {
        singlePlayerName = aSinglePlayerName;
    }

    public String getTwoPlayerName1() {
        return twoPlayerName1;
    }

    public void setTwoPlayerName1 (String aTwoPlayerName1) {
        twoPlayerName1 = aTwoPlayerName1;
    }

    public String getTwoPlayerName2() {
        return twoPlayerName2;
    }

    public void setTwoPlayerName2 (String aTwoPlayerName2) {
        twoPlayerName2 = aTwoPlayerName2;
    }

}
