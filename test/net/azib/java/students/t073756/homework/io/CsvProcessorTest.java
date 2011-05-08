package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.DecathlonEvent;
import net.azib.java.students.t073756.homework.DecathlonException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.*;

public class CsvProcessorTest {

    @Test
    public void testReadAthletes() throws Exception {
        File testFile = createTestFile("\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01");
        List<Athlete> athletes = new CsvProcessor(testFile).readAthletes();

        assertEquals(1, athletes.size());

        Athlete a = athletes.get(0);

        assertEquals("\"Василий Пупкин\"", a.getName());
        assertEquals("UA", a.getCountry());
        assertEquals("6:51.01", a.getResult().getResults().get(DecathlonEvent.M_1500));
    }

    @Test
    public void shouldThrowExceptionIfInvalidLine() throws Exception {
        File testFile = createTestFile("\"Василий Пупкин\",UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01");
        try {
            new CsvProcessor(testFile).readAthletes();
            fail("Exception expected");
        } catch (DecathlonException e) {
            assertTrue(e.getMessage().startsWith("Wrong csv line length: "));
        }
    }

    private File createTestFile(String fileData) throws IOException {
        File csv = File.createTempFile("csv", null);
	    csv.deleteOnExit();
        FileOutputStream output = new FileOutputStream(csv);
        IOUtils.write(fileData, output);
        output.close();
        return csv;
    }
}
