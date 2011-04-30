package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;

import java.util.List;

public interface OutputProvider {
    /**
     * Performs action to write decathlon competition data to specific output
     *
     * @param athletes - list of athletes which will be written to output
     */
    void writeAthletes(List<Athlete> athletes);
}
