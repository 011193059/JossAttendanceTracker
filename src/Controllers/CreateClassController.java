package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateClassController {

    @FXML
    private TextField course_name;

    @FXML
    private Button cancel_btn;

    @FXML
    void onCancel(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void onSave(ActionEvent event) throws IOException {
        String cName = course_name.getText();
        System.out.println(cName);

//        Object root = FXMLLoader.load(getClass().getResource("home.fxml"));
//        Scene scene = new Scene((Parent) root, 900, 600);
//        Main.primaryStage.setScene(scene);
    }

}
