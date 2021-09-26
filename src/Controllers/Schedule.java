package Controllers;

public class Schedule {
    int id;
    int course_id;
    String date;

    public Schedule(int id, int course_id, String date) {
        this.id = id;
        this.course_id = course_id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getDate() {
        return date;
    }
}