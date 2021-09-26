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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminCourseController implements Initializable {


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DbConnection DbConnection = new DbConnection();
            ObservableList<Course> courses = DbConnection.getCourses();
            name.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
            section.setCellValueFactory(new PropertyValueFactory<Course, String>("section"));
            department.setCellValueFactory(new PropertyValueFactory<Course, String>("department"));
            subject.setCellValueFactory(new PropertyValueFactory<Course, String>("subject"));


            course_table.setItems(courses);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
