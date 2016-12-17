package com.example.comp211p.newquiz;

import android.app.Application;

public class QuizApp extends Application {

    public static String singlePlayerName;
    public static String twoPlayerName1;
    public static String twoPlayerName2;
    public static  int singlePlayerScore;


    /* The following code is not needed if we are using the static operator, but I am going to leave it here just in case.
    public String getSinglePlayerName() {
        return singlePlayerName;
    }
    public void setSinglePlayerName (String aSinglePlayerName) { singlePlayerName = aSinglePlayerName; }

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

    public int getSinglePlayerScore () { return singlePlayerScore; }
    public void setSinglePlayerScore (String aSinglePlayerScore) { singlePlayerName = aSinglePlayerScore; }
    */
}
