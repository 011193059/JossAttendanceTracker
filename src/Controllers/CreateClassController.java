package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateClassController {

    @FXML
    private TextField course_code;
    @FXML
    private TextField subject;

    @FXML
    private TextField department;

    @FXML
    private TextField section;

    @FXML
    private Button cancel_btn;

    @FXML
    void onCancel(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

    @FXML
    void onSave(ActionEvent event) throws IOException {
        String courseCodeText = course_code.getText();
        String subjectText = subject.getText();
        String departmentText = department.getText();
        String sectionText = section.getText();

        System.out.println(courseCodeText);
        System.out.println(subjectText);
        System.out.println(sectionText);
        System.out.println(departmentText);

        DbConnection db = new DbConnection();
        db.addClass(courseCodeText,subjectText, departmentText, sectionText);

        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

}
