package net.azib.java.students.t104971.homework.athletics.io;

import net.azib.java.students.t104971.homework.athletics.dto.Athlete;

import java.util.Collection;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public interface DataCollector {

    Collection<Athlete> getAllAthletes();
    Collection<Athlete> loadCompetitionResults(String competition);
}
