package Controllers;

        import Networking.Server;
        import javafx.application.Application;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.CheckBoxTableCell;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.net.URL;
        import java.sql.SQLException;
        import java.util.ResourceBundle;

public class AdminHome extends Application {


    @FXML
    private Pane cse_22011;

    @FXML
    private Pane cse_22022;

    @FXML
    private Pane cse_22033;

    @FXML
    private Button new_student;

    @FXML
    private Button new_teacher;

    @FXML
    private static TableView<Course> course_table;

    @FXML
    private static TableColumn<Course, String> course_code_id;

    @FXML
    private static TableColumn<Course, String> department_id;

    @FXML
    private static TableColumn<Course, String> subject_id;

    @FXML
    private static TableColumn<Course, String> section_id;

    @FXML
    void onCourses(ActionEvent event) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-course.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

    @FXML
    void onStudents(ActionEvent event) throws IOException {
        System.out.println("Hererererer");
        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-students.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }



    @FXML
    public void onNewTeacher(ActionEvent actionEvent) throws IOException {
        Object root = FXMLLoader.load(getClass().getResource("../UI/admin-new-teacher.fxml"));
        Scene scene = new Scene((Parent) root, 900, 600);
        AdminHome.primaryStage.setScene(scene);
    }

        public static Stage primaryStage;

        @Override
        public void start(Stage stage) throws IOException {
            primaryStage = stage;
            FXMLLoader fxmlLoader = new FXMLLoader(AdminHome.class.getResource("../UI/admin-home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 600);
            stage.setTitle("JoAtter Admin!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            try {
                DbConnection DbConnection = new DbConnection();
                DbConnection.createConnection();

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Server.main(args);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t1.start();
                launch();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new IllegalStateException("Cannot connect the database! :|");
            }

        }
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            DbConnection DbConnection = new DbConnection();
//
//            ObservableList<Course> courses = DbConnection.getCourses();
////                course_code_id.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
////                subject_id.setCellValueFactory(new PropertyValueFactory<Course, String>("subject"));
////                department_id.setCellValueFactory(new PropertyValueFactory<Course, String>("department"));
////                section_id.setCellValueFactory(new PropertyValueFactory<Course, String>("section"));
//            course_table.setItems(courses);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
    }
