package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.view.in.InputMethod;
import net.azib.java.students.t030633.homework.view.in.hibernate.Hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * InputMethodTest
 *
 * @author t030633
 */
public class InputMethodTest {
	
	@Test 
	public void thereAreThreeMethods() {
		assertTrue(InputMethod.values().length == 3);
	}
	
	@Test 
	public void requiredMethodsExist() {
		assertNotNull(InputMethod.valueOf(InputMethod.class, "DB"));
		assertNotNull(InputMethod.valueOf(InputMethod.class, "CONSOLE"));
		assertNotNull(InputMethod.valueOf(InputMethod.class, "CSV"));
	}
	
	@Test 
	public void canGetClasses() {
		assertEquals(Console.class.getName(), InputMethod.CONSOLE.getInput().getClass().getName());
		assertEquals(Hibernate.class.getName(), InputMethod.DB.getInput().getClass().getName());
		assertEquals(CSV.class.getName(), InputMethod.CSV.getInput().getClass().getName());
	}

}
