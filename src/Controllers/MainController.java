package Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Pane cse_2201;

    @FXML
    private Pane cse_2202;

    @FXML
    private Pane cse_2203;

    @FXML
    private TableView<Student> student_table;

    @FXML
    private TableColumn<Student, String> student_id;

    @FXML
    private TableColumn<Student, String> department_id;

    @FXML
    private TableColumn<Student, String> name_id;

    @FXML
    private TableColumn<Student, String> contact_id;

//    public MainController(TableView<Student> student_table) {
//        this.student_table = student_table;
//    }

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
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            DbConnection DbConnection = new DbConnection();
//
//            ObservableList<Student> studentss = DbConnection.getStudents();
//            student_id.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
//            name_id.setCellValueFactory(new PropertyValueFactory<Student, String>("subject"));
//            department_id.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));
//            contact_id.setCellValueFactory(new PropertyValueFactory<Student, String>("section"));
//            student_table.setItems(studentss);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    try {
//        DbConnection DbConnection = new DbConnection();
        ObservableList<Student> students = Main.DbConnection.getStudents();
//        student_id.setCellValueFactory(new PropertyValueFactory<Student, String>("student_id"));
//        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
////            present.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
////            department.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));
//        present.setCellFactory(tc -> new CheckBoxTableCell<>());
//        absent.setCellFactory(tc -> new CheckBoxTableCell<>());

//        student_table.setItems(students);
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}
