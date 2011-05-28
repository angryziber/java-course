package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.components.ResultType;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.util.InputParser;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class CommonOutputTestCase {

    @Before
    public void setUp() throws Exception {
        PropertiesLoader.setProperties();
    }

    protected String readCreatedFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.deleteOnExit();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append(System.getProperty("line.separator"));
        }
        return content.toString();
    }

    public List<Athlete> getTestAthletes() {
        List<Athlete> athletes = new ArrayList<Athlete>();

        Athlete athlete = new Athlete();
        athlete.setName("Jaak Tepandi");
        athlete.setCountry("EE");
        athlete.setDateBirth(InputParser.parseDate("01.01.1976"));
        for (ResultType type : ResultType.values()) {
           athlete.addResult(type, 5d);
        }
        athletes.add(athlete);
        return athletes;
    }
}
