package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class TestInputProcessor extends AbstractInputProcessor<Object>{
	public TestInputProcessor(Object ignored) {
		super(null);
	}

	@Override
	public List<Athlete> readAthletes() {
		return asList(createAthlete(Arrays.<String>asList("Siim Susi","01.01.1976","EE","12.61","5.00","9.22","1.50","59.39","16.43","21.60","2.60","35.81","5:25.72")));
	}
}
