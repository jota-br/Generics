package dev.lpa.util;

public interface QueryItem {

    boolean matchField(String fieldName, String value);
}
