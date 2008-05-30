package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.TreeSet;

import org.junit.Test;

/**
 * DecathlonOutputConsoleTest
 *
 * @author maksim
 */
public class DecathlonOutputConsoleTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonOutputConsole#writeData(java.util.Collection, java.io.File)}.
	 * @throws ParseException 
	 */
	@Test
	public void testWriteDataPrintEmptyTable() throws ParseException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DecathlonOutputConsole doc = new DecathlonOutputConsole(new PrintStream(out));
		
		String str = "+-----+-----------+----+----------+------+-----------+---------+--------+---------+-----------+------------+------------+----------+-------------+----------+" + System.getProperty("line.separator") +
					 "|Place|Total Score|Name|Birthday  |Coutry|Sprint 100m|Long Jump|Shot Put|High Jump|Sprint 400m|Hurdles 110m|Discus Throw|Pole Vault|Javelin Throw|Race 1500m|" + System.getProperty("line.separator") +
					 "+-----+-----------+----+----------+------+-----------+---------+--------+---------+-----------+------------+------------+----------+-------------+----------+" + System.getProperty("line.separator") +
					 "+-----+-----------+----+----------+------+-----------+---------+--------+---------+-----------+------------+------------+----------+-------------+----------+" + System.getProperty("line.separator");

		Collection<Athlete> col = new TreeSet<Athlete>();

		
		doc.writeData(col, null);
		
		assertEquals(str, out.toString());
		
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonOutputConsole#printTableSeparator(int)}.
	 */
	@Test
	public void testPrintTableSeparatorNameLen2() {
		int longestNameLen = 2;
		String str= "";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		DecathlonOutputConsole doc = new DecathlonOutputConsole(new PrintStream(out));
		
		
		str = "|Place|Total Score|Name";
		for (int i = 0; i < (longestNameLen - "Name".length()); i++) {
			str += " ";
		}
		str += "|Birthday  |Coutry|Sprint 100m|Long Jump|Shot Put|High Jump|Sprint 400m|Hurdles 110m|Discus Throw|Pole Vault|Javelin Throw|Race 1500m|";

		doc.printTableHeading(longestNameLen);
		assertEquals(str + System.getProperty("line.separator"), out.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonOutputConsole#printTableSeparator(int)}.
	 */
	@Test
	public void testPrintTableSeparatorNameLen40() {
		int longestNameLen = 40;
		String str= "";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		DecathlonOutputConsole doc = new DecathlonOutputConsole(new PrintStream(out));
		
		
		str = "|Place|Total Score|Name";
		for (int i = 0; i < (longestNameLen - "Name".length()); i++) {
			str += " ";
		}
		str += "|Birthday  |Coutry|Sprint 100m|Long Jump|Shot Put|High Jump|Sprint 400m|Hurdles 110m|Discus Throw|Pole Vault|Javelin Throw|Race 1500m|";

		doc.printTableHeading(longestNameLen);
		assertEquals(str + System.getProperty("line.separator"), out.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonOutputConsole#printTableHeading(int)}.
	 */
	@Test
	public void testPrintTableHeading40() {
		int longestNameLen = 40;
		String str= "";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		DecathlonOutputConsole doc = new DecathlonOutputConsole(new PrintStream(out));
		
		
		str = "+-----+-----------+";
		for (int i = 0; i < longestNameLen; i++) {
			str += "-";
		}
		str += "+----------+------+-----------+---------+--------+---------+-----------+------------+------------+----------+-------------+----------+";

		doc.printTableSeparator(longestNameLen);
		assertEquals(str + System.getProperty("line.separator"), out.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonOutputConsole#printAthleteResults(net.azib.java.students.t001370.homework.Athlete, int, int)}.
	 * @throws ParseException 
	 */
	@Test
	public void testPrintAthleteResults() throws ParseException {
		int longestNameLen = 40;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		DecathlonOutputConsole doc = new DecathlonOutputConsole(new PrintStream(out));
		
		Athlete a = new Athlete();
		a.setName("Viska Oda");
		a.setBirthday(new SimpleDateFormat("dd.MM.yyyy").parse("12.12.1212"));
		a.setCountryCode("EE");
		a.competitionResults.setResult100mRace(12);
		a.competitionResults.setResult110mHurdles(12);
		a.competitionResults.setResult1500mRace(333);
		a.competitionResults.setResult400mSprint(53);
		a.competitionResults.setResultDiscusThrow(25);
		a.competitionResults.setResultHighJump(4);
		a.competitionResults.setResultJavelinThrow(25);
		a.competitionResults.setResultLongJump(5);
		a.competitionResults.setResultPoleVault(25);
		a.competitionResults.setResultShotPut(12);

		doc.printAthleteResults(a, ""+1, longestNameLen);
		
		String tempStr = "";
		String result = "";
		NumberFormat nf = new DecimalFormat("#0.00");

		//print place
		tempStr = "" + 1;
		result = "|" + tempStr;
		for (int i = 0; i < (5 - tempStr.length()); i++) {
			result += " ";
		}
		
		//print total score
		tempStr = "" + a.competitionResults.getTotalScore();
		result += "|" + tempStr;
		for (int i = 0; i < (11 - tempStr.length()); i++) {
			result += " ";
		}
		
		//print name
		tempStr = "" + a.getName();
		result += "|" + tempStr;
		for (int i = 0; i < (longestNameLen - tempStr.length()); i++) {
			result += " ";
		}
		
		//print birthday
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		tempStr = "" + ((SimpleDateFormat)df).format(a.getBirthday());
		result += "|" + tempStr;
		for (int i = 0; i < (10 - tempStr.length()); i++) {
			result += " ";
		}

		
		//print country code
		tempStr = "" + a.getCountryCode();
		result += "|" + tempStr;
		for (int i = 0; i < (6 - tempStr.length()); i++) {
			result += " ";
		}
		
		//print 100m sprint
		tempStr = "" + nf.format(a.competitionResults.getResult100mRace())/* + 
					" (" + DecathlonFormulaArguments.RUNNING_EVENT_100M_IN_SEC.
							getRunningEventResult(athlete.competitionResults.getResult100mRace()) + ")"*/;
		result += "|" + tempStr;
		for (int i = 0; i < (11 - tempStr.length()); i++) {
			result += " ";
		}

		//print Long Jump 
		tempStr = "" + nf.format(a.competitionResults.getResultLongJump()) /*+ 
					" (" + DecathlonFormulaArguments.FIELD_EVENT_LONG_JUMP_IN_M.
							getFieldEventResult(athlete.competitionResults.getResultLongJump()) + ")"*/;
		result += "|" + tempStr;
		for (int i = 0; i < (9 - tempStr.length()); i++) {
			result += " ";
		}
		
		//Shot Put
		tempStr = "" + nf.format(a.competitionResults.getResultShotPut());
		result += "|" + tempStr;
		for (int i = 0; i < (8 - tempStr.length()); i++) {
			result += " ";
		}

		//High Jump
		tempStr = "" + nf.format(a.competitionResults.getResultHighJump());
		result += "|" + tempStr;
		for (int i = 0; i < (9 - tempStr.length()); i++) {
			result += " ";
		}

		//Sprint 400m
		tempStr = "" + nf.format(a.competitionResults.getResult400mSprint());
		result += "|" + tempStr;
		for (int i = 0; i < (11 - tempStr.length()); i++) {
			result += " ";
		}

		//Hurdles 110m
		tempStr = "" + nf.format(a.competitionResults.getResult110mHurdles());
		result += "|" + tempStr;
		for (int i = 0; i < (12 - tempStr.length()); i++) {
			result += " ";
		}

		//Discus Throw
		tempStr = "" + nf.format(a.competitionResults.getResultDiscusThrow());
		result += "|" + tempStr;
		for (int i = 0; i < (12 - tempStr.length()); i++) {
			result += " ";
		}

		//Pole Vault
		tempStr = "" + nf.format(a.competitionResults.getResultPoleVault());
		result += "|" + tempStr;
		for (int i = 0; i < (10 - tempStr.length()); i++) {
			result += " ";
		}

		//Javelin Throw
		tempStr = "" + nf.format(a.competitionResults.getResultJavelinThrow());
		result += "|" + tempStr;
		for (int i = 0; i < (13 - tempStr.length()); i++) {
			result += " ";
		}

		//Race 1500m
		tempStr = "" + nf.format(a.competitionResults.getResult1500mRace());
		result += "|" + tempStr;
		for (int i = 0; i < (10 - tempStr.length()); i++) {
			result += " ";
		}
		result += "|" + System.getProperty("line.separator");
		
		assertEquals(result, out.toString());
	}

}
