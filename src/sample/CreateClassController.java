package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateClassController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private Button submit_btn;

    @FXML
    private ChoiceBox<String> department;

    private String[] departments = {"CSE", "EEE", "BBA"};

    @FXML
    void onSubmit(ActionEvent event) throws IOException {
//        String sDepartment = department.getValue();
        String sName = name.getText();

//        System.out.println(sDepartment);
        System.out.println(sName);

        Object root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        Main.primaryStage.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        department.getItems().setAll(departments);
    }
}
