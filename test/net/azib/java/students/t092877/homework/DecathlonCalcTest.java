package net.azib.java.students.t092877.homework;

import java.awt.print.Book;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class DecathlonCalcTest {

	public static DecathlonCalc decathlonCalc;

	@BeforeClass
	public static void beforeClass() {
		decathlonCalc = new DecathlonCalc();
	}

	@Ignore
	public void testGetCommandLineInputAsStr() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		Object[] args = new String[] {"-db", "2", "-html", "decathlon.htm"};

		Method method = DecathlonCalc.class.getDeclaredMethod("getCommandLineInputAsStr", String[].class);
		method.setAccessible(true);

		String commandLineInput = (String)method.invoke(decathlonCalc, args);
		assertThat(commandLineInput, is("-db 2 -html decathlon.htm "));
	}

	@Test
	public void testValidateCommandLineInput() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		String validCommand = "-db 2 -html decathlon.htm";
		String invalidCommand = "db Training -console";

		Method method = DecathlonCalc.class.getDeclaredMethod("validateCommandLineInput", String.class);
		method.setAccessible(true);

		Boolean isValid = (Boolean)method.invoke(decathlonCalc, validCommand);
		assertTrue(isValid);

		isValid = (Boolean)method.invoke(decathlonCalc, invalidCommand);
		assertFalse(isValid);

	}
}
