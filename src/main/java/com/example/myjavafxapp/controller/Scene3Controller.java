package com.example.myjavafxapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import com.darkprograms.speech.translator.GoogleTranslate;

import java.io.IOException;

public class Scene3Controller {

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea resultTextArea;

    @FXML
    private Button translateButton;
    @FXML
    private Stage primaryStage;


    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void translateButtonAction() throws IOException {
        // Logic khi nút translate được nhấn

        String searchTerm = inputTextArea.getText();
        String result = GoogleTranslate.translate("vi", searchTerm);

//        String result = performTranslate(searchTerm);

        resultTextArea.setText(result);
    }

//
//    private String performTranslate(String searchTerm) throws IOException {
//        // Logic tìm kiếm từ
//
//        return GoogleTranslate.translate("vi", searchTerm);
//    }

    public void switchToScene1(ActionEvent event) throws Exception {
        loadScene("Scene1.fxml");
    }

    public void switchToScene2(ActionEvent event) throws Exception {
        loadScene("Scene2.fxml");
    }

    public void switchToScene4(ActionEvent event) throws Exception {
        loadScene("Scene4.fxml");
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
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

}
