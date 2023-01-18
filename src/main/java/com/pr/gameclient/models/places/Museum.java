package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.Point;

public class Museum extends Place{

    public Museum(String assetSrc, Point position) {
        super(assetSrc, position);
        this.moneyValue = 10; // Wie schnell kann man hier Geld stehlen?
        this.securityRating = 5; //Wie wahrscheinlich ist ein Alarm?
    }
}
