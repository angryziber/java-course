package net.azib.java.students.t092861.homework;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class DecathlonCalculatorTest {
	
	String[] array = {	
			"-csv /inputs/input.csv -console",		
			"-csv /inputs/input.csv -csv /outputs1/output1.csv",
			"-csv /inputs/input.csv -xml /outputs1/output1.xml",
			"-csv /inputs/input.csv -html /outputs1/output1.html",
			"-csv /inputs/input.csv -csv /outputs2/output2.csv",
			"-csv /inputs/input.csv -xml output2.xml",
			"-csv /inputs/input.csv -html output2.html",
			"-console -console",
			"-console -csv /outputsTest/output3.csv",
			"-console -xml /outputsTest/output3.xml",
			"-console -html /outputsTest/output3.html",
			"-console -csv outputTest4.csv",
			"-console -xml outputTest4.xml",
			"-console -html outputTest4.html",
			"-db 1 -console",
			"-db 2 -csv /outputs5/output5.csv",
			"-db 1 -xml /outputs5/output5.xml",
			"-db Training -html /outputs5/output5.html",
			"-db DECATHLON4BEER -csv output6.csv",
			"-db Training -xml output6.xml",
			"-db 1 -html output6.html"
	};
	
	@Test
	public void testCheckParametersValid() {
		String[] line;
		for (int i = 0; i < array.length; i++) {
			line = array[i].split(" ");
			assertTrue(new DecathlonCalculator().checkParameters(line));
		}
	}
	
	@Test
	public void testCheckParametersInValid() {
		String[] array2 = {	
				"-console -csv",
				"-console -xml ",
				"-console -html",
				"-csv -console",		
				"-csv -csv /outputs1/output1.csv",
				"-csv /inputs/input.csv -xml",
				"-csv /inputs/input.csv -html",
				"-csv /inputs/input.csv -csv",
				"-csv -xml output2.xml",
				"-csv -html output2.html",
				"-db -console",
				"-db 2 -csv",
				"-db -xml /outputs5/output5.xml",
				"-db -html",
				"-db -csv output6.csv",
				"-db Training -xml",
				"-db  -html output6.html"
		};
		String[] line;
		for (int i = 0; i < array2.length; i++) {
			line = array2[i].split(" ");
			assertFalse(new DecathlonCalculator().checkParameters(line));
		}
	}

	@Test
	@Ignore
	public void testProcessParameters() {
		String[] line;
		for (int i = 0; i < array.length; i++) {
			line = array[i].split(" ");
			new DecathlonCalculator().processParameters(line);
		}
	}
}
