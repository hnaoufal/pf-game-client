package com.pr.gameclient.services.ws.message;

import java.util.Random;

public class ReceiveScore {
    private int score;

    public ReceiveScore() {
        score = new Random().nextInt(6) + 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
