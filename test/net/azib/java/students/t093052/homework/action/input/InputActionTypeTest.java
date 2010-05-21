package net.azib.java.students.t093052.homework.action.input;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputActionTypeTest {

	@Test
	public void testInputActionTypes() throws Exception {
		assertEqualsCheck("-console", false, ConsoleInputAction.class, 
				InputActionType.CONSOLE);
		assertEqualsCheck("-csv", true, CsvInputAction.class, 
				InputActionType.CSV);
		assertEqualsCheck("-db", true, DatabaseInputAction.class, 
				InputActionType.DB);
	}

	private void assertEqualsCheck(String name, boolean paramNeeded,
			Class<? extends InputAction> clazz, InputActionType actionType) {
		assertEquals(name, actionType.getName());
		assertEquals(paramNeeded, actionType.isParamNeeded());
		assertEquals(clazz, actionType.getActionClass());
	}
	
}
