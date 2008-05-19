package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.base.Results;
import net.azib.java.students.t030629.homework.base.Result;
import net.azib.java.students.t030629.homework.base.Place;

import java.util.Date;
import java.util.Locale;

/**
 * Interface for formatted output of an array of
 * {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes}.
 * <p>
 * Interface methods return the string representations of the specified parameters.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 14.05.2008
 * <br>Time: 12:47:13
 */
public interface OrderedAthleteFormatter {
        
    String format(OrderedAthlete... athletes);

    String formatName(String name);

    String formatBirthday(Date date);

    String formatCountry(Locale locale);

    String formatResults(Results results);

    String formatResult(Result result);

    String formatPlace(Place place);
}
