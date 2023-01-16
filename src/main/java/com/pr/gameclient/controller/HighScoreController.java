package com.pr.gameclient.controller;
import com.pr.gameclient.helpers.HTTPClient;
import com.pr.gameclient.models.game.HighScore;
import com.pr.gameclient.models.user.RankingMapper;
import com.pr.gameclient.models.user.UserMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.stage.Stage;

public class HighScoreController {
    @FXML private TableView<HighScore> highScoreTable;
    @FXML private TableColumn<HighScore, String> nameColumn;
    @FXML private TableColumn<HighScore, Integer> pointsColumn;
    @FXML
    private Button backButton;

    private ObservableList<HighScore> highScores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        pointsColumn.setCellValueFactory(cellData -> cellData.getValue().pointsProperty().asObject());

        highScoreTable.setItems(highScores);
        loadHighScores();
    }

    private void loadHighScores() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Ranking
            String rankingsJson = HTTPClient.get("http://localhost:8080/api/rankings");
            List<RankingMapper> rankings = mapper.readValue(rankingsJson, mapper.getTypeFactory().constructCollectionType(List.class, RankingMapper.class));

            for (RankingMapper rank: rankings) {
                UserMapper user = rank.getUser();
                highScores.add(new HighScore(user.getName(), rank.getPoints()));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        backButton.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("/com/pr/gameclient/Start.fxml"));
        Scene sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node)  actionEvent.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }
}
