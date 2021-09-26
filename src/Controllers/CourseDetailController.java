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


public class CourseDetailController implements  Initializable{
    public static int courseId;

    @FXML
    private TableView<Schedule> course_detail_table;

    @FXML
    private TableColumn<Schedule, String> date;
    @FXML
    private TableColumn<Schedule, Integer> totalPresent;
    @FXML
    private TableColumn<Schedule, Integer> totalAbsent;

    @FXML
    private TableColumn<Schedule, Boolean> action;

    @FXML
    void onGoback(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void onNewSchedule(ActionEvent event) throws IOException {
        ScheduleController.courseId = courseId;
        Object root = FXMLLoader.load(getClass().getResource("../UI/new-schedule.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void onTakeAttendance(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/take-attendance.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DbConnection DbConnection = new DbConnection();
            ObservableList<Schedule> schedules = DbConnection.getCourseSchedule(courseId);

            if(schedules.get(0).date != null) {
                System.out.println(schedules.get(0).date);

                date.setCellValueFactory(new PropertyValueFactory<Schedule, String>("date"));
                course_detail_table.setItems(schedules);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
