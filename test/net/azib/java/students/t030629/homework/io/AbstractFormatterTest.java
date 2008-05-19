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
public abstract class AbstractFormatterTest {
    @Test
    abstract void correctNameFormatting();

    @Test
    abstract void correctBirthdayFormatting();

    @Test
    abstract void correctCountryFormatting();

    @Test
    abstract void correctResultFormatting() throws ParseException, IOException, AthleteBuilder.IncompleteAthleteException, AthleteBuilder.UnsupportedCountryException;

    @Test
    abstract void correctResultsFormatting() throws AthleteBuilder.UnsupportedCountryException, IOException, AthleteBuilder.IncompleteAthleteException, ParseException;

    @Test
    abstract void correctPlaceFormatting();

    @Test
    abstract void correctAthleteFormatting() throws AthleteBuilder.UnsupportedCountryException, IOException, AthleteBuilder.IncompleteAthleteException, ParseException;
}
