package net.azib.java.students.t040719.homework;

import net.azib.java.students.t040719.homework.io.FileOutputTest;
import net.azib.java.students.t040719.homework.io.InputMethod;
import net.azib.java.students.t040719.homework.io.OutputMethod;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
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
		for (String param: s.split(","))
			args.add(param);
		return args.toArray(new String[0]);
	}
	
	@Test
	public void showUsageWhenInsufficientArgumentsSupplied() throws IOException{
		String message = Decathlon.WRONG_ARGS + LN + Decathlon.USAGE + LN;
		assertEquals(message, processInput("-console,here,-console"));
		assertEquals(message, processInput("-console,-xml"));
		assertEquals(message, processInput("-db,1,-html"));
		assertEquals(message, processInput("-csv,asd,-csv"));
	}
	
	@Test
	public void testNormalUsage() throws IOException, URISyntaxException{
		String message =  "Loading athletes' information from " + InputMethod.values()[1].getInputName() + LN +
		"Loaded 4 entrie(s)." + LN +
		"Outputting results to " + OutputMethod.values()[0].getOutputName() + LN +
		"All done." + LN;
		assertEquals(message, processInput("-csv," + FileOutputTest.class.getResource("inputTest.csv").toURI().getPath() + ",-console,"));
	}
}
