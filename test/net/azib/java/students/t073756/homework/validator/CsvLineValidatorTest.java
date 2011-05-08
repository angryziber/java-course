package net.azib.java.students.t073756.homework.validator;

import net.azib.java.students.t073756.homework.DecathlonException;
import net.azib.java.students.t073756.homework.TestHelper;
import net.azib.java.students.t073756.homework.io.CsvProcessor;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class CsvLineValidatorTest {

    String supportsEncoding = "\"José Mañana Perez\",3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75 ";
    String bracketsAndQuotesAreOK = "\"Пупкин (Василий)\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01";
    String wrongLength = "21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01";
    String wrongBirthday = "\"José Mañana Perez\",3.4.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75 ";
    String wrongCountry = "\"José Mañana Perez\",3.04.1972,EST,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75 ";
    String wrongName = "123 876,3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75";

    @Test
    public void testCsvValidator() throws Exception {
        assertTrue(validate(new CsvProcessor.CsvLine(TestHelper.legalCsvLine)));
        assertTrue(validate(new CsvProcessor.CsvLine(supportsEncoding)));
        assertTrue(validate(new CsvProcessor.CsvLine(bracketsAndQuotesAreOK)));
        assertThrowsException(new CsvProcessor.CsvLine(wrongLength), "Wrong csv line length");
        assertThrowsException(new CsvProcessor.CsvLine(wrongBirthday), "Wrong value");
        assertThrowsException(new CsvProcessor.CsvLine(wrongCountry), "Wrong value");
        assertThrowsException(new CsvProcessor.CsvLine(wrongName), "Wrong value");
    }

    private void assertThrowsException(CsvProcessor.CsvLine input, String exceptionSubstring) {
        try {
            validate(input);
            fail("Exception expected");
        } catch (DecathlonException e) {
            assertTrue(e.getMessage().contains(exceptionSubstring));
        }
    }

    private boolean validate(CsvProcessor.CsvLine input) {
        return new CsvLineValidator().validate(input);
    }
}
