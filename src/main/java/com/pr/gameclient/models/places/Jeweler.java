package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.Point;

public class Jeweler extends Place{

    public Jeweler(String assetSrc, Point position) {
        super(assetSrc, position);
        this.moneyValue = 8; // Wie schnell kann man hier Geld stehlen?
        this.securityRating = 8; //Wie wahrscheinlich ist ein Alarm?
    }
}
