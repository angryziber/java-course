package net.azib.java.students.t040719.homework;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;


/**
 * DecathlonTest
 *
 * @author romi
 */
public class DecathlonTest {
	
	private static final String LN = System.getProperty("line.separator");
	
	private String processInput(String s) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		if (s != "")
			new Decathlon(new PrintStream(out)).processInput(parseParameters(s));
		else
			new Decathlon(new PrintStream(out)).processInput();
		return out.toString();
	}
	
	private String[] parseParameters(String s){
		Collection<String> args = new ArrayList<String>();
		for (String param: s.split("\\s"))
			args.add(param);
		return args.toArray(new String[0]);
	}
	
	@Test
	public void showUsageWhenInsufficientArgumentsSupplied() throws IOException{
		String message = Decathlon.WRONG_ARGS + LN + Decathlon.USAGE + LN;
		assertEquals(message, processInput("-console here -console"));
		assertEquals(message, processInput("-console -xml"));
		assertEquals(message, processInput("-db 1 -html"));
		assertEquals(message, processInput("-csv -csv"));
		assertEquals(message, processInput("-db Training -csv test.txt"));
	}
}
