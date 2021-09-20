package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewStudentController {

    @FXML private TextField student_name;

    @FXML
    private TextField contact_number;

    @FXML
    private TextField department;

    @FXML
    private TextField student_id;

    @FXML
    private Button save_student;

    @FXML
    void onSaveStudent(ActionEvent actionEvent) throws IOException {
        String sName = student_name.getText();
        String cNum = contact_number.getText();
        String departmentText = department.getText();
        String studentIdText = student_id.getText();
        DbConnection db = new DbConnection();
        db.addStudent(sName, cNum, departmentText, studentIdText);
        Object root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    void onCancel(ActionEvent actionEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @FXML
    public void hiiiii(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("HIIII");
    }
}
