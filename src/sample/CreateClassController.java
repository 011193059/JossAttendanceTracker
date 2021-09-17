package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateClassController {

    @FXML
    private Button save_btn;

    @FXML
    private Button cancel_btn;

    @FXML
    void onCancel(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void onSave(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

}
