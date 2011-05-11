package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;

import java.util.List;

/**
 * @author Jaroslav Judin
 */
public interface DataCollector {

    List<Athlete> loadCompetitionResults(String competition);
}
