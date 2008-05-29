package net.azib.java.students.t010588.homework.exporter;

import net.azib.java.students.t010588.homework.Athlete;
import net.azib.java.students.t010588.homework.FieldEventResult;
import net.azib.java.students.t010588.homework.Result;
import net.azib.java.students.t010588.homework.RunningEventResult;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * ExporterTest
 *
 * @author slava
 */
public class ExporterTest {

	protected static final Result[] RESULTS1 = new Result[] { new RunningEventResult(0, 11.07f), new FieldEventResult(1, 6.42f),
			new FieldEventResult(2, 6f), new FieldEventResult(3, 1.75f), new RunningEventResult(4, 50.47f),
			new RunningEventResult(5, 13.5f), new FieldEventResult(6, 40f), new FieldEventResult(7, 4.0f),
			new FieldEventResult(8, 60f), new RunningEventResult(9, 4 * 60 + 20) };
	protected static final Result[] RESULTS2 = new Result[] { new RunningEventResult(0, 10.11f), new FieldEventResult(1, 7.20f),
			new FieldEventResult(2, 6.1f), new FieldEventResult(3, 1.92f), new RunningEventResult(4, 50.01f),
			new RunningEventResult(5, 13.4f), new FieldEventResult(6, 40f), new FieldEventResult(7, 4.0f),
			new FieldEventResult(8, 60f), new RunningEventResult(9, "3:11.02") };
	protected List<Athlete> athletes;

	@Before
	public void initExporterTest() {
		Athlete a1 = new Athlete();
		Athlete a2 = new Athlete();

		a1.setBirhday(new Date());
		a2.setBirhday(new Date());

		a1.setCountry(new char[] { 'E', 'E' });
		a2.setCountry(new char[] { 'U', 'S' });

		a1.setResults(RESULTS1);
		a2.setResults(RESULTS2);

		athletes = new LinkedList<Athlete>();
		athletes.add(a1);
		athletes.add(a2);
	}
	
	@Test
	public void unimplemented() throws Exception {
		
	}
	
}