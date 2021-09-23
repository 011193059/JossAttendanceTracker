package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminNewTeacher {

    @FXML
    private Button save_teacher;

    @FXML
    private TextField teacher_name;

    @FXML
    private TextField teacher_contact_number;

    @FXML
    private TextField teacher_department;

    @FXML
    private TextField teacher_id;
    public void onSaveTeacher(ActionEvent actionEvent) throws IOException {
        String tName = teacher_name.getText();
        String tNum = teacher_contact_number.getText();
        String teacherDepartmentText = teacher_department.getText();
        String teacherIdText = teacher_id.getText();
        DbConnection db = new DbConnection();
        db.addStudent(tName, tNum, teacherDepartmentText, teacherIdText);
        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

    public void onCancelTeacher(ActionEvent actionEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-home.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }
}
