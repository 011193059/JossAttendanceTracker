package Controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CourseDetailController {
    @FXML
    private TableView<Course> course_detail_table;

    @FXML
    private TableColumn<Course, String> date;
    @FXML
    private TableColumn<Course, Integer> totalPresent;
    @FXML
    private TableColumn<Course, Integer> totalAbsent;

    @FXML
    private TableColumn<Course, Boolean> action;

    @FXML
    void onGoback(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);

    }

    @FXML
    void onTakeAttendance(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/take-attendance.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }
}
