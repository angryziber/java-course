package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.Athlete;

import java.util.List;

/**
 * Interface for loading athletes.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 14:06:07
 */
public interface AthleteLoader {
    static final String ERROR_LOADING_MESSAGE = "Error occurred while loading athletes: ";
    /**
     * Loads athletes from source
     */
    void load();

    /**
     * @return loaded athletes as generic {@link java.util.List}
     */
    List<Athlete> getAthletes();
}
