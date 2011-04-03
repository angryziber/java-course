package net.azib.java.students.t104971.homework.athletics.util;

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
            assertEquals("Please, specify input([-console, -csv, -db]) and output([-console, -csv, -xml, -html]) methods", e.getMessage());
        }
    }

    @Test
    public void testValidateWrongInput() throws Exception {
        try {
            validator.validate("-xml", "-console");
            fail("should throw exception - not not such input method");
        } catch (UserInputException e) {
            assertEquals("-xml input method doesn't exist", e.getMessage());
        }
    }

    @Test
    public void testValidateNotSpecifiedOutput() throws Exception {
        try {
            validator.validate("-console", "-xml");
            fail("should throw exception - no parameters for methods");
        } catch (UserInputException e) {
            assertEquals("No parameters for output method -xml", e.getMessage());
        }
    }

    @Test
    public void testValidateConsoleParameters() throws Exception {
        try {
            validator.validate("-console", "path1", "-xml", "path2");
            fail("Console method cannot have path parameter");
        } catch (UserInputException e) {
            assertEquals("path1 output method doesn't exist", e.getMessage());
        }

        try {
            validator.validate("-console", "path1", "-console");
            fail("Console method cannot have path parameter");
        } catch (UserInputException e) {
            assertEquals("path1 output method doesn't exist", e.getMessage());
        }
    }

    @Test
    public void testValidateBothMethodsAreConsole() throws Exception {
        validator.validate("-console", "-console");
        validator.validate("-console", "-console", "path2");
        assertNull(validator.getInputParameter());
        assertNull(validator.getOutputParameter());
    }

    @Test
    public void testValidateInputWithParameterAndOutputIsConsole() throws Exception {
        validator.validate("-csv", "path", "-console");
        assertEquals("-csv", validator.getInputMethod());
        assertEquals("path", validator.getInputParameter());
        assertEquals("-console", validator.getOutputMethod());
        assertNull(validator.getOutputParameter());
    }

    @Test
    public void testValidateNoParameterForOutputMethod() throws Exception {
        try {
            validator.validate("-csv", "path", "-xml");
            fail("should throw exception - no parameters for methods");
        } catch (UserInputException e) {
            assertEquals("Output parameter doesn't specified for -xml", e.getMessage());
            assertEquals("-csv", validator.getInputMethod());
            assertEquals("path", validator.getInputParameter());
            assertEquals("-xml", validator.getOutputMethod());
        }
    }

    @Test
    public void testValidateAllParametersRight() throws Exception {
        validator.validate("-csv", "path1", "-xml", "path2");
        assertEquals("-csv", validator.getInputMethod());
        assertEquals("path1", validator.getInputParameter());
        assertEquals("-xml", validator.getOutputMethod());
        assertEquals("path2", validator.getOutputParameter());
    }
}
