package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.OrderedAthlete;

/**
 * Interface for saving statistics of the Decathlon competition to some destination.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 20:52:19
 */
public interface AthleteSaver {
    static final String ERROR_SAVING_MESSAGE = "Error occurred while saving athletes: ";

    /**
     * Saves an array of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes} to destination
     * @param athlets   an array of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes}
     *                  to save to destination
     */
    void save(OrderedAthlete... athlets);
}
