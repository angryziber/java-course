package net.azib.java.students.t030633.homework.model;

import java.util.Date;
import java.util.EnumMap;

/**
 * Builds decathlon athletes.
 * 
 * @author t030633
 */
public class DecathlonAthleteBuilder implements AthleteBuilder {

	private Checker checker = new DecathlonChecker();
	private Calculator calculator = new AddingCalculator();

	private String name;
	private Date date;
	private String country;
	private EnumMap<Event, Double> results = new EnumMap<Event, Double>(Event.class);;

	public DecathlonAthleteBuilder() {}
	
	/**
	 * We use this constructor in tests only, hence the 'mocks'.
	 * @param mockChecker
	 * @param mockCalculator
	 */
	public DecathlonAthleteBuilder(Checker mockChecker, Calculator mockCalculator) {
		this.checker = mockChecker;
		this.calculator = mockCalculator;
	}

	public AthleteBuilder name(String name) {
		this.name = checker.checkName(name);
		return this;
	}

	public AthleteBuilder date(Date date) {
		this.date = checker.checkDate(date);
		return this;
	}

	public AthleteBuilder country(String country) {
		this.country = checker.checkCountry(country);
		return this;
	}

	public AthleteBuilder addResult(Event event, Double performance) {
		this.results.put(event, performance);
		return this;
	}

	public DecathlonAthlete build() {
		try { // Return a decathlon athlete
			return new DecathlonAthlete(name, date, country, checker.checkResults(results), calculator.calculate(results));
		}
		finally { // Reset the builder
			this.results = new EnumMap<Event, Double>(Event.class);
			this.name = null;
			this.date = null;
			this.country = null;
		}
	}

}
