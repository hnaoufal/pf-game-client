package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.Point;

public class ComputerStore extends Place{

    public ComputerStore(String assetSrc, Point position) {
        super(assetSrc, position);
        this.moneyValue = 5; // Wie schnell kann man hier Geld stehlen?
        this.securityRating = 4; //Wie wahrscheinlich ist ein Alarm?
    }
}
