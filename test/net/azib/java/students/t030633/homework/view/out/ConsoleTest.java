package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.*;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;

/**
 * ConsoleTest
 * 
 * @author t030633
 */
public class ConsoleTest {

	private static final String LN = System.getProperty("line.separator");
	private static final String TAB = "\t";
	private static final Date DATE = new Date();
	private static final Locale locale = new Locale(System.getProperty("user.country"));
	private static final DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
	private static final Map<Event, Double> RESULTS = new EnumMap<Event, Double>(Event.class);
	static {
		RESULTS.put(Event.DISCUS, 123D);
		RESULTS.put(Event.POLE, 456D);
	}

	public Athlete createMockAthlete() {
		Athlete mockAthlete = createMock(Athlete.class);
		expect(mockAthlete.getName()).andReturn("1");
		expect(mockAthlete.getBirthDate()).andReturn(DATE);
		expect(mockAthlete.getCountry()).andReturn("2");
		expect(mockAthlete.getScore()).andReturn(3);
		expect(mockAthlete.getResults()).andReturn(RESULTS);
		replay(mockAthlete);
		return mockAthlete;
	}

	public List<Athlete> createTestList(Athlete[] athletes) {
		List<Athlete> list = new LinkedList<Athlete>();
		for (Athlete a : athletes) {
			list.add(a);
		}
		return list;
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.view.out.Console#write(java.util.List)}.
	 * 
	 * @throws IOException
	 */
	@Test
	public void beginMessageIsShown() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(out);
		new Console(stream).write(null);
		assertEquals(Console.BEGIN_MSG + LN, out.toString());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.view.out.Console#write(java.util.List)}.
	 * 
	 * @throws IOException
	 */
	@Test
	public void athleteIsPrinted() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(out);
		List<Athlete> list = createTestList(new Athlete[] { createMockAthlete() });
		new Console(stream).write(list);
		assertEquals(Console.BEGIN_MSG + LN +
				"Name: 1" + LN +
				"Birth date: " + df.format(DATE) + LN +
				"Country: 2" + LN +
				"Total score: 3" + LN +
				"Results: " + LN
				+ TAB + Event.DISCUS.getName() + " - " + 123D + LN 
				+ TAB + Event.POLE.getName() + " - " + 456D + LN
				+ LN, out.toString());
	}

}
