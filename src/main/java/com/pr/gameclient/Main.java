package com.pr.gameclient;

import com.pr.gameclient.controller.MenuController;
import com.pr.gameclient.services.ws.client.ClientService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage stage)  throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Start.fxml"));
        Parent root = fxmlLoader.load();
        MenuController startWindowController = fxmlLoader.getController();
        startWindowController.setStage(stage);

        Context context = Context.getInstance();
        context.setLoader(fxmlLoader);

        ClientService cs = new ClientService();
        cs.connect("localhost", "Hicham" + gen(), System.out::println, System.out::println);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dont get Caught");
        stage.show();
    }

    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return 10000 + r.nextInt(20000);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
