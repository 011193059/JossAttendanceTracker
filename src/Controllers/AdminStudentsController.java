package Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminStudentsController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DbConnection DbConnection = new DbConnection();
            ObservableList<Student> students = DbConnection.getStudents();
            student_id.setCellValueFactory(new PropertyValueFactory<Student, String>("student_id"));
            name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
            number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
            department.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));

            students_table.setItems(students);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

