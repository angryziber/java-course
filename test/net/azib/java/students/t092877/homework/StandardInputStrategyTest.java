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
 * Created by IntelliJ IDEA.
 * User: Artjom
 * Date: 5/25/11
 * Time: 1:19 AM
 * To change this template use File | Settings | File Templates.
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
}
