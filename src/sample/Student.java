package sample;

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
}