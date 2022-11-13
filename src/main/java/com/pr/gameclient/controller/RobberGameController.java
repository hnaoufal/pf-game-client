package com.pr.gameclient.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.scene.Node;

public class RobberGameController {

    // Rückt die Karte, über der die Maus hovered nach oben und vergrößert sie. vorhergehende Karten rücken nach links
    // damit sie weiterhin sichtbar sind
    @FXML
    public void zoomCard(MouseEvent event) {

        //Die gehoverte Karte wird größer gemacht und herausgestellt
        ImageView hoveredCard = (ImageView) event.getTarget();
        hoveredCard.getTransforms().add(new Translate(-110,-170,0));
        hoveredCard.getTransforms().add(new Scale(1.5,1.5));

        //Alle Karten links von der gehoverten werden weiter nach links gerückt, damit sie sichtbar bleiben
        for (Node n : hoveredCard.getParent().getChildrenUnmodifiable()) { // Für alle Anderen Kinder der hbox in der die Karten sind
            if (n == hoveredCard) break; // Wenn wir die gehoverte Karte erreichen, hören wir auf
            n.getTransforms().add(new Translate(-110,0,0));
        }

    }

    // Stellt den Orioginalzustand wieder her, wenn man nicht mehr über einer Karte hovered
    @FXML
    public void unZoomCard(MouseEvent event) {

        ImageView image = (ImageView) event.getTarget();

        //Alle Transforms von allen Karten entfernen
        for (Node n : image.getParent().getChildrenUnmodifiable()) {
            n.getTransforms().clear();
        }
    }

}
