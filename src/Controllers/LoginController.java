package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class LoginController {
    @FXML
    void log_in_teacher(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/teacher.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);

    }
    @FXML
    void onLogn(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/take-attendance.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void onCourses(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void onStudents(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/students.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }
}
