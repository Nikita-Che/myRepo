package com.urise.webapp.model;

import java.util.List;

public class ListSection extends AbstractSection { //ACHIEVEMENT, QUALIFICATIONS,
    private final List<String> strings;

    public ListSection(List<String> strings) {
        this.strings = strings;
    }

    public List<String> getStrings() {
        return strings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return strings.equals(that.strings);
    }

    @Override
    public int hashCode() {
        return strings.hashCode();
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "strings=" + strings +
                '}';
    }
}
