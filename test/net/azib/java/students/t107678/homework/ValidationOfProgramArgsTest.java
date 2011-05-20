package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationOfProgramArgsTest {

    ValidationOfProgramArgs validationOfProgramArgs = new ValidationOfProgramArgs();


    @Test
    public void validateOneInputArgs() throws Exception {
        String[] input1 = {"-console"};
        String[] input2 = {"-html"};

        assertFalse(validationOfProgramArgs.validateProgramArguments(input1));
        assertFalse(validationOfProgramArgs.validateProgramArguments(input2));
    }

    @Test
    public void validateTwoCorrectInputArgs() throws Exception {
        String[] input = {"-console", "-console"};
        assertTrue(validationOfProgramArgs.validateProgramArguments(input));
    }

    @Test
    public void validateTwoIncorrectInputArgs() throws Exception {
        String[] input1 = {"-console", "-csv"};
        String[] input2 = {"-csv", "-csv"};
        String[] input3 = {"-db", "2"};
        String[] input4 = {"-db", "-console"};


        assertFalse(validationOfProgramArgs.validateProgramArguments(input1));
        assertFalse(validationOfProgramArgs.validateProgramArguments(input2));
        assertFalse(validationOfProgramArgs.validateProgramArguments(input3));
        assertFalse(validationOfProgramArgs.validateProgramArguments(input4));


    }

    @Test
    public void validateThreeCorrectInputArgs() throws Exception {
        String[] input1 = {"-console", "-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input2 = {"-console", "-xml", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input3 = {"-console", "-html", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input4 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues","-console"};


        assertTrue(validationOfProgramArgs.validateProgramArguments(input1));
        assertTrue(validationOfProgramArgs.validateProgramArguments(input2));
        assertTrue(validationOfProgramArgs.validateProgramArguments(input3));
        assertTrue(validationOfProgramArgs.validateProgramArguments(input4));

    }

    @Test
    public void validateThreeInCorrectInputArgs() throws Exception {
        String[] input1 = {"-csv", "-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input2 = {"-csv", "-console", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};

        assertFalse(validationOfProgramArgs.validateProgramArguments(input1));
        assertFalse(validationOfProgramArgs.validateProgramArguments(input2));


    }

    @Test
    public void validateFourCorrectInputArgs() throws Exception {
        String[] input1 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
	    String[] input2 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-xml", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValuesXML"};
	    String[] input3 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-html", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValuesHTML"};
	    String[] input4 = {"-db", "2" ,"-html", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValuesHTML"};
	    String[] input5 = {"-db", "2" ,"-xml", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValuesXML"};

        assertTrue(validationOfProgramArgs.validateProgramArguments(input1));
	    assertTrue(validationOfProgramArgs.validateProgramArguments(input2));
	    assertTrue(validationOfProgramArgs.validateProgramArguments(input3));
	    assertTrue(validationOfProgramArgs.validateProgramArguments(input4));
	    assertTrue(validationOfProgramArgs.validateProgramArguments(input5));



    }

    @Test
    public void validateFourInCorrectInputArgs() throws Exception {
        String[] input1 = {"-console", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input2 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-db", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input3 = {"-console", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-db", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
	    String[] input4 = {"-xml", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValuesXML","-db", "2"};
	    String[] input5 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-db", "2"};

        assertFalse(validationOfProgramArgs.validateProgramArguments(input1));
        assertFalse(validationOfProgramArgs.validateProgramArguments(input2));
        assertFalse(validationOfProgramArgs.validateProgramArguments(input3));
	    assertFalse(validationOfProgramArgs.validateProgramArguments(input4));
	    assertFalse(validationOfProgramArgs.validateProgramArguments(input5));

    }


    @Test
    public void validateFiveInputArgs() throws Exception {
        String[] input1 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues", "csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues", "-console"};
        String[] input2 = {"-csv","-csv","-csv","-csv","-csv" };
	    String[] input3 = {"-xml", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValuesXML","-db", "2", "text"};

        assertFalse(validationOfProgramArgs.validateProgramArguments(input1));
        assertFalse(validationOfProgramArgs.validateProgramArguments(input2));
	    assertFalse(validationOfProgramArgs.validateProgramArguments(input3));

    }


}
