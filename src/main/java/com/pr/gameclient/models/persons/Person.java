package com.pr.gameclient.models.persons;

import com.pr.gameclient.models.assets.AssetEntity;
import com.pr.gameclient.models.assets.Point;
import javafx.scene.image.ImageView;

public abstract class Person implements AssetEntity {
    String assetSrc;

    String name;

    Point position;

    Person(String name, String assetSrc) {
        this.assetSrc = assetSrc;
        this.name = name;
        this.position = new Point(0, 0);
    }

    abstract public void move(ImageView target);
}
