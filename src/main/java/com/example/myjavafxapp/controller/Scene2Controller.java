package com.example.myjavafxapp.controller;

import com.example.myjavafxapp.model.Word;
import com.example.myjavafxapp.sqlite.DatabaseManager;
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

public class Scene2Controller extends DictionaryController{

    @FXML
    private TextField searchField;

    @FXML
    private TextField wordSoundArea;
    @FXML
    private TextField wordTargetArea;

    @FXML
    private TextArea wordExplainArea;

    @FXML
    private TextArea resultArea;

    @FXML
    private Button searchButton;


    @FXML
    private Stage primaryStage;


    // Phương thức để thiết lập primaryStage từ bên ngoài
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void searchButtonAction() {
        // Logic khi nút search được nhấn
        String searchTerm = searchField.getText();
        try {
            Word result = performSearch(searchTerm);
            String result1 = DatabaseManager.searchWord(searchTerm);


            if (result == null) {
                wordTargetArea.setText("");
                wordSoundArea.setText("");
                wordExplainArea.setText("Can't search word.");
            } else {
                wordTargetArea.setText(result.getWordTarget());
                wordSoundArea.setText(result.getWordSound());
                wordExplainArea.setText(result.getWordExplain());
            }
            if (result1 == null) {
                resultArea.setText("Can't search word.");
            } else {
                resultArea.setText(result1);
            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    //
    private Word performSearch(String searchTerm) {
        // Logic tìm kiếm từ


        // Thực hiện tìm kiếm các từ khớp với searchTerm
        Word result = DictionaryManagement.dictionaryLookup(searchTerm.trim());


        // Kiểm tra xem có từ nào khớp không
        if (result != null) {

            // Trả về kết quả tìm kiếm
            return result;
        } else {
            // Trả về thông báo khi từ không được tìm thấy trong từ điển
            return null;
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