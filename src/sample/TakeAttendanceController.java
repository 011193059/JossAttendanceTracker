package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class TakeAttendanceController {

    @FXML
    private Button go_back;
    @FXML
    void onGoback(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);

    }

}
