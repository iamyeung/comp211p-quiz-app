package com.example.comp211p.newquiz;

import android.app.Application;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class QuizApp extends Application {

    public Player p1;
    public Player p2;
    private boolean player1Active;
    private boolean isSinglePlayer;
    private LinkedList<Player> history;

    public void startSinglePlayer()
    {
        isSinglePlayer = true;
    }

    public void startMultiPlayer()
    {
        isSinglePlayer = false;
    }

    public boolean getIsSinglePlayer()
    {
        return isSinglePlayer;
    }

    public boolean isPlayer1Active()
    {
        return player1Active;
    }

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
        // if single player add new player 1 if not yet exists
        if (this.isSinglePlayer && this.p1 == null) {
            namePlayer(1, name);
        // if multiplayer add new player 2 if not yet exists
        } else if (!this.isSinglePlayer){
            namePlayer(2, name);
        }
    }

    public void addToPlayerHistory(Player p)
    {
        this.history.addFirst(p);
    }

    QuizApp ()
    {
        super();
        this.isSinglePlayer = true;
        this.history = new LinkedList<Player>();
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
