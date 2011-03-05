package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;

import java.util.Collection;

/**
 * @author Jaroslav Judin
 */
public interface DataCollector {

    Collection<Athlete> loadCompetitionResults(String competition);
}
