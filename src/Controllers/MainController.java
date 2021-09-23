package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {

    @FXML
    private Pane cse_2201;

    @FXML
    private Pane cse_2202;

    @FXML
    private Pane cse_2203;



    @FXML
    public void onCse1(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }
    @FXML
    public void onCse2(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }
    @FXML
    public void onCse3(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }


}
