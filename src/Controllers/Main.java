package Controllers;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public static Stage primaryStage;
    public static DbConnection DbConnection = new DbConnection();
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../UI/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("ATracker!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {

            DbConnection.createConnection();
            ObservableList<Student> students = DbConnection.getStudents();

            launch();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException("Cannot connect the database! :|");
        }
    }
}