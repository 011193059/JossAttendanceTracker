package Controllers;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;


public class Main extends Application {
    public static Stage primaryStage;
    public static DbConnection DbConnection = new DbConnection();
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../UI/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("JoAtter Teacher!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        try {
            DbConnection.createConnection();
            Socket socket =new Socket("127.0.0.1",8888);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);



            launch();
            String data;
            while ((data = reader.readLine()) != null) {
                try {
                    System.out.println(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException("Cannot connect the database! :|");
        }
    }
    }