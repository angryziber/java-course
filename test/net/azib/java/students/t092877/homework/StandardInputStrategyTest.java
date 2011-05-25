package net.azib.java.students.t092877.homework;

import net.azib.java.students.t092877.homework.io.StandardInputStrategy;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Units tests for StandardInputStrategy class
 * User: Artjom Kruglenkov
 * Date: 24.05.2011
 */
public class StandardInputStrategyTest {

	public static StandardInputStrategy standardInputStrategy;

	@BeforeClass
	public static void beforeClass() {
		standardInputStrategy = new StandardInputStrategy();
	}

	@Test
	public void testIsThereAnotherEntry() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		String positiveResponse = "yes";
		String negativeResponse = "no";

		BufferedReader br = new BufferedReader(new StringReader(positiveResponse));

		Method method = StandardInputStrategy.class.getDeclaredMethod("isThereAnotherEntry", BufferedReader.class);
		method.setAccessible(true);

		Boolean anotherEntry = (Boolean)method.invoke(standardInputStrategy, br);
		assertTrue(anotherEntry);

		br = new BufferedReader(new StringReader(negativeResponse));

		anotherEntry = (Boolean)method.invoke(standardInputStrategy, br);
		assertFalse(anotherEntry);
	}

	@Test
	public void testStringValidator() {
		StandardInputStrategy.StringValidator val = standardInputStrategy.new  StringValidator();
		assertTrue(val.validate("not longer than 35 characters"));
		assertFalse(val.validate("over the limitttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"));
	}

	@Test
	public void testDateValidator() {
		StandardInputStrategy.DateValidator val = standardInputStrategy.new  DateValidator();
		assertTrue(val.validate("1983-01-01"));
		assertFalse(val.validate("01.01.1983"));
		assertFalse(val.validate("1983-1-1"));
		assertFalse(val.validate("1899-01-01"));
		assertFalse(val.validate("2100-12-31"));
	}

	@Test
	public void testResultValueValidator() {
		StandardInputStrategy.ResultValueValidator val = standardInputStrategy.new  ResultValueValidator();
		assertTrue(val.validate("12"));
		assertTrue(val.validate("12.61"));
		assertTrue(val.validate("0"));
		assertTrue(val.validate("4:35"));
		assertTrue(val.validate("12"));
		assertFalse(val.validate("12."));
		assertFalse(val.validate("4:"));
		assertFalse(val.validate("4:35."));
		assertFalse(val.validate(".25"));
	}
}
