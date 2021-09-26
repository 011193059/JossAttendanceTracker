package Controllers;

import Networking.ClientReaderThread;
import Networking.ClientWriterThread;
import Networking.NetworkUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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


//
//
//
//        NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
//        new ClientReaderThread(nc);
//        new ClientWriterThread(nc,"Client");



        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-students.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

    @FXML
    void onCancel(ActionEvent actionEvent) throws IOException {
        Socket socket =new Socket("127.0.0.1",8888);

        OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
        BufferedWriter writer = new BufferedWriter(o);

        try {
            writer.write("A new student is added!");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.close();

        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-students.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

    @FXML
    public void hiiiii(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("HIIII");
    }
}
