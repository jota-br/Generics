package dev.lpa.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getCompletedPercent(), o2.getCompletedPercent());
    }
}
