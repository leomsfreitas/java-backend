package P1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("SC3045366", "Leo Freitas", LocalDate.parse("2024-01-01"), 3);
        System.out.println("Student semester: " + student.getSemester());

        Student invalidStudent = new Student("INVALID_ID", "Invalid Student", LocalDate.parse("2024-01-01"), 1);
        System.out.println("Invalid student state: " + invalidStudent.getStateAsString());

        Enrollment enrollment = new Enrollment(LocalDateTime.now(), student);

        Course course1 = new Course(LocalTime.parse("08:00"), LocalTime.parse("11:30"), "Object-orientation", "POO", "Lucas Bueno", DayOfWeek.FRIDAY, Room.C106);
        Course course2 = new Course(LocalTime.parse("13:00"), LocalTime.parse("16:00"), "Data Structures", "DS", "Maria Silva", DayOfWeek.MONDAY, Room.C107);
        Course course3 = new Course(LocalTime.parse("08:00"), LocalTime.parse("11:30"), "Algorithms", "ALG", "João Souza", DayOfWeek.FRIDAY, Room.C104); // Mesmo horário de course1
        Course course4 = new Course(LocalTime.parse("14:00"), LocalTime.parse("17:00"), "Databases", "DB", "Ana Costa", DayOfWeek.THURSDAY, Room.C105);

        System.out.println("Enrolling in course 1: " + enrollment.enroll(course1));
        System.out.println("Enrolling in course 2: " + enrollment.enroll(course2));
        System.out.println("Enrolling in course 3 (same time as course 1): " + enrollment.enroll(course3));
        System.out.println("Enrolling in course 4: " + enrollment.enroll(course4));

        System.out.println(enrollment.getStateAsString());

        enrollment.remove(course2);
        System.out.println("After removing course 2:");
        System.out.println(enrollment.getStateAsString());

        System.out.println("Enrolling in course 4 again: " + enrollment.enroll(course4));

        enrollment.conclude();
        System.out.println("After concluding enrollment:");
        System.out.println(enrollment.getStateAsString());

        System.out.println("Enrolling in course 3 after conclusion: " + enrollment.enroll(course3));
    }
}