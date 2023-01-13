package com.pr.gameclient.models.persons;

public class Robber extends Person {
    Integer stealth;
    Integer skill;

    Robber(String name, String assetSrc, Integer stealth, Integer skill) {
        super(name, assetSrc);
        this.stealth = stealth;
        this.skill = skill;
    }

    @Override
    void move() {
        System.out.println("hallo");
    }
}
