package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.components.ResultType;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.util.InputParser;
import net.azib.java.students.t104971.homework.athletics.util.InputRead;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Jaroslav Judin
 */
public class CsvDataCollector implements DataCollector {

    public static final String CSV_FILE = PropertiesLoader.getCSVPath();
    public static final String VALUE_SEPARATOR = ",";


    public Collection<Athlete> loadCompetitionResults(String csvFile) {

        List<Athlete> athletes = new ArrayList<Athlete>();

        InputRead input = new InputRead();
        File inputFile = new File(csvFile);
        inputFile = inputFile.exists() ? inputFile : new File(CSV_FILE);
        ArrayList<String> contents = input.getContents(inputFile);

        for (String line : contents) {
            athletes.add(getAthlete(line));
        }

        return athletes;
    }

    public Athlete getAthlete(String line) {

        String[] values = Pattern.compile(VALUE_SEPARATOR).split(line);

        Athlete athlete = new Athlete();
        try {
            for (int i = 0; i < values.length; i++) {
                setAthleteAttribute(athlete, i, values[i]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return athlete;
    }

    void setAthleteAttribute(Athlete athlete, int index, String value) {
        switch (index) {
            case 0:
                athlete.setName(value);
                break;
            case 1:
                athlete.setDateBirth(InputParser.parseDate(value));
                break;
            case 2:
                athlete.setCountry(value);
                break;
            default:
                athlete.addResult(ResultType.getResultType(index - 3), InputParser.parseResult(value));
        }
    }

}
