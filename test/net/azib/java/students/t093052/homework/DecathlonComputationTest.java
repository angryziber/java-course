package net.azib.java.students.t093052.homework;

import net.azib.java.students.t093052.homework.action.Action;
import net.azib.java.students.t093052.homework.action.ActionType;
import net.azib.java.students.t093052.homework.action.input.ConsoleInputAction;
import net.azib.java.students.t093052.homework.action.input.InputActionType;
import net.azib.java.students.t093052.homework.action.output.HtmlOutputAction;
import net.azib.java.students.t093052.homework.action.output.OutputActionType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * DecathlonComputationTest
 *
 * @author Kostja
 */
public class DecathlonComputationTest {

	@Test
	public void testPlaceInterval() throws Exception {
		DecathlonComputation computation = new DecathlonComputation();
		
		assertEquals("1-3", computation.calculatePlaceInterval(1, 3));
		assertEquals("4-5", computation.calculatePlaceInterval(4, 2));
		assertEquals("2", computation.calculatePlaceInterval(2, 1));
	}
	
	@Test
	public void testGetActionTypeByName() throws Exception {
		DecathlonComputation computation = new DecathlonComputation();
		
		assertEquals(InputActionType.DB, 
				getAction(computation, "-db", InputActionType.values()));
		assertEquals(InputActionType.CONSOLE, 
				getAction(computation, "-console", InputActionType.values()));
		assertEquals(InputActionType.CSV, 
				getAction(computation, "-csv", InputActionType.values()));
		
		assertEquals(OutputActionType.CONSOLE, 
				getAction(computation, "-console", OutputActionType.values()));
		assertEquals(OutputActionType.CSV, 
				getAction(computation, "-csv", OutputActionType.values()));
		assertEquals(OutputActionType.XML, 
				getAction(computation, "-xml", OutputActionType.values()));
		assertEquals(OutputActionType.HTML, 
				getAction(computation, "-html", OutputActionType.values()));
	}
	
	@Test
	public void testInitAction() throws Exception {
		DecathlonComputation computation = new DecathlonComputation();
		
		List<String> argsList = Arrays.asList(new String[] {
				"-console", "-html", "output.html"});
		Iterator<String> argIterator = argsList.iterator();
		
		assertTrue(computation.initAction(argIterator, 
				InputActionType.values()) instanceof ConsoleInputAction);
		assertTrue(computation.initAction(argIterator, 
				OutputActionType.values()) instanceof HtmlOutputAction);
	}
	
	private <T extends ActionType<? extends Action>> T getAction(
			DecathlonComputation computation, String param, T[] values) {
		return computation.getActionTypeByName(param, values);
	}
}
