package com.pr.gameclient.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.transform.Translate;

import java.io.IOException;

public class RobberGameController {

    @FXML
    public void zoomCard(MouseEvent event) throws IOException {

        ImageView image = (ImageView) event.getTarget();
        image.getTransforms().add(new Translate(0,-50,0));
    }

    @FXML
    public void unZoomCard(MouseEvent event) throws IOException {

        ImageView image = (ImageView) event.getTarget();
        image.getTransforms().add(new Translate(0,50,0));
    }

}
