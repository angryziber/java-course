package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.beans.Athlete;

import java.util.List;

public interface OutputProvider {
    void writeAthletes(List<Athlete> athletes);
}
