package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.Point;

public class Park extends Place {

    public Park(String assetSrc, Point position) {
        super(assetSrc, position);
        this.moneyValue = 1; // Wie schnell kann man hier Geld stehlen?
        this.securityRating = 1; //Wie wahrscheinlich ist ein Alarm?
    }
}
