package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import static org.easymock.EasyMock.*;

import java.io.ByteArrayOutputStream;
import static junit.framework.Assert.*;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 14.05.2008
 * <br>Time: 10:08:04
 */
public class PlainDataSaverTest {

    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void athletesCorrectlySaved() {
        String lineToWrite = "Some Line with spaces and line.separators"
                + System.getProperty("line.separator") + " created.";
        OrderedAthleteFormatter mockFormatter = createMock(OrderedAthleteFormatter.class);
        expect(mockFormatter.format()).andReturn(lineToWrite);
        replay(mockFormatter);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        new PlainDataSaver(mockFormatter, out).save();
        
        assertEquals(lineToWrite, out.toString());
    }

}
