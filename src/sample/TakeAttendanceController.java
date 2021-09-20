package sample;

import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TakeAttendanceController implements Initializable {
    @FXML
    private TableView<Student> attendance_table;

    @FXML
    private TableColumn<Student, String> student_id;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, Boolean> present;

    @FXML
    private TableColumn<Student, Boolean> absent;

    @FXML
    void onGoback(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DbConnection DbConnection = new DbConnection();
            ObservableList<Student> students = DbConnection.getStudents();
            student_id.setCellValueFactory(new PropertyValueFactory<Student, String>("student_id"));
            name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
//            present.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
//            department.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));
            present.setCellFactory(tc -> new CheckBoxTableCell<>());
            absent.setCellFactory(tc -> new CheckBoxTableCell<>());

            attendance_table.setItems(students);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
