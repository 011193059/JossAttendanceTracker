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

public class AdminStudentsController {

    @FXML
    private TableView<Student> students_table;

    @FXML
    private TableColumn<Student, String> student_id;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> number;

    @FXML
    private TableColumn<Student, String> department;
    @FXML
    private Button go_back;

    @FXML
    private Button add_new_student;

    @FXML
    public void onAddNewStudent(ActionEvent actionEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/new-student.fxml"));
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

