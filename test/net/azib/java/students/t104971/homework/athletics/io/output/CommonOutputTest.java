package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jaroslav Judin
 */
public class CommonOutputTest {

    @Before
    public void setUp() throws Exception {
        PropertiesLoader.setProperties();
    }

    protected String readCreatedFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.deleteOnExit();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            content.append(line).append(System.getProperty("line.separator"));
        }
        return content.toString();
    }
}
