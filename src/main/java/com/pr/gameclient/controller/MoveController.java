package com.pr.gameclient.controller;

import javafx.animation.AnimationTimer;
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
    @FXML
    private ImageView sprite;
    private BooleanProperty w = new SimpleBooleanProperty();
    private BooleanProperty a = new SimpleBooleanProperty();
    private BooleanProperty s = new SimpleBooleanProperty();
    private BooleanProperty d = new SimpleBooleanProperty();
    private BooleanBinding keyPressed = w.or(a).or(s).or(d);
    private int speed = 5;

    AnimationTimer animationTimer = new AnimationTimer() {
        public void handle(long timestamp) {

        if(w.get()) {
            sprite.setLayoutY(sprite.getLayoutY() - speed);
        }
        if(s.get()){
            sprite.setLayoutY(sprite.getLayoutY() + speed);
        }
        if(a.get()){
            sprite.setLayoutX(sprite.getLayoutX() - speed);
        }
        if(d.get()){
            sprite.setLayoutX(sprite.getLayoutX() + speed);
        }
        borderOfDeck();
        }
    };

    public void move(AnchorPane scene, ImageView sprite){

        this.scene = scene;
        this.sprite = sprite;

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

    // Verhindert, dass sich die Spieler außerhalb der gesetzten Grenzen bewegen
    private void borderOfDeck() {

        double leftBound = 100;
        double rightBound = scene.getHeight() + 80;
        double bottomBound = scene.getWidth() - 383; // Eigentlich Scrollpane, daher u.a. hier nacharbeiten !!!
        double topBound = 100;

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