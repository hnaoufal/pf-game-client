package com.pr.gameclient.models.persons;

import javafx.scene.image.ImageView;

public class Policeman extends Person {
    Integer speed;

    Policeman(String name, String assetSrc, Integer speed) {
        super(name, assetSrc);
        this.speed = speed;
    }

    @Override
    public void move(ImageView target) {

        System.out.println("hallo");
    }
}
