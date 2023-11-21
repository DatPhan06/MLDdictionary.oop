package com.example.myjavafxapp;

import com.example.myjavafxapp.controller.Scene1Controller;
import com.example.myjavafxapp.sqlite.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.darkprograms.speech.translator.GoogleTranslate;

import java.io.IOException;

public class DictionaryApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        DatabaseManager.createTable();

//        DatabaseManager.insertData("dog","n","chó","","","","");
//        DatabaseManager.insertData("cat","n","mèo","","","","");
//        DatabaseManager.insertData("bird","n","chim","","","","");

        // Lấy và in ra dữ liệu
//        DatabaseManager.fetchData();

        try {
            //English to Vietnamese
            System.out.println(GoogleTranslate.translate("vi", "how are you"));

            //English to GREEK
            System.out.println(GoogleTranslate.translate("vi", "hello brother"));

            //English to HAUSA
            System.out.println(GoogleTranslate.translate("vi", "play game"));

            //English to Yoruba
            System.out.println(GoogleTranslate.translate("vi", "english is very good"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        Parent root = loader.load();

        Scene1Controller scene1Controller = loader.getController();
        scene1Controller.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setResizable(false); // Thiết lập cố định cửa sổ
//      scene.getStylesheets().add(getClass().getResource("/graphic/css/scene1.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Scene");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}


//public class DictionaryApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//
//        FXMLLoader fxmlLoader = new FXMLLoader(DictionaryApplication.class.getResource("home-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
//        // Áp dụng CSS
//        scene.getStylesheets().add(getClass().getResource("/graphic/css/Dictionary.css").toExternalForm());
//        stage.setTitle("Dictionary Application!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}