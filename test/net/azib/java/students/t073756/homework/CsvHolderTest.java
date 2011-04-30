package net.azib.java.students.t073756.homework;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * User: anton
 * Date: 4/24/11
 * Time: 11:43 AM
 */
public class CsvHolderTest {
    String legalInput = "Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72";

    @Test
    public void shouldConvertAthleteToCsvString() throws Exception {
        assertEquals(legalInput, CsvHolder.convertToCsvLine(Arrays.asList(legalInput.split(","))));
    }
}
