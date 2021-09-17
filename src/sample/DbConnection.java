package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    public String date = new SimpleDateFormat("dd-MM-yyyy-HH-mm").format(new Date());

    public Connection createConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        System.out.println("JDBC Connector Test " + date);
        String host = "jdbc:postgresql://ec2-34-247-151-118.eu-west-1.compute.amazonaws.com:5432/d80m7e3hrbuv1s";
        String username = "fdomgisfxzhxjm";
        String password = "5550678451034b0536758e225e76b46a730785cce597812f5509eecb0186ee54";
        System.out.println("host: " + host + "\nusername: " + username + "\npassword: " + password);

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(host, username, password);
        System.out.println("CONNECTION: " + connection);
        return connection;
    }

    public String addStudent(String name, String number, String department, String student_id) {
        String result = "";
        try {
            Statement statement = createConnection().createStatement();
            String insertStudent = "INSERT INTO students (name,number,department,student_id) VALUES ('" + name + "', '" + number + "', '" + department + "', '" + student_id + "');";
            System.out.println("SQL query: " + insertStudent);
            statement.execute(insertStudent);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occurred: " + ex);
            result = ex.getMessage();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = ex.getMessage();
        }
        return result;
    }

    public ObservableList<Student>  getStudents() throws SQLException, IOException, ClassNotFoundException {
        ObservableList<Student> students = FXCollections.observableArrayList();

        Statement statement = createConnection().createStatement();
        String insertStudent = "SELECT * FROM students";
        ResultSet rs = statement.executeQuery(insertStudent);
        while (rs.next()) {
            students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("student_id"), rs.getString("department"), rs.getString(("number"))));
        }

        return students;
    }
}