package net.azib.java.students.t104971.homework.athletics;

import net.azib.java.students.t104971.homework.athletics.arithmetics.Calculator;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.io.input.DataCollector;
import net.azib.java.students.t104971.homework.athletics.io.input.DataCollectorBuilder;
import net.azib.java.students.t104971.homework.athletics.io.output.OutputBuilder;
import net.azib.java.students.t104971.homework.athletics.io.output.OutputWriter;
import net.azib.java.students.t104971.homework.athletics.util.BrowserLaunch;
import net.azib.java.students.t104971.homework.athletics.util.InputParametersValidator;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class Decathlon {

    private List<Athlete> athletes;

    // TODO: write tests
    public static void main(String[] args) throws SQLException, ParseException {
        initLogger();

        InputParametersValidator validator = new InputParametersValidator();
        if (validator.isValid(args)) {
            new Decathlon()
                    .getInputData(validator.getInputMethod(), validator.getInputParameter())
                    .calculate()
                    .sort()
                    .outputData(validator.getOutputMethod(), validator.getOutputParameter());
        }
    }

    private Decathlon getInputData(String method, String parameter) {
        DataCollector collector = DataCollectorBuilder.getCollector(method);
        athletes = (List<Athlete>) collector.loadCompetitionResults(parameter);
        return this;
    }

    private Decathlon outputData(String method, String parameter) {

        OutputWriter writer = new OutputBuilder(athletes).getWriter(method);
        BrowserLaunch.openURL(writer.write(parameter));
        return this;
    }

    private Decathlon calculate() {
        new Calculator(athletes).calculate();
        return this;
    }

    private Decathlon sort() {
        Collections.sort(athletes);
        return this;
    }

    private static void initLogger() {
        PropertyConfigurator.configure(PropertiesLoader.getLog4jPath());
    }

}
