package net.azib.java.students.t104971.homework.athletics;

import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import org.junit.Test;

import static net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader.getCSVFile;

/**
 * @author Jaroslav Judin
 */
public class DecathlonTest {


    @Test
    public void testMain() throws Exception {
        PropertiesLoader.setProperties();
        String[] params = new String[]{
                "-csv",
                getCSVFile().getAbsolutePath(),
                "-xml",
                getCSVFile().getAbsolutePath().replace(".csv", ".test.out.xml")
        };
        Decathlon.main(params);
    }
}
