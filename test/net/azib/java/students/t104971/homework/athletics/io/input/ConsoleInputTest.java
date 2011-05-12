package net.azib.java.students.t104971.homework.athletics.io.input;

import org.junit.Test;

import java.io.BufferedReader;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Jaroslav Judin
 */
public class ConsoleInputTest {

    @Test
    public void testGetLine() throws Exception {
        ConsoleInput console = new ConsoleInput();
        BufferedReader reader = mock(BufferedReader.class);
        console.console = reader;

        when(reader.readLine()).thenReturn("").thenReturn("first time").thenReturn("second time");

        assertEquals("first time", console.getLine());
        assertEquals("second time", console.getLine());
    }
}
