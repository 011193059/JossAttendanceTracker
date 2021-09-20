package Controllers;

public class Student {
    int id;
    String name;
    String student_id;
    String department;
    String number;

    public Student(int id, String name, String student_id, String department, String number){
        this.id = id;
        this.name = name;
        this.student_id = student_id;
        this.department = department;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            DbConnection DbConnection = new DbConnection();
//            ObservableList<Student> students = DbConnection.getStudents();
//            student_id.setCellValueFactory(new PropertyValueFactory<Student, String>("student_id"));
//            name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
//            number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
//            department.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));
//
//            attendance_table.setItems(students);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}