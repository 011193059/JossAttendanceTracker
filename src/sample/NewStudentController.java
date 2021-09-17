package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewStudentController implements Initializable {

    @FXML
    private TextField student_name;

    @FXML
    private TextField contact_number;

    @FXML
    private TextField department;

    @FXML
    private TextField student_id;

    @FXML
    private Button save_student;


    public void onSaveStudent(javafx.event.ActionEvent actionEvent) throws IOException {
        String sName = student_name.getText();
        String cNum = contact_number.getText();
        String departmentText = department.getText();
        String studentIdText = student_id.getText();

        System.out.println(sName);
        System.out.println(cNum);
        System.out.println(departmentText);
        System.out.println(studentIdText);

        Object root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
