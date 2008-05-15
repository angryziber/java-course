package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.DecathlonConstants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;


/**
 * ConsoleInputTest
 *
 * @author romi
 */
public class ConsoleInputTest {
	private static final String LN = System.getProperty("line.separator");;

	ConsoleInput ci;
	ByteArrayOutputStream out;
	
	private void setup(String s) {
		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes())));
		out = new ByteArrayOutputStream();
		ci = new ConsoleInput(br, new PrintStream(out));
	}
	
	private String formatInputString(String... params){
		String result = "";
		for(String s: params)
			result += s + LN;
		return result;
	}
	
	private String formatOutputString(String prefix, String error, String... params){
		String result = "";
		for(int i=0; i<params.length; i++)
			result += prefix + "'" + params[i] + "'" + error + LN;
		return result + prefix;
	}

	@Test
	public void invalidNameCheck() {
		String wN1 = "JuhanParts";
		String wN2 = "Juhan-Parts";
		String cN = "Juha Parts";
		String input = formatInputString(wN1, wN2, cN);
		String output = formatOutputString("Name: ", ConsoleInput.INVALID_NAME, wN1, wN2); 
		setup(input);
		String name = ci.getName();
		assertEquals(output, out.toString());
		assertTrue("Names are not equal.",name.equals(cN));
	}
	
	@Test
	public void invalidCountryCheck(){
		String wC1 = "xx";
		String wC2 = "Eesti";
		String cC = "EE";
		String input = formatInputString(wC1, wC2, cC);
		String output = formatOutputString("Country (ISO 2-letter code): ", ConsoleInput.INVALID_COUNTRY, wC1.toUpperCase(), wC2.toUpperCase());
		setup(input);
		String country = ci.getCountry();
		assertEquals(output, out.toString());
		assertTrue("Country codes are not equal.",country.equals(cC));
	}

	@Test
	public void invalidDateCheck() throws ParseException{
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
		String wD1 = "29.2.1999";
		String wD2 = "20.13.2000";
		String cD = df.format(new SimpleDateFormat(InputParser.DATE_FORMAT).parse("21.03.1980"));
		String input = formatInputString(wD1, wD2, cD);
		String output = formatOutputString("Date of birth (" + ((SimpleDateFormat)df).toPattern() + "): ", ConsoleInput.INVALID_DATE, wD1, wD2);
		setup(input);
		Date date = ci.getDOB();
		assertEquals(output, out.toString());
		assertTrue("Dates are not equal.",df.format(date).equals(cD));
	}

	@Test
	public void invalidResultsCheck(){
		String[] stringInput = new String[] {"12.619","5,00", "5","9.222","1.50","1:04.72", "66.78","16.43","21.60","2.60","35.81","5:25.72","asd","450.78"};
		String input = formatInputString(stringInput);
		String output = "";
		int j=0;
		float[] results = new float[10];
		float[] results2;
		for(int i=0; i<stringInput.length; i++){
			try{
				results[j] = (float)((int)Math.round(Float.parseFloat(stringInput[i])*100)/100.0);
				output += DecathlonConstants.getOrdinal(j).getName()+": ";
				j++;
			}catch (NumberFormatException e){
				output += DecathlonConstants.getOrdinal(j).getName()+": '" + stringInput[i] +"'" + ConsoleInput.NOT_A_FLOAT + LN;
			}
		}
		setup(input);
		results2 = ci.getDecathlonResults();
		assertEquals("NB! All event marks should be entered using the format 0.00! (in SI units)" + LN + output, out.toString());
		for (int i=0; i<results2.length; i++)
			assertEquals(results2[i], results[i],0.001);
	}
	
	@Test
	public void testGetResultsWithZeroAthletes(){
		String wN1 = "asd";
		String wN2 = "1.0";
		String cN = "0";
		String input = formatInputString(wN1, wN2, cN);
		String output = formatOutputString("How many athletes do you want to enter? ", ConsoleInput.NOT_AN_INT, wN1, wN2); 
		setup(input);
		ci.getResults();
		assertEquals(output + "Input complete." + LN, out.toString());
	}
	
	@Test
	public void testGetResults() throws ParseException{
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
		Date d = new SimpleDateFormat(InputParser.DATE_FORMAT).parse("21.03.1980");
		List<Athlete> al1 = new ArrayList<Athlete>();
		al1.add(new Athlete("Siim Susi", d, "EE", new float[10]));
		String input = formatInputString("1", "Siim Susi", df.format(d),"ee","0","0","0","0","0","0","0","0","0","0");
		setup(input);
		List<Athlete> al2 =	ci.getResults();
		assertEquals(al1.size(),al2.size());
		assertEquals(al1.get(0).getName(), al2.get(0).getName());
		assertEquals(al1.get(0).getBirthdayString(), al2.get(0).getBirthdayString());
		assertEquals(al1.get(0).getCountryCode(), al2.get(0).getCountryCode());
		assertEquals(al1.get(0).getDecathlonPoints(), al2.get(0).getDecathlonPoints());
		for (int i=0; i<10; i++)
			assertEquals(al1.get(0).getDecathlonResult(i), al2.get(0).getDecathlonResult(i));
		}
	
}
