package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.time.LocalDate;

public class ScheduleController {
    public static int courseId;

    @FXML
    private DatePicker date;

    @FXML
    void onSubmit(ActionEvent event) throws IOException {
        String sDate = date.getValue().toString();
        System.out.println(sDate);
        System.out.println(courseId);
        DbConnection dbConnection = new DbConnection();
        dbConnection.addSchedule(courseId, sDate);
        Object root = FXMLLoader.load(getClass().getResource("../UI/course_detail.fxml"));
    }
}
