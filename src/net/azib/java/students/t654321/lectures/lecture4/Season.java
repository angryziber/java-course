package net.azib.java.students.t654321.lectures.lecture4;

import net.azib.java.lessons.basic.Todo;

public enum Season {

    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    @Todo("Implement me")
    public Season next() {
        Season[] values = values();
        return values()[(ordinal() + 1) % values().length];
    }
}
