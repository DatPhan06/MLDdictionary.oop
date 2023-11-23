package com.example.myjavafxapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.myjavafxapp.util.DictionaryManagement;

import java.io.IOException;

public class Scene4Controller {
    @FXML
    private Stage primaryStage;

//    private DictionaryManagement dictionaryManagement;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

//    public void setDictionaryManagement(DictionaryManagement dictionaryManagement) {
//        this.dictionaryManagement = dictionaryManagement; // Đặt đối tượng dictionaryManagement
//    }

    public void startWordGame(ActionEvent event) {
        try {

//            // Khởi tạo dictionaryManagement ở đây
//            DictionaryManagement dictionaryManagement = new DictionaryManagement();
//            dictionaryManagement.insertFromFile("src/main/resources/txt/dictionaryEVplus.txt");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/myjavafxapp/WordGame.fxml"));
            Parent wordGameRoot = loader.load();

            // Truyền primaryStage cho WordGameController
            WordGameController wordGameController = loader.getController();
            wordGameController.setPrimaryStage(primaryStage);

//            // Pass dictionaryManagement to WordGameController
//            WordGameController wordGameController = loader.getController();
//            wordGameController.setDictionaryManagement(dictionaryManagement);

            Scene scene = new Scene(wordGameRoot);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ, có thể hiển thị thông báo lỗi cho người dùng.
        }
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
    public void switchToScene5(ActionEvent event) throws Exception {
        loadScene("Scene5.fxml");
    }
    public void switchToScene6(ActionEvent event) throws Exception {
        loadScene("Scene6.fxml");
    }
    public void switchToScene7(ActionEvent event) throws Exception {
        loadScene("Scene7.fxml");
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
