package com.pr.gameclient.models.persons;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Robber extends Person {
    Integer stealth;
    Integer skill;

    ImageView portrait;

    ImageView icon;

    public Robber(String name, String assetSrc, ImageView portrait, ImageView icon, Integer stealth, Integer skill) {
        super(name, assetSrc);
        this.stealth = stealth;
        this.skill = skill;
        this.portrait = portrait;
        this.icon = icon;
    }

    @Override
    public void move(ImageView target)
    {
        //icon.relocate(target.getLayoutX(),target.getLayoutY());

        TranslateTransition tt = new TranslateTransition();
        tt.setByX(target.getLayoutX() - icon.getLayoutX());
        tt.setByY(target.getLayoutY() - icon.getLayoutY());
        tt.setDuration(Duration.millis(3000));
        tt.setCycleCount(1);
        tt.setNode(icon);
        tt.play();
        tt.setOnFinished(event -> updateLocation(target));
    }

    private void updateLocation(ImageView target){
        icon.relocate(target.getLayoutX(),target.getLayoutY());
        icon.setTranslateX(0);
        icon.setTranslateY(0);
    }

    public ImageView getPortrait() {
        return portrait;
    }

    public ImageView getIcon() {
        return icon;
    }

    public String getName(){
        return name;
    }
}
