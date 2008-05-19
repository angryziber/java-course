package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import static org.easymock.classextension.EasyMock.*;
import static junit.framework.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 2:08:54
 */
public class ConsoleCommunicatorTest {

    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void testHasNewAthlete() throws IOException, NoSuchMethodException {
        int acceptChar = ConsoleCommunicator.ENTER_CHAR;
        int denyChar = 32; // some arbitrary char

        PrintStream mockOutputStream = createMock(PrintStream.class, PrintStream.class.getMethod("print", String.class));

        /* Test ACCEPT a new Athlete */
        InputStream mockInputStream = createMock(InputStream.class);
        expect(mockInputStream.read()).andReturn(acceptChar);
        replay(mockInputStream);

        ConsoleCommunicator communicator = new ConsoleCommunicator(mockInputStream, mockOutputStream);
        assertEquals(true, communicator.hasNewAthlete());

        /* Test DENY a new Athlete */
        reset(mockInputStream);
        expect(mockInputStream.read()).andReturn(denyChar);
        replay(mockInputStream);

        communicator = new ConsoleCommunicator(mockInputStream, mockOutputStream);
        assertEquals(false, communicator.hasNewAthlete());

    }

    
}
