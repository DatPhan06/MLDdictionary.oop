package com.example.myjavafxapp.controller;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Scene1Controller {
    @FXML
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void switchToScene2(ActionEvent event) throws Exception {
//        loadScene("Scene2.fxml");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/myjavafxapp/Scene2.fxml"));
        Parent root = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public void switchToScene3(ActionEvent event) throws Exception {
//        loadScene("Scene3.fxml");
        System.out.println("PrimaryStage before loading Scene4: " + primaryStage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/myjavafxapp/Scene3.fxml"));
        Parent root = loader.load();

        Scene3Controller scene3Controller = loader.getController();
        scene3Controller.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public void switchToScene4(ActionEvent event) throws Exception {
//        loadScene("Scene4.fxml");
        System.out.println("PrimaryStage before loading Scene4: " + primaryStage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/myjavafxapp/Scene4.fxml"));
        Parent root = loader.load();

        Scene4Controller scene4Controller = loader.getController();
        scene4Controller.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

//    private void loadScene(String fxmlFileName) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/com/example/myjavafxapp/" + fxmlFileName));
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//    }

}