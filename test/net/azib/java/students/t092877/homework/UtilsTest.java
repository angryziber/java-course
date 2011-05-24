package net.azib.java.students.t092877.homework;

import net.azib.java.students.t092877.homework.model.Athlete;
import net.azib.java.students.t092877.homework.util.Utils;
import org.junit.Test;

import java.util.*;

import static net.azib.java.students.t092877.homework.util.Utils.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Units tests for Utils class
 * User: Artjom Kruglenkov
 * Date: 24.05.2011
 */
public class UtilsTest {

	/**
	 * Tests athlete's place computation
	 */
	@Test
	public void testSortAthletes() {

		Athlete at1 = mock(Athlete.class);
		Athlete at2 = mock(Athlete.class);
		Athlete at3 = mock(Athlete.class);
		Athlete at4 = mock(Athlete.class);
		Athlete at5 = mock(Athlete.class);

		when(at1.getTotalScore()).thenReturn(8902);
		when(at2.getTotalScore()).thenReturn(8815);
		when(at3.getTotalScore()).thenReturn(8815);
		when(at4.getTotalScore()).thenReturn(8603);
		when(at5.getTotalScore()).thenReturn(8603);

		// let's assume that this list was sorted in descending order
		List<Athlete> athletes = new ArrayList<Athlete>();

		athletes.add(at1);
		athletes.add(at2);
		athletes.add(at3);
		athletes.add(at4);
		athletes.add(at5);

		Map<String, int[]> spans = new HashMap<String, int[]>();

		int spanToken = 1;
		for (Athlete athlete : athletes) {
			setSpan(spans, athlete, spanToken);
			spanToken++;
		}

		assertEquals("1", getSpan(spans, at1));
		assertEquals("2-3", getSpan(spans, at2));
		assertEquals("2-3", getSpan(spans, at3));
		assertEquals("4-5", getSpan(spans, at4));
		assertEquals("4-5", getSpan(spans, at5));
	}

	/**
	 * Tests conversion from original format to internal representation
	 */
	@Test
	public void testConvertToProperUnits() {

		// let's assume that we have a original result value for running event in format min:sec
		String runningTime = "4:35.13";

		// for jumping event in meters
		String jumpLength = "8.07";

		// for throwing event in meters
		String throwLength = "68.53";

		assertThat(275.13, is(convertToProperUnits(runningTime, "running")));
		assertThat(807.0, is(convertToProperUnits(jumpLength, "jumping")));
		assertThat(68.53, is(convertToProperUnits(throwLength, "throwing")));
	}

	/**
	 * Tests conversion from internal representation to original format
	 */
	@Test
	public void testConvertToOriginalUnits() {

		// let's assume that we have a  result value for running event in internal format, that is, seconds
		double runningTime = 275.13;

		// for jumping event in centimeters
		double jumpLength = 807;

		// for throwing event in meters
		double throwLength = 68.53;

		assertThat("4:35.13", is(convertToOriginalUnits(runningTime, "running")));
		assertThat("8.07", is(convertToOriginalUnits(jumpLength, "jumping")));
		assertThat("68.53", is(convertToOriginalUnits(throwLength, "throwing")));
	}

	/**
	 * Tests conversion from dd.mm.yyyy format to yyyy-mm-dd format
	 */
	@Test
	public void testConvertToDashSeparatedYearMonthDateFormat() {

		// a date in format dd.mm.yyyy
		String originalDate = "18.12.1983";
		assertEquals("1983-12-18", convertToDashSeparatedYearMonthDayFormat(originalDate));
	}

	/**
	 * Tests converstion from yyyy-mm-dd format to dd.mm.yyyy format
	 */
	@Test
	public void testConvertToDotSeparatedDayMonthYearFormat() {

		// a date in format yyyy-mm-dd
		String originalDate = "1983-12-18";
		assertEquals("18.12.1983", convertToDotSeparetedDayMonthYearFormat(originalDate));
	}
}
