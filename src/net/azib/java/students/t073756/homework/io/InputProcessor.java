package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;

import java.util.List;

public interface InputProcessor {
    /**
     * Performs basic operations to read Athletes data from data source
     *
     * @return List of athletes retrieved from source
     */
    abstract List<Athlete> readAthletes();
}

