package net.azib.java.students.t030633.homework.Model;

import java.util.Date;
import java.util.EnumMap;

/**
 * Builds an instance of Athlete.
 * 
 * @author t030633
 */
public class DecathlonAthleteBuilder implements AthleteBuilder {

	private Checker checker;
	private Calculator calculator;

	private String name;
	private Date date;
	private String country;
	private EnumMap<Event, Double> results;

	public DecathlonAthleteBuilder(Checker checker, Calculator calculator) {
		this.checker = checker;
		this.calculator = calculator;
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

	public AthleteBuilder results(EnumMap<Event, Double> results) {
		this.results = checker.checkResults(results);
		return this;
	}

	public DecathlonAthlete build() {
		return new DecathlonAthlete(name, date, country, results, calculator.calculate(results));
	}

}
