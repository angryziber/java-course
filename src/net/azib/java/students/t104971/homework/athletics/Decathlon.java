package net.azib.java.students.t104971.homework.athletics;

import net.azib.java.students.t104971.homework.athletics.arithmetics.Calculator;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.io.input.DataCollectorBuilder;
import net.azib.java.students.t104971.homework.athletics.io.output.CSVWriter;
import net.azib.java.students.t104971.homework.athletics.util.BrowserLaunch;
import net.azib.java.students.t104971.homework.athletics.io.input.DataCollector;
import net.azib.java.students.t104971.homework.athletics.io.xml.XMLBuilder;
import net.azib.java.students.t104971.homework.athletics.util.InputParametersValidator;
import net.azib.java.students.t104971.homework.athletics.util.UserInputException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * @author Jaroslav Judin
 */
public class Decathlon {

    private static Logger logger = Logger.getLogger(Decathlon.class);
    private List<Athlete> athletes;


    public static void main(String[] args) throws SQLException, ParseException {
        initLogger();

        InputParametersValidator validator = new InputParametersValidator();
        try {
            validator.validate(args);
        } catch (UserInputException e) {
            logger.error(e);
            return;
        }

        Decathlon decathlon = new Decathlon()
                .getInputData(validator.inputMethod)
                .calculate()
                .sort();
        decathlon.outputData(validator.outputMethod);

    }

    private void outputData(String method) {
        if ("-console".equals(method)) {
            printAthletes();
        } else if ("-xml".equals(method)) {
            BrowserLaunch.openURL(buildXML());
        } else if ("-html".equals(method)) {
            BrowserLaunch.openURL(buildHTML());
        } else if ("-csv".equals(method)) {
            new CSVWriter(athletes).write();
        }
    }

    public Decathlon printAthletes() {
        for (Athlete athlete : athletes) {
            logger.info(athlete);
        }
        return this;
    }

    private static void initLogger() {
        PropertyConfigurator.configure(PropertiesLoader.getLog4jPath());
    }

    Decathlon getInputData(String method) {
        DataCollector collector = DataCollectorBuilder.getCollector(method);
        athletes = (List<Athlete>) collector.loadCompetitionResults("2");
        return this;
    }

    Decathlon calculate() {
        new Calculator(athletes).calculate();
        return this;
    }

    Decathlon sort() {
        Collections.sort(athletes);
        return this;
    }

    public String buildXML() {
        return new XMLBuilder(athletes).getResult(false);
    }

    public String buildHTML() {
        return new XMLBuilder(athletes).getResult(true);
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }
}
