package net.azib.java.students.t104971.homework.athletics.util;

import net.azib.java.students.t104971.homework.athletics.io.OutputType;
import net.azib.java.students.t104971.homework.athletics.io.SourceType;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author Jaroslav Judin
 */
public class InputParametersValidatorTest {

    private InputParametersValidator validator = new InputParametersValidator();

    @Test
    public void testValidateNotEnoughArguments() throws Exception {
        try {
            validator.validate("");
            fail("should throw exception - not enough arguments");
        } catch (UserInputException e) {
            assertEquals("Please, specify input and output methods", e.getMessage());
        }
    }

    @Test
    public void testValidateWrongInput() throws Exception {
        try {
            validator.validate("-xml", "-console");
            fail("should throw exception - not not such input method");
        } catch (UserInputException e) {
            assertEquals("input or output type doesn't exist", e.getMessage());
        }
    }

    @Test
    public void testValidateNotSpecifiedOutput() throws Exception {
        try {
            validator.validate("-console", "-xml");
            fail("should throw exception - no parameters for methods");
        } catch (UserInputException e) {
            assertEquals("Please, specify value for output type", e.getMessage());
        }
    }

    @Test
    public void testValidateConsoleParameters() throws Exception {
        try {
            validator.validate("-console", "path1", "-xml", "path2");
            fail("Console method cannot have path parameter");
        } catch (UserInputException e) {
            assertEquals("input or output type doesn't exist", e.getMessage());
        }

        try {
            validator.validate("-console", "path1", "-console");
            fail("Console method cannot have path parameter");
        } catch (UserInputException e) {
            assertEquals("input or output type doesn't exist", e.getMessage());
        }
    }

    @Test
    public void testValidateBothMethodsAreConsole() throws Exception {
        validator.validate("-console", "-console");
        validator.validate("-console", "-console", "path2");
        assertNotNull(validator.getSource());
        assertNull(validator.getSourceValue());
        assertNotNull(validator.getResult());
        assertNull(validator.getResultValue());
    }

    @Test
    public void testValidateInputWithParameterAndOutputIsConsole() throws Exception {
        validator.validate("-csv", "path", "-console");
        assertEquals(SourceType.CSV, validator.getSource());
        assertEquals("path", validator.getSourceValue());
        assertEquals(OutputType.CONSOLE, validator.getResult());
        assertNull(validator.getResultValue());
    }

    @Test
    public void testValidateNoParameterForOutputMethod() throws Exception {
        try {
            validator.validate("-csv", "path", "-xml");
            fail("should throw exception - no parameters for methods");
        } catch (UserInputException e) {
            assertEquals("Please, specify value for output type", e.getMessage());
            assertEquals(SourceType.CSV, validator.getSource());
            assertEquals("path", validator.getSourceValue());
            assertEquals(OutputType.XML, validator.getResult());
        }
    }

    @Test
    public void testValidateAllParametersRight() throws Exception {
        validator.validate("-csv", "path1", "-xml", "path2");
        assertEquals(SourceType.CSV, validator.getSource());
        assertEquals("path1", validator.getSourceValue());
        assertEquals(OutputType.XML, validator.getResult());
        assertEquals("path2", validator.getResultValue());
    }

}
