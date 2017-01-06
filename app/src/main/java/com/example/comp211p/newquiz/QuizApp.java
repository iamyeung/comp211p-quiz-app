package com.example.comp211p.newquiz;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class QuizApp extends Application {
    public Player p1;
    public Player p2;
    private boolean player1Active;
    private boolean isSinglePlayer;
    private LinkedList<Player> history;
    //history of recent players
    private Question[] questions;
    private int currentQuestion;
    private boolean gameOver;

    QuizApp ()
    {
        super();
        this.isSinglePlayer = true;
        this.player1Active = true;
        this.history = new LinkedList<Player>();
        this.gameOver = false;

        this.currentQuestion = 0;
        this.questions = new Question[5];
        // Load all questions from resources
        questions[0] = new Question(
                getResources().getString(R.string.Q1),
                getResources().getString(R.string.A1),
                getResources().getBoolean(R.bool.T1));
        questions[1] = new Question(
                getResources().getString(R.string.Q2),
                getResources().getString(R.string.A2),
                getResources().getBoolean(R.bool.T2));
        questions[2] = new Question(
                getResources().getString(R.string.Q3),
                getResources().getString(R.string.A3),
                getResources().getBoolean(R.bool.T3));
        questions[3] = new Question(
                getResources().getString(R.string.Q4),
                getResources().getString(R.string.A4),
                getResources().getBoolean(R.bool.T4));
        questions[4] = new Question(
                getResources().getString(R.string.Q5),
                getResources().getString(R.string.A5),
                getResources().getBoolean(R.bool.T5));
    }

    public void startSinglePlayer()
    {
        isSinglePlayer = true;
        initGame();
    }

    public void startMultiPlayer()
    {
        isSinglePlayer = false;
        initGame();
    }

    private void initGame()
    {
        this.gameOver = false;
        this.p1 = null;
        this.p2 = null;
        this.player1Active = true;
        this.currentQuestion = 0;
    }

    public boolean getIsSinglePlayer()
    {
        return isSinglePlayer;
    }

    public boolean isPlayer1Active()
    {
        return player1Active;
    }

    public int getActivePlayer() { return (isPlayer1Active() ? 1 : 2); }

    public int getInactivePlayer() { return (isPlayer1Active() ? 2 : 1); }

    public boolean isGameOver() { return this.gameOver; }

    public void switchPlayer()
    {
        this.player1Active = (!this.player1Active);
    }

    /**
     *
     * @param pnum Player number (1 or 2)
     * @param name Name of the player
     */
    private void namePlayer(int pnum, String name)
    {
        // name player 1
        if (pnum==1){
            p1 = new Player(name);
        // name player 2 (multiplayer)
        } else if (!this.isSinglePlayer && pnum==2) {
            p2 = new Player(name);
        }
    }

    public void addPlayer(String name)
    {
        // player 1 does not exist yet
        if (this.p1 == null) {
            // make new player 1
            namePlayer(1, name);
        // player 1 already exists and game is multiplayer and player 2 not yet defined
        }
        else if (!this.isSinglePlayer && this.p2 == null)
        {
            namePlayer(2, name);
        }
    }

    public int getCurrentQuestion()
    {
        return this.currentQuestion;
    }

    public void setCurrentQuestion(int questionNumber)
    {
        if (questionNumber>=1 && questionNumber<=5) {
            this.currentQuestion = questionNumber;
        }
    }

    public void answerQuestion(boolean answerTrue)
    {
        int questionNumber = this.getCurrentQuestion();
        boolean correct = (this.questions[questionNumber-1].isTrue() == answerTrue);
        // player 1 is playing
        if (isPlayer1Active()) {
            p1.answerQuestion(questionNumber, correct);
        }
        // player 2 is playing
        else
        {
            p2.answerQuestion(questionNumber, correct);
        }
        checkProgress();
    }

    public void cheatQuestion()
    {
        int questionNumber = this.getCurrentQuestion();
        // player 1 is playing
        if (isPlayer1Active()) {
            p1.answerQuestion(questionNumber, false);
        } else {
            p2.answerQuestion(questionNumber, false);
        }
        checkProgress();
    }

    public boolean hasAnsweredQuestion(int questionNumber)
    {
        if (questionNumber>=1 && questionNumber<=5)
        {
            if (isPlayer1Active())
            {
                return p1.hasAnsweredQuestion(questionNumber);
            } else {
                return p2.hasAnsweredQuestion(questionNumber);
            }
        } else {
            return false;
        }
    }

    /**
     * Switches active player if one player has answered all questions.
     * If both players have answered all questions, the game is ended.
     */
    private void checkProgress()
    {
        // current player has already answered all questions
        if (isPlayerDone(getActivePlayer()))
        {
            // inactive player is also finished
            if (isPlayerDone(getInactivePlayer()))
            {
                // set flag for gameOver and add players to history
                gameOver();
            // if current player is done but other one not - switch player
            } else {
                switchPlayer();
            }
        }
    }

    public boolean isPlayerDone(int playerNum)
    {
        if (playerNum == 1)
        {
            if (this.p1.getQuestionsAnswered().size() == this.questions.length)
            {
                return true;
            }
        } else if (playerNum == 2) {
            if (this.p2.getQuestionsAnswered().size() == this.questions.length)
            {
                return true;
            }
        }
        return false;
    }

    private void gameOver()
    {
        if (!isGameOver()) {
            this.gameOver = true;
            addToPlayerHistory(this.p2);
            addToPlayerHistory(this.p1);
        }
    }

    /**
     * Adds to recent players to be displayed on "high score" page.
     * New additions are displayed first.
     * @param p Player to be added to history.
     */
    public void addToPlayerHistory(Player p)
    {
        this.history.addFirst(p);
    }

    public Player[] getPlayerHistory(int count)
    {
        if (count>=0) {
            Player[] players = new Player[count];
            for (int i=0; i<=count-1; i++)
            {
                players[i] = this.history.get(i);
            }
            return players;
        }
        return new Player[0];
    }



    /*
    public static String singlePlayerName;
    public static String twoPlayerName1;
    public static String twoPlayerName2;
    public static  int singlePlayerScore; */


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
