package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class AdminCourseController {


    @FXML
    private TableView<Course> course_table;

    @FXML
    private TableColumn<Course, String> name;

    @FXML
    private TableColumn<Course, String> section;

    @FXML
    private TableColumn<Course, String> department;

    @FXML
    private TableColumn<Course, String> subject;

    @FXML
    private TableColumn<Course, Boolean> action;
    @FXML
    private Button go_back;

    @FXML
    private Button create_new_class;

    @FXML
    public void onCreateNewClass(ActionEvent actionEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/create-class.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

    @FXML
    void onGoback(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

}
