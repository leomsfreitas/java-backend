package P1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Enrollment {
    private static int nextId = 1;
    private final int id;
    private final LocalDateTime enrollmentTime;
    private boolean concluded;
    private LocalDateTime concludedTime;
    private final Course[] courses = new Course[10];
    private int totalCourses;
    private final int MAX_WEEKLY = 22;
    private int totalWeeklyHours;
    private final Student student;

    public Enrollment(LocalDateTime enrollmentTime, Student student) {
        this.id = nextId++;
        this.enrollmentTime = enrollmentTime;
        this.concluded = false;
        this.totalCourses = 0;
        this.student = student != null && !student.getStateAsString().contains("SC000000X") ? student : null;
        this.totalWeeklyHours = 0;
        this.concludedTime = null;
        if (this.student == null) {
            conclude();
        }
    }

    public boolean enroll(Course course) {
        if (course == null || totalCourses >= 10 || concluded) return false;

        for (int i = 0; i < totalCourses; i++) {
            Course c = courses[i];
            if (c != null && (hasTimeConflict(c, course) || totalWeeklyHours + course.getWeeklyDurationMinutes() / 60 > MAX_WEEKLY)) {
                return false;
            }
        }

        courses[totalCourses++] = course;
        totalWeeklyHours += course.getWeeklyDurationMinutes() / 60;
        return true;
    }

    public void remove(Course course) {
        if (concluded || course == null) return;
        for (int i = 0; i < totalCourses; i++) {
            if (courses[i] != null && courses[i].equals(course)) {
                totalWeeklyHours -= course.getWeeklyDurationMinutes() / 60;
                courses[i] = null;
                totalCourses--;
                return;
            }
        }
    }

    public void conclude() {
        this.concluded = true;
        this.concludedTime = LocalDateTime.now();
    }

    public String getStateAsString() {
        if (student == null) {
            return "Invalid enrollment!";
        }
        if (!concluded) {
            return "Enrollment not concluded!";
        }
        StringBuilder string = new StringBuilder();
        string.append(String.format("""
                ==========================================================================
                %s
                Enrollment Time: %s
                -------------------------------------------------------------------------------------------------------------------------------
                Courses:
                """, student.getStateAsString(), enrollmentTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))));
        for (Course c : courses) {
            if (c != null) string.append(c.getStateAsString()).append("\n");
        }
        string.append("==========================================================================");
        return string.toString();
    }

    private boolean hasTimeConflict(Course c1, Course c2) {
        return !(c1.getStartTime().isAfter(c2.getEndTime()) || c2.getStartTime().isAfter(c1.getEndTime()));
    }
}