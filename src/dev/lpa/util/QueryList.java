package dev.lpa.util;

import dev.lpa.model.Student;

import java.util.ArrayList;

public class QueryList <T extends Student & QueryItem> extends ArrayList<T> {

    public QueryList<T> getMatches(String fieldName, String value) {

        QueryList<T> matches = new QueryList<>();
        for (var item : this) {
            if (item.matchField(fieldName, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public void printList() {

        System.out.println("-".repeat(50));
        for (var item : this) {
            System.out.printf("%-5d %-15s %-10s %5.1f%n", item.getId(), item.getName(), item.getCourse(), item.getCompletedPercent());
        }
        System.out.println("-".repeat(50));
    }
}
