package net.azib.java.students.t093052.homework.action.output;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OutputActionTypeTest {
	
	@Test
	public void testOutputActionTypes() throws Exception {
		assertEqualsCheck("-console", false, ConsoleOutputAction.class, 
				OutputActionType.CONSOLE);
		assertEqualsCheck("-csv", true, CsvOutputAction.class, 
				OutputActionType.CSV);
		assertEqualsCheck("-xml", true, XmlOutputAction.class, 
				OutputActionType.XML);
		assertEqualsCheck("-html", true, HtmlOutputAction.class, 
				OutputActionType.HTML);
	}

	private void assertEqualsCheck(String name, boolean paramNeeded,
			Class<? extends OutputAction> clazz, OutputActionType actionType) {
		assertEquals(name, actionType.getName());
		assertEquals(paramNeeded, actionType.isParamNeeded());
		assertEquals(clazz, actionType.getActionClass());
	}
}
