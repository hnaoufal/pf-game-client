package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.Point;

public class Bank extends Place{

    public Bank(String assetSrc, Point position) {
        super(assetSrc, position);
        this.moneyValue = 100; // Wie schnell kann man hier Geld stehlen?
        this.securityRating = 10; //Wie wahrscheinlich ist ein Alarm?
    }
}
