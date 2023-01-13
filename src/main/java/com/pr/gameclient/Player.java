package com.pr.gameclient;

import java.util.Vector;

public class Player {
    String name;
    private int games;
    private int wins;
    private int defeats;
    int score;
    private Vector handCards;
    private Vector deckCards;

    public Player(String playerPoliceman, String playerRobber, int playerScore)
    {
        this.name = playerPoliceman;
        this.name = playerRobber;

        this.score = playerScore;
        handCards = new Vector();
        deckCards = new Vector();
    }

    public void drawCardFromDeck(Vector deckCards) {
        handCards.addElement(deckCards);
    }

    public Vector playCard(int p) {
        if ((p >= 0) && (p < handCards.size()))
            return (Vector)handCards.elementAt(p);
        else
            return null;
    }

    public int getScore() {
        if(games != 0) {
            score = wins / games * 100;
        }
        return score;
    }

    public void surrender() {
        System.out.println("Du hast aufgegeben!");
        handCards.removeAllElements();
    }

    public String selectPlayerName() {
        return name;
    }

    public void commandName(String name) {
        this.name = name;
    }
}
