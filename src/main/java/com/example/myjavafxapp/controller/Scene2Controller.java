package com.example.myjavafxapp.controller;

import com.example.myjavafxapp.model.Word;
import com.example.myjavafxapp.sqlite.DatabaseManager;
import com.example.myjavafxapp.util.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class Scene2Controller extends DictionaryController implements Initializable {

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

    @FXML
    private Alert AddcustomAlert; // Reference to the defined Alert

    @FXML
    private Alert AddcustomAlert1; // Reference to the defined Alert

    @FXML
    private Alert ChangecustomAlert; // Reference to the defined Alert

    @FXML
    private Alert ChangecustomAlert1; // Reference to the defined Alert

    @FXML
    private Alert DeletecustomAlert; // Reference to the defined Alert

    @FXML
    private Alert DeletecustomAlert1; // Reference to the defined Alert

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Mặc định nội dung cho resultArea
        resultArea.setText("Word: \n" +
                "Type: \n" +
                "Meaning: \n" +
                "Pronunciation: \n" +
                "Example: \n" +
                "Synonym: \n" +
                "Antonyms: ");
    }

    @FXML
    private void ChangeshowAlert() {
        ChangecustomAlert.setTitle("Change Word");


        ChangecustomAlert.setHeaderText("Bạn có chắc chắn muốn sửa từ " + wordTargetArea.getText() + " trong từ điển Anh - Việt không?");
//        customAlert.setContentText("Hello, this is the content text!");
//        // Tạo một ImageView để hiển thị biểu tượng
//        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/graphic/icon/change.png"))));
//        imageView.setFitWidth(48); // Điều chỉnh kích thước của biểu tượng nếu cần
//        // Thiết lập biểu tượng cho Stage
//        Stage stage = (Stage) ChangecustomAlert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(imageView.getImage());

        // Customize the alert further if needed
        // Add a "Cancel" button
//        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonType.CANCEL.getButtonData());
//        customAlert.getButtonTypes().add(cancelButtonType);

        // Show the alert and wait for user interaction
        Optional<ButtonType> result = ChangecustomAlert.showAndWait();

        // Process the result
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("User clicked OK");
            if (Objects.equals(wordTargetArea.getText(), "")) {
                System.out.println("Please insert Word!");
//                System.out.println(wordTargetArea.getText());

            } else if (Objects.equals(wordSoundArea.getText(), "")) {
                System.out.println("Please insert Word Sound!");
            } else if (Objects.equals(wordExplainArea.getText(), "")) {
                System.out.println("Please insert Word Explain!");
            } else {
//                System.out.println(wordTargetArea.getText());
                changeNewWordToDictionary(wordTargetArea.getText(), wordSoundArea.getText(), wordExplainArea.getText());
            }
            // Do something when OK is clicked
        } else {
            System.out.println("User clicked Cancel or closed the dialog");
            // Do something when Cancel or closed
        }
    }

    @FXML
    private void ChangeshowAlert1() {
        ChangecustomAlert1.setTitle("Change Word");
//        // Tạo một ImageView để hiển thị biểu tượng
//        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/graphic/icon/change.png"))));
//        imageView.setFitWidth(48); // Điều chỉnh kích thước của biểu tượng nếu cần
//        // Thiết lập biểu tượng cho Stage
//        Stage stage = (Stage) ChangecustomAlert1.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(imageView.getImage());
        String[] lines = resultArea.getText().split("\n");
        String Word = "";
        String Type = "";
        String Meaning = "";
        String Pronunciation = "";
        String Example = "";
        String Synonym = "";
        String Antonyms = "";
        for (String line : lines) {
            String[] parts = line.split(":", 2);
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "Word":
                        Word = value;
                        break;
                    case "Type":
                        Type = value;
                        break;
                    case "Meaning":
                        Meaning = value;
                        break;
                    case "Pronunciation":
                        Pronunciation = value;
                        break;
                    case "Example":
                        Example = value;
                        break;
                    case "Synonym":
                        Synonym = value;
                        break;
                    case "Antonyms":
                        Antonyms = value;
                        break;
                    // Add more cases for other keys if needed
                }
            }
        }
        ChangecustomAlert1.setHeaderText("Bạn có chắc chắn muốn sửa từ " + Word + " trong cơ sở dữ liệu từ điển Anh - Anh không?");


        // Customize the alert further if needed
        // Add a "Cancel" button
//        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonType.CANCEL.getButtonData());
//        customAlert.getButtonTypes().add(cancelButtonType);

        // Show the alert and wait for user interaction
        Optional<ButtonType> result1 = ChangecustomAlert1.showAndWait();

        // Process the result
        if (result1.isPresent() && result1.get() == ButtonType.OK) {
            System.out.println("User clicked OK");
            if (Objects.equals(resultArea.getText(), "")) {
                System.out.println("Please insert Word!");
            } else {
//                System.out.println(wordTargetArea.getText());

                changeNewWordToDataBase(Word, Type, Meaning, Pronunciation, Example, Synonym, Antonyms);
//                addNewWordToDataBase("", "", "", "", "", "", "");

            }
            // Do something when OK is clicked
        } else {
            System.out.println("User clicked Cancel or closed the dialog");
            // Do something when Cancel or closed
        }
    }

    @FXML
    private void DeleteshowAlert() {
        DeletecustomAlert.setTitle("Delete Word");
        DeletecustomAlert.setHeaderText("Bạn có chắc chắn muốn xóa từ " + wordTargetArea.getText() + " trong từ điển Anh - Việt không?");
//        customAlert.setContentText("Hello, this is the content text!");
//        // Tạo một ImageView để hiển thị biểu tượng
//        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/graphic/icon/delete.png"))));
//        imageView.setFitWidth(48); // Điều chỉnh kích thước của biểu tượng nếu cần
//        // Thiết lập biểu tượng cho Stage
//        Stage stage = (Stage) DeletecustomAlert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(imageView.getImage());

        // Customize the alert further if needed
        // Add a "Cancel" button
//        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonType.CANCEL.getButtonData());
//        customAlert.getButtonTypes().add(cancelButtonType);

        // Show the alert and wait for user interaction
        Optional<ButtonType> result = DeletecustomAlert.showAndWait();

        // Process the result
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("User clicked OK");
            if (Objects.equals(wordTargetArea.getText(), "")) {
                System.out.println("Please insert Word!");
//                System.out.println(wordTargetArea.getText());
            } else {
//                System.out.println(wordTargetArea.getText());
                deleteNewWordFromDictionary(wordTargetArea.getText());
            }
            // Do something when OK is clicked
        } else {
            System.out.println("User clicked Cancel or closed the dialog");
            // Do something when Cancel or closed
        }
    }

    @FXML
    private void DeleteshowAlert1() {
        DeletecustomAlert1.setTitle("Delete Word");
        String[] lines = resultArea.getText().split("\n");
        String Word = "";
        String Type = "";
        String Meaning = "";
        String Pronunciation = "";
        String Example = "";
        String Synonym = "";
        String Antonyms = "";
        for (String line : lines) {
            String[] parts = line.split(":", 2);
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "Word":
                        Word = value;
                        break;
                    case "Type":
                        Type = value;
                        break;
                    case "Meaning":
                        Meaning = value;
                        break;
                    case "Pronunciation":
                        Pronunciation = value;
                        break;
                    case "Example":
                        Example = value;
                        break;
                    case "Synonym":
                        Synonym = value;
                        break;
                    case "Antonyms":
                        Antonyms = value;
                        break;
                    // Add more cases for other keys if needed
                }
            }
        }

        DeletecustomAlert1.setHeaderText("Bạn có chắc chắn xóa sửa từ " + Word + " trong cơ sở dữ liệu từ điển Anh - Anh không?");

//// Tạo một ImageView để hiển thị biểu tượng
//        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/graphic/icon/delete.png"))));
//        imageView.setFitWidth(48); // Điều chỉnh kích thước của biểu tượng nếu cần
//        // Thiết lập biểu tượng cho Stage
//        Stage stage = (Stage) DeletecustomAlert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(imageView.getImage());
        // Customize the alert further if needed
        // Add a "Cancel" button
//        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonType.CANCEL.getButtonData());
//        customAlert.getButtonTypes().add(cancelButtonType);

        // Show the alert and wait for user interaction
        Optional<ButtonType> result1 = DeletecustomAlert1.showAndWait();

        // Process the result
        if (result1.isPresent() && result1.get() == ButtonType.OK) {
            System.out.println("User clicked OK");
            if (Objects.equals(resultArea.getText(), "")) {
                System.out.println("Please insert Word!");
            } else {

                deleteNewWordToDataBase(Word);
                System.out.println("Word deleted");

//                addNewWordToDataBase("", "", "", "", "", "", "");

            }
            // Do something when OK is clicked
        } else {
            System.out.println("User clicked Cancel or closed the dialog");
            // Do something when Cancel or closed
        }
    }

    public void deleteNewWordFromDictionary(String wordTarget) {
        if (DictionaryManagement.removeWord(wordTarget.trim())) {
            System.out.println("Delete word successfully");
        } else {
            System.out.println("Can't delete word");
        }

    }

    public void deleteNewWordToDataBase(String Word) {
        try {
            DatabaseManager.deleteWord(Word);
            System.out.println("Delete word successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void changeNewWordToDictionary(String wordTarget, String wordSound, String wordExplain) {
        if (DictionaryManagement.updateWord(wordTarget, wordSound, wordExplain)) {
            System.out.println("Change word successfully");
        } else {
            System.out.println("Can't change word");
        }

    }

    public void changeNewWordToDataBase(String Word, String Type, String Meaning, String Pronunciation, String Example, String Synonym, String Antonyms) {
        try {
            DatabaseManager.updateWord(Word, Type, Meaning, Pronunciation, Example, Synonym, Antonyms);
            System.out.println("Change word successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    private void AddshowAlert() {
        AddcustomAlert.setTitle("Add Word");
        AddcustomAlert.setHeaderText("Bạn có chắc chắn muốn thêm từ " + wordTargetArea.getText() + " vào từ điển Anh - Việt không?");
//        customAlert.setContentText("Hello, this is the content text!");
//        // Tạo một ImageView để hiển thị biểu tượng
//        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/graphic/icon/add.png"))));
//        imageView.setFitWidth(48); // Điều chỉnh kích thước của biểu tượng nếu cần
//        // Thiết lập biểu tượng cho Stage
//        Stage stage = (Stage) AddcustomAlert.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(imageView.getImage());

        // Customize the alert further if needed
        // Add a "Cancel" button
//        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonType.CANCEL.getButtonData());
//        customAlert.getButtonTypes().add(cancelButtonType);

        // Show the alert and wait for user interaction
        Optional<ButtonType> result = AddcustomAlert.showAndWait();

        // Process the result
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("User clicked OK");
            if (Objects.equals(wordTargetArea.getText(), "")) {
                System.out.println("Please insert Word!");
//                System.out.println(wordTargetArea.getText());

            } else if (Objects.equals(wordSoundArea.getText(), "")) {
                System.out.println("Please insert Word Sound!");
            } else if (Objects.equals(wordExplainArea.getText(), "")) {
                System.out.println("Please insert Word Explain!");
            } else {
//                System.out.println(wordTargetArea.getText());
                addNewWordToDictionary(wordTargetArea.getText(), wordSoundArea.getText(), wordExplainArea.getText());
            }
            // Do something when OK is clicked
        } else {
            System.out.println("User clicked Cancel or closed the dialog");
            // Do something when Cancel or closed
        }
    }

    @FXML
    private void AddshowAlert1() {
        AddcustomAlert1.setTitle("Add Word");
//        // Tạo một ImageView để hiển thị biểu tượng
//        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/graphic/icon/add.png"))));
//        imageView.setFitWidth(48); // Điều chỉnh kích thước của biểu tượng nếu cần
//        // Thiết lập biểu tượng cho Stage
//        Stage stage = (Stage) AddcustomAlert1.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(imageView.getImage());
        String[] lines = resultArea.getText().split("\n");

        String Word = "";
        String Type = "";
        String Meaning = "";
        String Pronunciation = "";
        String Example = "";
        String Synonym = "";
        String Antonyms = "";
        for (String line : lines) {
            String[] parts = line.split(":", 2);
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "Word":
                        Word = value;
                        break;
                    case "Type":
                        Type = value;
                        break;
                    case "Meaning":
                        Meaning = value;
                        break;
                    case "Pronunciation":
                        Pronunciation = value;
                        break;
                    case "Example":
                        Example = value;
                        break;
                    case "Synonym":
                        Synonym = value;
                        break;
                    case "Antonyms":
                        Antonyms = value;
                        break;
                    // Add more cases for other keys if needed
                }
            }
        }

        AddcustomAlert1.setHeaderText("Bạn có chắc chắn muốn thêm từ " + Word + " vào cơ sở dữ liệu từ điển Anh - Anh không?");
        AddcustomAlert1.setContentText("Hãy chắc chắn bạn nhập theo đúng định dạng(mỗi chữ cái 1 dòng): \n " +
                "Word: " + Word + "\n" +
                "Type: " + Type + "\n" +
                "Meaning: " + Meaning + "\n" +
                "Pronunciation: " + Pronunciation + "\n" +
                "Example: " + Example + "\n" +
                "Synonym: " + Synonym + "\n" +
                "Antonyms: " + Antonyms);

        // Customize the alert further if needed
        // Add a "Cancel" button
//        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonType.CANCEL.getButtonData());
//        customAlert.getButtonTypes().add(cancelButtonType);

        // Show the alert and wait for user interaction
        Optional<ButtonType> result1 = AddcustomAlert1.showAndWait();

        // Process the result
        if (result1.isPresent() && result1.get() == ButtonType.OK) {
            System.out.println("User clicked OK");
            if (Objects.equals(resultArea.getText(), "")) {
                System.out.println("Please insert Word!");
            } else {
//                System.out.println(wordTargetArea.getText());

                addNewWordToDataBase(Word, Type, Meaning, Pronunciation, Example, Synonym, Antonyms);
//                addNewWordToDataBase("", "", "", "", "", "", "");

            }
            // Do something when OK is clicked
        } else {
            System.out.println("User clicked Cancel or closed the dialog");
            // Do something when Cancel or closed
        }
    }

    public void addNewWordToDictionary(String wordTarget, String wordSound, String wordExplain) {
        if (DictionaryManagement.addWord(wordTarget, wordSound, wordExplain)) {
            System.out.println("Add word successfully");
        } else {
            System.out.println("Can't add word because word has been added");
        }

    }

    public void addNewWordToDataBase(String Word, String Type, String Meaning, String Pronunciation, String Example, String Synonym, String Antonyms) {
        try {
            DatabaseManager.insertData(Word, Type, Meaning, Pronunciation, Example, Synonym, Antonyms);
            System.out.println("Add word successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

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
                wordTargetArea.setText("Can't search word.");
                wordSoundArea.setText("");
                wordExplainArea.setText("");
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