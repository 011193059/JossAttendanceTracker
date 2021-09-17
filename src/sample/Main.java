package sample;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.stage.Stage;
        import javafx.scene.Parent;
        import java.io.IOException;


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
    public static void main(String[] args)  {
        launch();
    }

//    public static void main(String[] args) throws SQLException {
//        try {
//            String url = "jdbc:mysql://localhost:3306/at_managment";
//            String username = "root";
//            String password = "14101999";
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//            String connectQuery = "SELECT * FROM courses";
//
//            ResultSet queryOutput = statement.executeQuery(connectQuery);
//
//            while (queryOutput.next()) {
//                System.out.println(queryOutput.getString("name"));
//            }
////            launch();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new IllegalStateException("Cannot connect the database! :|");
//        }
//    }
}