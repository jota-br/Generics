package dev.lpa.model;

import dev.lpa.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {

    private static int CURRENT_ID = 0;
    private final int id;
    private String name;
    private String course;
    private double completedPercent;

    public static Random random = new Random();
    public static String[] names = new String[]{"John", "Jane", "Jolly", "Jennifer", "Jonas", "James", "Jaime", "Joseph"};
    public static String[] courses = new String[]{ "C", "C++", "Java"};

    public Student() {
        this.id = CURRENT_ID++;
        this.name = (char) random.nextInt(65, 91) + " " + names[random.nextInt(0,8)];
        this.course = courses[random.nextInt(0, 3)];
        this.completedPercent = random.nextDouble(0, 100.01);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getCompletedPercent() {
        return completedPercent;
    }

    @Override
    public boolean matchField(String fieldName, String value) {
        String fieldNameToUpper = fieldName.toUpperCase();
        return switch (fieldNameToUpper) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "PERCENT_COMPLETED" -> completedPercent >= Integer.parseInt(value);
            default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "%-2d %-15s %-10s %8.1f%n".formatted(id, name, course, completedPercent);
    }
}
