package com.pr.gameclient;

import com.pr.gameclient.controller.GameController;
import com.pr.gameclient.controller.MenuController;
import javafx.fxml.FXMLLoader;

public class Context {
    private volatile static Context INSTANCE;
    GameController gameController;

    MenuController menuController;
    FXMLLoader loader;
    private Context() {}

    public static Context getInstance() {
        if (INSTANCE == null) {
            synchronized (Context.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Context();
                }
            }
        }
        return INSTANCE;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

}
