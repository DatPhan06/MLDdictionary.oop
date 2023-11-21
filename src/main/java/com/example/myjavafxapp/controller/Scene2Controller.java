package com.example.myjavafxapp.controller;

import com.example.myjavafxapp.model.DictionaryCommandLine;
import com.example.myjavafxapp.model.Word;
import com.example.myjavafxapp.util.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Scene2Controller {
    @FXML
    private TextField searchField;

    @FXML
    private TextArea resultTextArea;

    @FXML
    private Button searchButton;


    @FXML
    private Stage primaryStage;

    private final DictionaryCommandLine dictionaryCommandLine;

    public Scene2Controller() {
        dictionaryCommandLine = new DictionaryCommandLine();
        dictionaryCommandLine.dictionaryManagement.insertFromFile("src/main/resources/txt/dictionaryEV.txt");
    }

    // Phương thức để thiết lập primaryStage từ bên ngoài
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void searchButtonAction() {
        // Logic khi nút search được nhấn
        String searchTerm = searchField.getText();
        String result = performSearch(searchTerm);
        resultTextArea.setText(result);
    }

    //
    private String performSearch(String searchTerm) {
        // Logic tìm kiếm từ

        // Lấy quản lý từ điển từ lớp DictionaryCommandLine
        DictionaryManagement dictionaryManagement = DictionaryCommandLine.getDictionaryManagement();

        // Thực hiện tìm kiếm các từ khớp với searchTerm
        ArrayList<Word> matchingWords = dictionaryManagement.searchWords(searchTerm.trim());

        // Tạo một StringBuilder để xây dựng kết quả tìm kiếm
        StringBuilder result = new StringBuilder();

        // Kiểm tra xem có từ nào khớp không
        if (!matchingWords.isEmpty()) {
            // Lặp qua danh sách các từ khớp và thêm thông tin vào StringBuilder
            for (Word word : matchingWords) {
                result.append("English: ").append(word.getWordTarget()).append(" | Vietnamese: ").append(word.getWordExplain()).append("\n");
            }
            // Trả về kết quả tìm kiếm
            return result.toString();
        } else {
            // Trả về thông báo khi từ không được tìm thấy trong từ điển
            return "Word not found in the dictionary.";
        }
    }



    public void switchToScene1(ActionEvent event) throws Exception {
        loadScene("Scene1.fxml");
    }

    public void switchToScene3(ActionEvent event) throws Exception {
        loadScene("Scene3.fxml");
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
