package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.util.InputParser;
import net.azib.java.students.t104971.homework.athletics.util.InputRead;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static net.azib.java.students.t104971.homework.athletics.components.ResultType.*;

/**
 * @author Jaroslav Judin
 */
public class CsvDataCollector implements DataCollector {

    public static final String VALUE_SEPARATOR = ",";
    private static final Logger LOG = Logger.getLogger(CsvDataCollector.class);


    public List<Athlete> loadCompetitionResults(String csvFile) {

        List<Athlete> athletes = new ArrayList<Athlete>();
        List<String> contents = Collections.emptyList();
        File inputFile = new File(csvFile);
        try {
            contents = new InputRead().getContents(new FileInputStream(inputFile));
        } catch (FileNotFoundException e) {
            LOG.error("Cannot find CSV file", e);
        }

        for (String line : contents) {
            athletes.add(getAthlete(line));
        }

        return athletes;
    }

    public Athlete getAthlete(String line) {

        String[] values = Pattern.compile(VALUE_SEPARATOR).split(line);

        Athlete athlete = new Athlete();
        for (int i = 0; i < values.length; i++) {
            setAthleteAttribute(athlete, i, values[i]);
        }

        return athlete;
    }

    void setAthleteAttribute(Athlete athlete, int index, String value) {
        double result = index > 2 ? InputParser.parseResult(value) : 0;

        switch (index) {
            case 0:
                athlete.setName(value);
                return;
            case 1:
                athlete.setDateBirth(InputParser.parseDate(value));
                return;
            case 2:
                athlete.setCountry(value);
                return;
            case 3:
                athlete.addResult(RACE_100_METERS, result);
                return;
            case 4:
                athlete.addResult(LONG_JUMP, result);
                return;
            case 5:
                athlete.addResult(SHOT_PUT, result);
                return;
            case 6:
                athlete.addResult(HIGH_JUMP, result);
                return;
            case 7:
                athlete.addResult(RACE_400_METERS, result);
                return;
            case 8:
                athlete.addResult(RACE_110_METERS_HURDLES, result);
                return;
            case 9:
                athlete.addResult(DISCUS_THROW, result);
                return;
            case 10:
                athlete.addResult(POLE_VAULT, result);
                return;
            case 11:
                athlete.addResult(JAVELIN_THROW, result);
                return;
            case 12:
                athlete.addResult(RACE_1500_METERS, result);
        }
    }

}
