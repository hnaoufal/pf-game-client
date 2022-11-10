package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.Point;

public class Supermarket extends Place {

    public Supermarket(String assetSrc, Point position) {
        super(assetSrc, position);
        this.moneyValue = 3; // Wie schnell kann man hier Geld stehlen?
        this.securityRating = 2; //Wie wahrscheinlich ist ein Alarm?
    }
}
