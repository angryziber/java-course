package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
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
	public void testWriteData() throws ParseException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DecathlonOutputConsole doc = new DecathlonOutputConsole(new PrintStream(out));
		
		String str = "+-----+-----------+----------+----------+------+-----------+---------+--------+---------+-----------+------------+------------+----------+-------------+----------+" + System.getProperty("line.separator") +
						"|Place|Total Score|Name      |Birthday  |Coutry|Sprint 100m|Long Jump|Shot Put|High Jump|Sprint 400m|Hurdles 110m|Discus Throw|Pole Vault|Javelin Throw|Race 1500m|" + System.getProperty("line.separator") +
						"+-----+-----------+----------+----------+------+-----------+---------+--------+---------+-----------+------------+------------+----------+-------------+----------+" + System.getProperty("line.separator") +
						"|1    |4234       |Siim Susi |1.01.1976 |EE    |12,61      |5,00     |9,22    |1,50     |59,39      |16,43       |21,60       |2,60      |35,81        |325,72    |" + System.getProperty("line.separator") +
						"|2    |3199       |Beata Kana|1.03.1982 |ZA    |13,04      |4,53     |7,79    |1,55     |64,72      |18,74       |24,20       |2,40      |28,20        |410,76    |" + System.getProperty("line.separator") +
						"+-----+-----------+----------+----------+------+-----------+---------+--------+---------+-----------+------------+------------+----------+-------------+----------+" + System.getProperty("line.separator");

		Collection<Athlete> col = new TreeSet<Athlete>();

		Athlete a = new Athlete();
		a.setName("Siim Susi");
		a.setBirthday(DateFormat.getDateInstance(DateFormat.SHORT).parse("1.01.1976"));
		a.setCountryCode("EE");
		a.competitionResults.setResult100mRace((float)12.61);
		a.competitionResults.setResult110mHurdles((float)16.43);
		a.competitionResults.setResult1500mRace((float)325.72);
		a.competitionResults.setResult400mSprint((float)59.39);
		a.competitionResults.setResultDiscusThrow((float)21.60);
		a.competitionResults.setResultHighJump((float)1.50);
		a.competitionResults.setResultJavelinThrow((float)35.81);
		a.competitionResults.setResultLongJump((float)5.00);
		a.competitionResults.setResultPoleVault((float)2.60);
		a.competitionResults.setResultShotPut((float)9.22);
		
		col.add(a);

		Athlete b = new Athlete();
		b.setName("Beata Kana");
		b.setBirthday(DateFormat.getDateInstance(DateFormat.SHORT).parse("1.03.1982"));
		b.setCountryCode("ZA");
		b.competitionResults.setResult100mRace((float)13.04);
		b.competitionResults.setResult110mHurdles((float)18.74);
		b.competitionResults.setResult1500mRace((float)410.76);
		b.competitionResults.setResult400mSprint((float)64.72);
		b.competitionResults.setResultDiscusThrow((float)24.20);
		b.competitionResults.setResultHighJump((float)1.55);
		b.competitionResults.setResultJavelinThrow((float)28.20);
		b.competitionResults.setResultLongJump((float)4.53);
		b.competitionResults.setResultPoleVault((float)2.40);
		b.competitionResults.setResultShotPut((float)7.79);
		
		col.add(b);
		
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

		doc.printAthleteResults(a, 1, longestNameLen);
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	    String dateStr = "" + ((SimpleDateFormat)df).format(a.getBirthday());
		
		for (int i = 0; i < (10 - dateStr.length()); i++) {
			dateStr += " ";
		}

		assertEquals("|1    |17906      |Viska Oda                               |" + dateStr + "|EE    |12,00      |5,00     |12,00   |4,00     |53,00      |12,00       |25,00       |25,00     |25,00        |333,00    |" + System.getProperty("line.separator"), 
				out.toString());
	}

}
