package com.pr.gameclient.controller;

import com.pr.gameclient.services.ws.common.msginteraction.message.MoveMessage;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class MoveController {

    @FXML
    private AnchorPane scene;

    private ImageView sprite;
    private ImageView opponentSprite;
    private BooleanProperty w = new SimpleBooleanProperty();
    private BooleanProperty a = new SimpleBooleanProperty();
    private BooleanProperty s = new SimpleBooleanProperty();
    private BooleanProperty d = new SimpleBooleanProperty();
    private BooleanBinding keyPressed = w.or(a).or(s).or(d);
    private int speed = 5;

    AnimationTimer animationTimer = new AnimationTimer() {
        public void handle(long timestamp) {
        double x = sprite.getLayoutX();
        double y = sprite.getLayoutY();

        if(w.get()) {
            y -= speed;
        }
        if(s.get()){
            y += speed;
        }
        if(a.get()){
            x -= speed;
        }
        if(d.get()){
            x += speed;
        }

        sprite.setLayoutY(y);
        sprite.setLayoutX(x);
        ClientPresenter.getInstance().sendToServer(new MoveMessage(x, y));
        borderOfDeck();
        }
    };

    // Split string by "/" and get x and y as Double
    // Set sprite layout x and y
    public void movePlayer(String moveMessage) {
        Platform.runLater(() -> {
            String[] parts = moveMessage.split("/");
            double x = Double.parseDouble(parts[0]);

            double y = Double.parseDouble(parts[1]);
            opponentSprite.setLayoutX(x);
            opponentSprite.setLayoutY(y);
        });
    }



    public void move(AnchorPane scene, ImageView ownSprite, ImageView opponentSprite){

        this.scene = scene;
        this.sprite = ownSprite;
        this.opponentSprite = opponentSprite;

        setup();

        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                animationTimer.start();
            } else {
                animationTimer.stop();
            }
        }));
    }

    // Bewegungseinstellungen
    private void setup(){

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.W) {
                w.set(true);
            }
            if(e.getCode() == KeyCode.A) {
                a.set(true);
            }
            if(e.getCode() == KeyCode.S) {
                s.set(true);
            }
            if(e.getCode() == KeyCode.D) {
                d.set(true);
            }
        });

        scene.setOnKeyReleased(e -> {
            if(e.getCode() == KeyCode.W) {
                w.set(false);
            }
            if(e.getCode() == KeyCode.A) {
                a.set(false);
            }
            if(e.getCode() == KeyCode.S) {
                s.set(false);
            }
            if(e.getCode() == KeyCode.D) {
                d.set(false);
            }
        });
    }

    public void clearInputs(){
        w.set(false);
        a.set(false);
        s.set(false);
        d.set(false);
    }

    // Verhindert, dass sich die Spieler außerhalb der gesetzten Grenzen bewegen
    private void borderOfDeck() {

        double leftBound = 95;
        double rightBound = scene.getHeight() + 75;
        double bottomBound = scene.getWidth() - 391;
        double topBound = 101;

        if(sprite.getLayoutX() <= leftBound){
            sprite.setLayoutX(leftBound);
        }
        if(sprite.getLayoutX() >= rightBound){
            sprite.setLayoutX(rightBound);
        }
        if(sprite.getLayoutY() <= topBound){
            sprite.setLayoutY(topBound);
        }
        if(sprite.getLayoutY() >= bottomBound){
            sprite.setLayoutY(bottomBound);
        }
    }
}
