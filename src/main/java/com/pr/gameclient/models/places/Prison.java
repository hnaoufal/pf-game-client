package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.Point;

public class Prison extends Place{

    // Anzahl von Insassen im Gefängnis
    Integer inmates;

    public Prison(String assetSrc, Point position) {
        super(assetSrc, position);
        this.moneyValue = 0; // Wie schnell kann man hier Geld stehlen? Gar nicht...
        this.securityRating = 11; // Automatischer Alarm?
        this.inmates = 0; // Gefängnis startet leer
    }
}
