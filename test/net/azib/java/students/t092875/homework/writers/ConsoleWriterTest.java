package net.azib.java.students.t092875.homework.writers;

import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/**
 * ConsoleWriterTest
 *
 * @author Mihhail
 */
public class ConsoleWriterTest {
	@Test
	public void  testWrite(){
		String[] expectedResults = {
			"Athlete: Mihhail Arhipov(ET)",
			"Date Of Birth: 01.01.70",
			"Place: 1",
			"Result in sprint 100m: 50.20",
			"Result in long jump: 50.20",
			"Result in shot put: 50.20",
			"Result in high jump: 50.20",
			"Result in sprint 400m: 50.20",
			"Result in hurdles 110m: 50.20",
			"Result in discus throw: 50.20",
			"Result in pole vault: 50.20",
			"Result in javelin throw: 50.20",
			"Result in race 1500m: 50.20",
			"Total Result: 2000"
		};
		List<Athlete> athletes = new ArrayList<Athlete>();
		Date dob = new Date(0);
		String[] results = {"50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20"};
		Athlete a = new Athlete("Mihhail Arhipov",dob,"ET",results);
		a.setPlace("1");
		a.setResult(2000);
		athletes.add(a);
		ConsoleWriter writer = new ConsoleWriter();
		writer.write(athletes);
		assertArrayEquals(expectedResults, writer.getTestData());
	}
}
