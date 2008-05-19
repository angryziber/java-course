package net.azib.java.students.t030629.homework.io;

import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import net.azib.java.students.t030629.homework.base.utils.AthleteBuilder;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 14.05.2008
 * <br>Time: 13:06:08
 */
public interface FormatterTestInterface {
    @Test
    void correctNameFormatting();

    @Test
    void correctBirthdayFormatting();

    @Test
    void correctCountryFormatting();

    @Test
    void correctResultFormatting() throws ParseException, IOException, AthleteBuilder.IncompleteAthleteException, AthleteBuilder.UnsupportedCountryException;

    @Test
    void correctResultsFormatting() throws AthleteBuilder.UnsupportedCountryException, IOException, AthleteBuilder.IncompleteAthleteException, ParseException;

    @Test
    void correctPlaceFormatting();

    @Test
    void correctAthleteFormatting() throws AthleteBuilder.UnsupportedCountryException, IOException, AthleteBuilder.IncompleteAthleteException, ParseException;
}
