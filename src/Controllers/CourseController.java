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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CourseController implements Initializable {
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
    void onAssignStudent(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/assign-student.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void onGoback(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);

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


            course_table.setRowFactory(tv -> {
                TableRow<Course> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY && event.getClickCount() == 2) {
                        Course clickedRow = row.getItem();
                        CourseDetailController.courseId = clickedRow.getId();
                        Object root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("../UI/course-detail.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene scene = new Scene((Parent) root, 900, 600);
                        Main.primaryStage.setScene(scene);
                    }
                });
                return row ;
            });

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
