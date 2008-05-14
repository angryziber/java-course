package net.azib.java.students.t980814.homework;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * DecaIOMethodTest
 *
 * @author dell
 */
public class DecaIOMethodTest {

	@Test
	public void testDefaultValues() {
		DecaIOMethod ioMethod = new DecaIOMethod();
		assertEquals(DecaIOMethod.DecaInputMethod.UNKNOWN, ioMethod.inputMethod);
		assertEquals(DecaIOMethod.DecaOutputMethod.UNKNOWN, ioMethod.outputMethod);
	}
	
	@Test
	public void testLegalIOMethods() {
		DecaIOMethod ioMethod = new DecaIOMethod();
		assertEquals(false, ioMethod.isIOMethodLegal());
		ioMethod.setInputMethod(DecaIOMethod.DecaInputMethod.CONSOLE, null);
		assertEquals(false, ioMethod.isIOMethodLegal());
		ioMethod.setOutputMethod(DecaIOMethod.DecaOutputMethod.CONSOLE, null);
		assertEquals(true, ioMethod.isIOMethodLegal());
	}

	@Test
	public void testInputMethodSetting() {
		DecaIOMethod ioMethod = new DecaIOMethod();
		ioMethod.setInputMethod(DecaIOMethod.DecaInputMethod.DATABASE, "test string");
		assertEquals(DecaIOMethod.DecaInputMethod.DATABASE, ioMethod.inputMethod);
		assertEquals("test string", ioMethod.inputParameter);
	}

	@Test
	public void testOutputMethodSetting() {
		DecaIOMethod ioMethod = new DecaIOMethod();
		ioMethod.setOutputMethod(DecaIOMethod.DecaOutputMethod.CSV, "test string");
		assertEquals(DecaIOMethod.DecaOutputMethod.CSV, ioMethod.outputMethod);
		assertEquals("test string", ioMethod.outputParameter);
	}
}
