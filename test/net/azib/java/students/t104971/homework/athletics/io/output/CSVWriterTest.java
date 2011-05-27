package net.azib.java.students.t104971.homework.athletics.io.output;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class CSVWriterTest extends CommonOutputTestCase {
    @Test
    public void testWrite() throws Exception {
        CSVWriter csvWriter = new CSVWriter(getTestAthletes());

        String content = readCreatedFile(csvWriter.write("tmpCsvFile.csv"));

        assertEquals("1,0,Jaak Tepandi,01.01.1976,EE,5.0,5.0,5.0,5.0,5.0,5.0,5.0,5.0,5.0,5.0\n", content);
    }

}
