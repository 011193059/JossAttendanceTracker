package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class Main extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("AAAAAAAAAAAATTTTEEEENNNNN!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        try {
            DbConnection DbConnection = new DbConnection();
            DbConnection.createConnection();
            DbConnection.runSqlStatement();
            launch();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException("Cannot connect the database! :|");
        }
    }
}