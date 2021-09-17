package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class AssignStudentController {

    @FXML
    private Button save_assigned;


    public void onSaveAssigned(javafx.event.ActionEvent actionEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }
}

