package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.Point;

public class PoliceHQ extends Place {

    public PoliceHQ(String assetSrc, Point position) {
        super(assetSrc, position);
        this.moneyValue = 0; // Hier gibts nichts zu stehlen
        this.securityRating = 0; // Automatischer Alarm?
    }
}
