package com.pr.gameclient.models.persons;

public class Police extends Person {
    Integer speed;

    Police(String name, String assetSrc, Integer speed) {
        super(name, assetSrc);
        this.speed = speed;
    }

    @Override
    void move() {
        System.out.println("hallo");
    }
}
