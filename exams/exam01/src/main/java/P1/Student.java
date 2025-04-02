package P1;

import java.time.LocalDate;

public class Student {
    private final String id;
    private final String name;
    private final LocalDate admissionDate;
    private final int semester;

    public Student(String id, String name, LocalDate admissionDate, int semester) {
        this.id = isValidId(id) ? id : "SC000000X";
        this.name = name;
        this.admissionDate = admissionDate;
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public String getStateAsString() {
        return String.format("%s | %s | Admission Date = %s", id, name, admissionDate);
    }

    private boolean isValidId(String id) {
        return id != null && id.matches("SC\\d{6}[\\dX]");
    }
}