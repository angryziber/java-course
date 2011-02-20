package net.azib.java.students.t104971.homework.athletics;

import net.azib.java.students.t104971.homework.athletics.arithmetics.Calculator;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.io.DataCollectorBuilder;
import net.azib.java.students.t104971.homework.athletics.util.BrowserLaunch;
import net.azib.java.students.t104971.homework.athletics.io.DataCollector;
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

        BrowserLaunch.openURL(decathlon.buildXML());
        //decathlon.printAthletes();
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
        return new XMLBuilder(athletes).getXML();
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }
}
