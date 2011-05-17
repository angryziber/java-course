package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidationOfProgramArgsTest {

    ValidationOfProgramArgs validationOfProgramArgs = new ValidationOfProgramArgs();


    @Test
    public void validateOneInputArgs() throws Exception {
        String[] input1 = {"-console"};
        String[] input2 = {"-html"};

        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input1));
        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input2));
    }

    @Test
    public void validateTwoCorrectInputArgs() throws Exception {
        String[] input = {"-console", "-console"};
        assertEquals(true, validationOfProgramArgs.validateProgramArguments(input));
    }

    @Test
    public void validateTwoIncorrectInputArgs() throws Exception {
        String[] input1 = {"-console", "-csv"};
        String[] input2 = {"-csv", "-csv"};
        String[] input3 = {"-db", "2"};
        String[] input4 = {"-db", "-console"};


        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input1));
        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input2));
        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input3));
        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input4));


    }

    @Test
    public void validateThreeCorrectInputArgs() throws Exception {
        String[] input1 = {"-console", "-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input2 = {"-console", "-xml", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input3 = {"-console", "-html", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input4 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues","-console"};


        assertEquals(true, validationOfProgramArgs.validateProgramArguments(input1));
        assertEquals(true, validationOfProgramArgs.validateProgramArguments(input2));
        assertEquals(true, validationOfProgramArgs.validateProgramArguments(input3));
        assertEquals(true, validationOfProgramArgs.validateProgramArguments(input4));

    }

    @Test
    public void validateThreeInCorrectInputArgs() throws Exception {
        String[] input1 = {"-csv", "-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input2 = {"-csv", "-console", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};

        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input1));
        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input2));


    }

    @Test
    public void validateFourCorrectInputArgs() throws Exception {
        String[] input1 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};

        assertEquals(true, validationOfProgramArgs.validateProgramArguments(input1));

    }

    @Test
    public void validateFourInCorrectInputArgs() throws Exception {
        String[] input1 = {"-console", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input2 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-db", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};
        String[] input3 = {"-console", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues","-db", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues"};


        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input1));
        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input2));
        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input3));

    }


    @Test
    public void validateFiveInputArgs() throws Exception {
        String[] input1 = {"-csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/InputValues", "csv", "/home/radomir/Documents/JavaRepo/test/net/azib/java/students/t107678/homework/OutputValues", "-console"};
        String[] input2 = {"-csv","-csv","-csv","-csv","-csv" };

        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input1));
        assertEquals(false, validationOfProgramArgs.validateProgramArguments(input2));

    }


}
