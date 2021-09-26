package Controllers;
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

    public String addClass(String code, String subject, String department, String section) {
        String result = "";
        try {
            Statement statement = createConnection().createStatement();
            String insertStudent = "INSERT INTO courses (name,subject,department,section) VALUES ('" + code + "', '" + subject + "', '" + department + "', '" + section + "');";
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

    public String addSchedule(int course_id, String date) {
        String result = "";
        try {
            Statement statement = createConnection().createStatement();
            String insertStudent = "INSERT INTO schedules (course_id,date) VALUES ('" + course_id + "', '" + date + "');";
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

    public ObservableList<Course>  getCourses() throws SQLException, IOException, ClassNotFoundException {
        ObservableList<Course> courses = FXCollections.observableArrayList();

        Statement statement = createConnection().createStatement();
        String insertStudent = "SELECT * FROM courses";
        ResultSet rs = statement.executeQuery(insertStudent);
        while (rs.next()) {
            courses.add(new Course(rs.getInt("id"), rs.getString("name"), rs.getString("subject"), rs.getString("department"), rs.getString("section")));
        }

        return courses;
    }

    public ObservableList<Schedule>  getCourseSchedule(int course_id) throws SQLException, IOException, ClassNotFoundException {
        ObservableList<Schedule> schedules = FXCollections.observableArrayList();

        Statement statement = createConnection().createStatement();
        String getSc = "SELECT * FROM schedules where course_id = " + course_id;
        ResultSet rs = statement.executeQuery(getSc);
        while (rs.next()) {
            schedules.add(new Schedule(rs.getInt("id"), rs.getInt("course_id"), rs.getString("date")));
        }

        return schedules;
    }
}