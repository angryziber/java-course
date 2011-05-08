package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.TestHelper;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class TestInputProcessor extends AbstractInputProcessor<Object>{
	public TestInputProcessor(Object ignored) {
		super(null);
	}

	@Override
	public List<Athlete> readAthletes() {
		return asList(createAthlete(Arrays.<String>asList(TestHelper.legalCsvLine.split(","))));
	}
}
