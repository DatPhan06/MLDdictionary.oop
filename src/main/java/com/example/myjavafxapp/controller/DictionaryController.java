package com.example.myjavafxapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public abstract class DictionaryController {

    @FXML
    private Stage primaryStage;


    public abstract void setPrimaryStage(Stage primaryStage);

}