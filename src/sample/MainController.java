package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class MainController {

    @FXML
    private Button create_class_btn;
    @FXML
    private Pane cse_2201;

    @FXML
    void onCreateClass(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("create-course.fxml"));
        Scene scene = new Scene((Parent) root, 600, 480);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    public void onCourseOpen(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
//        Object root = FXMLLoader.load(getClass().getResource("course.fxml"));
//        Scene scene = new Scene((Parent) root, 900, 600);
//        Main.primaryStage.setScene(scene);
    }
    @FXML
    public void onCse(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene( root, 900, 600);
        Main.primaryStage.setScene(scene);
    }
}
