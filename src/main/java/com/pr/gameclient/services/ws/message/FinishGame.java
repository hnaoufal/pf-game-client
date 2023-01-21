package com.pr.gameclient.services.ws.message;

public class FinishGame {
    String winnerLogin;
    boolean isWin;

    public FinishGame(boolean isWin, String winnerLogin) {
        this.winnerLogin = winnerLogin;
        this.isWin = isWin;
    }

    public String getWinnerLogin() {
        return winnerLogin;
    }

    public void setWinnerLogin(String winnerLogin) {
        this.winnerLogin = winnerLogin;
    }

    public boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(boolean isWin) {
        this.isWin = isWin;
    }
}
