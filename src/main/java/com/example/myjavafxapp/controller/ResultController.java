package com.example.myjavafxapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class ResultController {
    @FXML
    private Label scoreLabel;
    @FXML
    private ListView<String> wrongAnswersListView;

    // Các biến và phương thức khác...

    public void setScore(int score) {
        scoreLabel.setText("Điểm số của bạn: " + score);
    }

    public void setWrongAnswers(List<String> wrongAnswers) {
        wrongAnswersListView.getItems().addAll(wrongAnswers);
    }

    public void closeResult(ActionEvent actionEvent) {

    }

}
