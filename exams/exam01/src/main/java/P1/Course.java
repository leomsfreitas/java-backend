package P1;

import java.time.LocalTime;
import java.time.DayOfWeek;

public class Course {
    private static int nextId = 1;
    private final int id;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String name;
    private final String code;
    private final String professor;
    private final DayOfWeek dayOfWeek;
    private final Room room;

    public Course(LocalTime startTime, LocalTime endTime, String name, String code, String professor, DayOfWeek dayOfWeek, Room room) {
        this.id = nextId++;
        this.startTime = isValidTime(startTime, endTime) ? startTime : LocalTime.of(1, 0);
        this.endTime = isValidTime(startTime, endTime) ? endTime : LocalTime.of(1, 0);
        this.name = name;
        this.code = code;
        this.professor = professor;
        this.dayOfWeek = dayOfWeek;
        this.room = room;
    }

    public int getWeeklyDurationMinutes() {
        return (endTime.getHour() - startTime.getHour()) * 60 + (endTime.getMinute() - startTime.getMinute());
    }

    public String getStateAsString() {
        return String.format("| id = %d | %s (%s) | %s | Start = %s | End = %s | %s | Room = %s", id, name, code, dayOfWeek, startTime, endTime, professor, room);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    private boolean isValidTime(LocalTime startTime, LocalTime endTime) {
        return startTime.isBefore(endTime) || startTime.equals(endTime);
    }
}