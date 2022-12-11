package com.pr.gameclient.models.persons;

public class Policeman extends Person {
    Integer speed;

    Policeman(String name, String assetSrc, Integer speed) {
        super(name, assetSrc);
        this.speed = speed;
    }

    @Override
    void move() {

        System.out.println("hallo");
    }
}
