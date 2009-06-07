package net.azib.java.students.t050545.homework.sport;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Person data + scores
 * 
 * @author libricon
 */
public class AthleteScore implements Comparable<AthleteScore> {

	/** person store name, country, birthday */
	private Person person;
	/** this member store results and points */
	private PointSystem points;

	/**
	 * consist of person and score
	 * @param score results in dethatlon
	 * @param person name,country...
	 */
	public AthleteScore(Score score, Person person) {
		this.person = new Person(person.getName(), person.getCountry(), person.getBirthDay());
		points = new PointSystem(score);

	}

	/**
	 * @param scores  array with all results
	 * @param person sportman's name and other data
	 */
	public AthleteScore(float[] scores, Person person) {
		this(new Score(scores), person);
	}

	/**
	 * @return the points
	 */
	public PointSystem getPoints() {
		return points; 
	}

	/**
	 * @return the person
	 */
	public Person getPerson() { 
		return person;
	}

	/**
	 * @param o other Athlete
	 * @return return true, if equals
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		AthleteScore p = (AthleteScore) o;
		return this.person.equals(p.getPerson()) && this.points.equals(p.getPoints());
	}

	/**
	 * @return name, country and birthday and results in readable form
	 */
	@Override
	public String toString() {
		return person.toString() + points.toString();
	}

	/**
	 * @param other Athlete
	 * @return other.score - this.score , what gives descending order
	 */
	@Override
	public int compareTo(AthleteScore o) {
		AthleteScore man = (AthleteScore) o;
		return man.getPoints().getScore() - this.getPoints().getScore();
	}
}
