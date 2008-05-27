package net.azib.java.students.t020281.homework;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * DecathlonCalculatorTest
 *
 * @author Trial
 */
public class DecathlonCalculatorTest {
	
	public void processInput(DecathlonCalculator testCalculator, String s, OutputStream out){
		
			Scanner in = new Scanner(s);
			String[] res = testCalculator.readFromStream(in, new PrintStream(out));
			for (int j = 0; j < res.length; j++) {
				Sportsman person = new Sportsman(res[j]);
				testCalculator.sportsmenList.add(person);
			}

	}
	
	@Test
	public void consoleInputTest() {
		String LN = System.getProperty("line.separator");
		String input ="Szőrös Szűk"+LN+"3.04.1972"+LN+"HU"+LN+"13.75"+LN+"1:08.44"+LN+"19.18";
		input +=LN+"6:22.7"+LN+"54.84"+LN+"10.12"+LN+"1.50"+LN+"30.85"+LN+"2.80"+LN+"33.88"+LN+"no"+LN+"n"+LN;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
//		OutputStream out = System.out;
	    DecathlonCalculator testCalculator = new DecathlonCalculator();
		processInput(testCalculator, input, out);
		String expected="Welcome to Decathlon points calculator! Please insert sportsmen achievements:"+LN;
		expected+="Sportsman 1 data is: "+LN;
		expected+="Name: Date of birth: Country Code: 100 m sprint (sec):400 m sprint (min:sec):110 m hurdles (sec):1500 m race (min:sec):Long jump (m):Shot put (m):High jump (m):Discus throw (m):Pole vault (m):Javelin throw (m):Do you want to add another sportsman?(y/n): Please enter y or n: ";
		String actual=out.toString();
		System.out.println(actual);
		System.out.println(expected);
		assertEquals(expected,actual);
		double actualDouble = testCalculator.sportsmenList.getFirst().getRace1500mEvent();
		double expectedDouble = 382.7;
		assertEquals(expectedDouble,actualDouble);
		
	}
	
}
