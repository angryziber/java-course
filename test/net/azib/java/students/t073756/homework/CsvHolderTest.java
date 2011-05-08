package net.azib.java.students.t073756.homework;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class CsvHolderTest {
    @Test
    public void shouldConvertAthleteToCsvString() throws Exception {
        assertEquals(TestHelper.legalCsvLine, CsvHolder.convertToCsvLine(Arrays.asList(TestHelper.legalCsvLine.split(","))));
    }
}
