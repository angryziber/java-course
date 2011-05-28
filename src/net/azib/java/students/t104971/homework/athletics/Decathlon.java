package net.azib.java.students.t104971.homework.athletics;

import net.azib.java.students.t104971.homework.athletics.arithmetics.Calculator;
import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.io.OutputType;
import net.azib.java.students.t104971.homework.athletics.io.SourceType;
import net.azib.java.students.t104971.homework.athletics.io.input.DataCollector;
import net.azib.java.students.t104971.homework.athletics.io.output.OutputWriter;
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

    public static void main(String[] args) throws SQLException, ParseException {
        initLogger();

        InputParametersValidator validator = new InputParametersValidator();
        if (validator.isValid(args)) {
            new Decathlon()
                    .getInputData(validator.getSource(), validator.getSourceValue())
                    .calculate()
                    .sort()
                    .outputData(validator.getResult(), validator.getResultValue());
        }
    }

    private Decathlon getInputData(SourceType source, String sourceValue) {
        DataCollector collector = source.getCollector();
        athletes = collector.loadCompetitionResults(sourceValue);
        return this;
    }

    private Decathlon outputData(OutputType output, String resultValue) {
        OutputWriter writer = output.getWriter(athletes);
        writer.write(resultValue);
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

    public static void initLogger() {
        PropertiesLoader.setProperties();
        PropertyConfigurator.configure(System.getProperties());
    }

}
