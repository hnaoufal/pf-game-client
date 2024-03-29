package com.pr.gameclient.models.places;

import com.pr.gameclient.models.assets.AssetEntity;
import com.pr.gameclient.models.assets.Point;
import javafx.scene.image.ImageView;

public abstract class Place implements AssetEntity {

    //Source für das mit dem Asset verknüpfte Bild
    String assetSrc;

    //Die Position des place auf dem Spielfeld
    Point position;

    //Rate, mit der man hier Geld stehlen kann 1-10, 1 = wenig Geld, 10 = viel Geld, 0 = kein Geld
    Integer moneyValue;

    //Wie wahrscheinlich ist, das Alarm ausgelöst wird 1-10, 1 = unwahrscheinlich, 10 = sehr wahrscheinlich
    Integer securityRating;

    ImageView icon;

    //Constructor
    Place(String assetSrc, Point position){
        this.assetSrc = assetSrc;
        this.position = position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public Integer getMoneyValue() {
        return moneyValue;
    }
}
