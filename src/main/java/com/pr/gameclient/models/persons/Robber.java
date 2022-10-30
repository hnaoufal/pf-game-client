package com.pr.gameclient.models.persons;

public class Robber extends Person {
    Integer speed;

    Robber(String name, String assetSrc, Integer speed) {
        super(name, assetSrc);
        this.speed = speed;
    }

    @Override
    void move() {
        System.out.println("hallo");
    }
}
