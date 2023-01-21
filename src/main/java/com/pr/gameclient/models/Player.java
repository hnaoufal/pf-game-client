package com.pr.gameclient.models;

import java.util.Vector;

public class Player {
    String name;

    String type;
    private int games;
    private int wins;
    private int defeats;
    int score;

    long id;
    private Vector handCards;
    private Vector deckCards;

    public Player(){}

    public Player(String name, int playerScore, Long id)
    {
        this.name = name;
        this.score = playerScore;
        this.id = id;
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
    public void setScore(int scoreInput){score = scoreInput;}

    public long getId(){
        return id;
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

    public void setType(String type) {
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
