package net.azib.java.students.t001370.lectures.lec5.home;


import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Test;


/**
 * BinaryParserTest
 *
 * @author maksim
 */
public class BinaryParserTest {
	
	private static String LN = System.getProperty("line.separator");
	
	
	/*public String processInput(String inp){
		Scanner input = new Scanner(inp);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new BinaryParser(out, input);
		return out.toString
	}*/
	
	
	@Test
	public void testWelcomeMsg() throws Exception {
		assertEquals("Welcome! Enter binary ('x' for exit): ", 
				new BinaryParser().WELCOME_MSG);
	}
	
	@Test
	public void testErrorMsg() throws Exception{
		assertEquals("Error! Entered number is not binary :: ", 
				new BinaryParser().ERROR_MSG);
	}
	
	@Test
	public void testExitMsg() throws Exception{
		assertEquals("Exit! You have pressed 'x' for exit!", 
				new BinaryParser().EXIT_MSG);
	}
	
	private String handleInput(String str){
		Scanner in = new Scanner(str);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new BinaryParser(new PrintStream(out), in).parseBinary();
		
		return out.toString();
	}
	
	@Test
	public void testEnterX() throws Exception{
		String expectedStr = "Welcome! Enter binary ('x' for exit): " + LN +
				"Exit! You have pressed 'x' for exit!" + LN;
		
		assertEquals(expectedStr,
				handleInput("x"));
	}
	
	@Test
	public void testParseBinary() throws Exception{
		String expectedStr = "Welcome! Enter binary ('x' for exit): " + LN +
				"Binary in Dec: 15 and in Hex: 0xF" + LN;

		try{
			assertEquals(expectedStr,
				handleInput("1111"));
		}
		catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}

}
