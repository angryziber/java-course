package net.azib.java.students.t030633.homework.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import net.azib.java.students.t030633.homework.model.AbstractChecker;

import org.junit.Test;

/**
 * AbstractCheckerTest
 * 
 * @author t030633
 */
public abstract class AbstractCheckerTest {

	private AbstractChecker checker;

	public AbstractCheckerTest(AbstractChecker checker) {
		this.checker = checker;
	}
	
	/**
	 * Test methods for
	 * {@link net.azib.java.students.t030633.homework.model.AbstractChecker#checkCountry(String)}.
	 */
	@Test
	public void nullCountryAvoided() {
		assertNotNull(checker.checkCountry(null));
	}
	
	@Test
	public void existingCountryAccepted() {
		assertEquals("EE", checker.checkCountry("EE"));
	}

	@Test
	public void notExistingCountryRemoved() {
		assertEquals("", checker.checkCountry("PP"));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.AbstractChecker#checkDate(java.util.Date)}.
	 */
	@Test
	public void nullDateAvoided() {
		assertNotNull(checker.checkDate(null));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.AbstractChecker#checkName(String)}.
	 */
	@Test
	public void testCheckName() {
		assertNotNull(checker.checkName(null));
	}

}
