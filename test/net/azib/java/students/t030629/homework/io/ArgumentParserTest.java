package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import static junit.framework.Assert.*;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 10.05.2008
 * <br>Time: 17:16:26
 */
public class ArgumentParserTest {

    static {
        DecathlonCalculator.initProperties();
    }

    /* Tests for MISSING or INCORRECT ARGUMENTS */
    @Test (expected = IllegalArgumentException.class)
    public void missingArgumentsErrorThrown() {
        new Arguments();
    }
    @Test (expected = IllegalArgumentException.class)
    public void withoutInputMethod(){
        new Arguments("withoutDash");
    }
    @Test (expected = IllegalArgumentException.class)
    public void incorrectInputMethod(){
        new Arguments("-wrongWithDash");
    }
    @Test (expected = IllegalArgumentException.class)
    public void consoleWithParameterDetected(){
        new Arguments("-console", "obsoleteParameter");
    }
    @Test (expected = IllegalArgumentException.class)
    public void missingInputCsvParameterDetected(){
        new Arguments("-csv", "-conole"); // missing parameter for -csv
    }
    @Test (expected = IllegalArgumentException.class)
    public void missingDbParameterDetected(){
        new Arguments("-db", "-conole"); // missing parameter for -db
    }
    @Test (expected = IllegalArgumentException.class)
    public void missingOutputMethodDetected(){
        new Arguments("-console");
    }
    @Test (expected = IllegalArgumentException.class)
    public void incorrectOutputMethod(){
        new Arguments("-console", "-console");
    }
    @Test (expected = IllegalArgumentException.class)
    public void missingOutputCsvParameterDetected(){
        new Arguments("-console", "-csv"); // missing parameter for -csv
    }
    @Test (expected = IllegalArgumentException.class)
    public void missingXmlParameterDetected(){
        new Arguments("-console", "-xml"); // missing parameter for -csv
    }
    @Test (expected = IllegalArgumentException.class)
    public void missingHtmlParameterDetected(){
        new Arguments("-console", "-html"); // missing parameter for -csv
    }

    /* Tests for parameter OBJECTS */
    @Test
    public void correctInputMethodsAndFile(){
        String inFileName = "someFile.csv";
        // Check METHODs
        Arguments arguments = new Arguments("-console", "-conole");
        assertEquals("Incorrectly parsed input method", InputMethod.CONSOLE, arguments.getInMethod());
        arguments = new Arguments("-db", "someCompName", "-conole");
        assertEquals("Incorrectly parsed input method", InputMethod.DB, arguments.getInMethod());
        arguments = new Arguments("-csv", inFileName , "-conole");
        assertEquals("Incorrectly parsed input method", InputMethod.CSV, arguments.getInMethod());

        // Check FILE
        assertEquals("Incorrectly parsed input file", inFileName, arguments.getInFile().getName());
    }
    @Test
    public void correctDbNameAndId(){
        // Check competition NAME
        String competitionName = "compName";
        Arguments arguments = new Arguments("-db", competitionName, "-conole");
        assertEquals("Incorrectly parsed competition name", competitionName, arguments.getCompetitionName());
        // Check competition ID
        int competitionId = 2;
        arguments = new Arguments("-db", String.valueOf(competitionId), "-conole");
        assertEquals("Incorrectly parsed competition ID", competitionId, arguments.getCompetitionId());
    }
    @Test
    public void correctOutputMethodsAndFile(){
        String outFileName = "someFile.csv";
        // Check METHODs
        Arguments arguments = new Arguments("-console", "-conole");
        assertEquals("Incorrectly parsed output method", OutputMethod.CONOLE, arguments.getOutMethod());
        arguments = new Arguments("-console", "-csv", outFileName);
        assertEquals("Incorrectly parsed output method", OutputMethod.CSV, arguments.getOutMethod());
        arguments = new Arguments("-console", "-htMl", outFileName);
        assertEquals("Incorrectly parsed output method", OutputMethod.HTML, arguments.getOutMethod());
        arguments = new Arguments("-console", "-XmL", outFileName);
        assertEquals("Incorrectly parsed output method", OutputMethod.XML, arguments.getOutMethod());

        // Check FILE
        assertEquals("Incorrectly parsed output file", outFileName, arguments.getOutFile().getName());
    }


}
