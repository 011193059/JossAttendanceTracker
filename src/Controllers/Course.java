package Controllers;

public class Course {
    int id;
    String name;
    String subject;
    String department;
    String section;

    public Course(int id, String name, String subject, String department, String section){
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.department = department;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getDepartment() {
        return department;
    }

    public String getSection() {
        return section;
    }

}