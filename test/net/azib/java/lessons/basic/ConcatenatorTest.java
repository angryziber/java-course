package net.azib.java.lessons.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcatenatorTest {
	private String hello;

	@Before
	public void beforeEachTest() {
		System.out.println("Another test is executed");
	}

	@After
	public void afterEachTest() {
		System.out.println("Test finished");
	}

	@BeforeClass
	public static void beforeAllTest() {
		System.out.println("Concatenator tests are starting!");
	}

	@Test
	public void numbersAndLetters() {
		hello = "123";
		assertNotNull(hello);
		assertEquals("123abc", new Concatenator().concat("123", "abc"));
	}

	@Test
	public void lettersAndNumbers() {
		assertEquals("abc123", new Concatenator().concat("abc", "123"));
	}

	@Test
	public void nullsProduceEmptyStrings() {
	    assertEquals("abc", new Concatenator().concat("abc", null));
		assertEquals("abc", new Concatenator().concat(null, "abc"));
		assertEquals("", new Concatenator().concat(null, null));
	}

	@Test
	public void testMethodsDoNotShareState() {
		assertNull(hello);
	}

	@Test(expected = NullPointerException.class)
	public void expectingAnException() throws Exception {
		String x = null;
		x.toString();
	}
}
