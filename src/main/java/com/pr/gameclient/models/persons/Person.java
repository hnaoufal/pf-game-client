package com.pr.gameclient.models.persons;

import com.pr.gameclient.models.assets.AssetEntity;
import com.pr.gameclient.models.assets.Point;

public abstract class Person implements AssetEntity {
    String assetSrc;

    String name;

    Point position;

    Person(String name, String assetSrc) {
        this.assetSrc = assetSrc;
        this.name = name;
        this.position = new Point(0, 0);
    }

    public void move(Point building) {
        System.out.println(building);
    }

    abstract void move();
}
