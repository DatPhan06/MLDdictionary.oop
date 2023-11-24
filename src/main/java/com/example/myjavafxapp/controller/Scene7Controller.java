package com.example.myjavafxapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scene7Controller extends DictionaryController{
    @FXML
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void switchToScene1(ActionEvent event) throws Exception {
        loadScene("Scene1.fxml");
    }

    public void switchToScene2(ActionEvent event) throws Exception {
        loadScene("Scene2.fxml");
    }

    public void switchToScene3(ActionEvent event) throws Exception {
        loadScene("Scene3.fxml");
    }
    public void switchToScene4(ActionEvent event) throws Exception {
        loadScene("Scene4.fxml");
    }
    public void switchToScene5(ActionEvent event) throws Exception {
        loadScene("Scene5.fxml");
    }
    public void switchToScene6(ActionEvent event) throws Exception {
        loadScene("Scene6.fxml");
    }

    private void loadScene(String fxmlFileName) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/myjavafxapp/" + fxmlFileName));
        Parent root = loader.load();

        // Lấy controller của scene mới và truyền primaryStage
        Object controller = loader.getController();
        if (controller instanceof Scene1Controller) {
            ((Scene1Controller) controller).setPrimaryStage(primaryStage);
        } else if (controller instanceof Scene2Controller) {
            ((Scene2Controller) controller).setPrimaryStage(primaryStage);
        } else if (controller instanceof Scene3Controller) {
            ((Scene3Controller) controller).setPrimaryStage(primaryStage);
        } else if (controller instanceof Scene4Controller) {
            ((Scene4Controller) controller).setPrimaryStage(primaryStage);
        } else if (controller instanceof Scene5Controller) {
            ((Scene5Controller) controller).setPrimaryStage(primaryStage);
        } else if (controller instanceof Scene6Controller) {
            ((Scene6Controller) controller).setPrimaryStage(primaryStage);
        } else if (controller instanceof Scene7Controller) {
            ((Scene7Controller) controller).setPrimaryStage(primaryStage);
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }
}


