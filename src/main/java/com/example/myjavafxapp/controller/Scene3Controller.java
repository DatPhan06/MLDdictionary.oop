package com.example.myjavafxapp.controller;

import com.example.myjavafxapp.speechAPI.SpeechAPI;
import com.example.myjavafxapp.translator.Translate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene3Controller extends DictionaryController{

    @FXML
    private ChoiceBox<String> yourChoiceBox;

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
        String result;
        String languageChoice = handleChoiceBoxAction();
        if (languageChoice == null) {
            languageChoice = "Vietnam vi";
        }
//        SpeechAPI speechAPI = new SpeechAPI();

        // Tìm vị trí của dấu cách cuối cùng
        int lastIndex = languageChoice.lastIndexOf(' ');
        String result1 = "vi";
        // Kiểm tra xem có dấu cách không
        if (lastIndex != -1) {
            // Lấy ra phần tử từ vị trí sau dấu cách cuối cùng đến hết chuỗi
            result1 = languageChoice.substring(lastIndex + 1);
        } else {
            // Nếu không có dấu cách, in ra chuỗi gốc
            System.out.println(languageChoice);
        }
        result = Translate.translate(result1, searchTerm);
//            speechAPI.speak(result1, result);

//        String result = performTranslate(searchTerm);

        resultTextArea.setText(result);
    }

    @FXML
    private void SpeechAction() throws IOException {

        String textresult = resultTextArea.getText();

        String languageChoice = handleChoiceBoxAction();
        if (languageChoice == null) {
            languageChoice = "Vietnam vi";
        }
        SpeechAPI speechAPI = new SpeechAPI();

        // Tìm vị trí của dấu cách cuối cùng
        String result1 = "vi";
        int lastIndex = languageChoice.lastIndexOf(' ');

        // Kiểm tra xem có dấu cách không
        if (lastIndex != -1) {
            // Lấy ra phần tử từ vị trí sau dấu cách cuối cùng đến hết chuỗi
            result1 = languageChoice.substring(lastIndex + 1);
            System.out.println(languageChoice);
        } else {
            // Nếu không có dấu cách, in ra chuỗi gốc
            System.out.println(languageChoice.substring(languageChoice.length()-2));
        }
        speechAPI.speak(result1, textresult);

//        String result = performTranslate(searchTerm);


    }

    @FXML
    private String handleChoiceBoxAction() {
        String selectedValue = yourChoiceBox.getValue();
        return selectedValue;

        // Now you can use the selectedValue as needed.
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