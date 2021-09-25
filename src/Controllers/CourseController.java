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
            action.setCellFactory(new Callback<TableColumn<Course, Boolean>, TableCell<Course, Boolean>>() {
                public TableCell<Course, Boolean> call(TableColumn<Course, Boolean> personBooleanTableColumn) {
                    return new TakeAttendanceBtn();
                }
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

    private class TakeAttendanceBtn extends TableCell<Course, Boolean> {
        final Button addButton       = new Button("Details");
        final StackPane paddedButton = new StackPane();
        final DoubleProperty buttonY = new SimpleDoubleProperty();

        TakeAttendanceBtn() {
            paddedButton.setPadding(new Insets(3));
            paddedButton.getChildren().add(addButton);
            addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    buttonY.set(mouseEvent.getScreenY());
                }
            });
            addButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
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
        }

        @Override protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(paddedButton);
            } else {
                setGraphic(null);
            }
        }
    }
}
