package net.azib.java.students.t050545.homework.sportman;

import net.azib.java.students.t050545.homework.score.PointSystem;
import net.azib.java.students.t050545.homework.score.Score;
import java.util.GregorianCalendar;

/**
 * Sportman
 * 
 * @author libricon
 */
public class Sportman implements Comparable<Sportman> {

	public Sportman(Score score, Person person) {
		this(score.getScores(), person);
	}

	public Sportman(float[] scores, Person person) {
		this.person = new Person(person.getName(),person.getCountry(),person.getBirthDay());
		points = new PointSystem(scores);
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Sportman p = (Sportman) o;
		return this.person.equals(p.getPerson()) && this.points.equals(p.getPoints());
	}

	@Override
	public String toString() {
		return person.toString() + points.toString();
	}

	@Override
	public int compareTo(Sportman o) {
		Sportman man = (Sportman) o;
		return man.getPoints().getScore() - this.getPoints().getScore();
	}

	private Person person;
	private PointSystem points;

	public static void main(String[] args) {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 7.76f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 2.20f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 5.28f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79f;

		Sportman sportman = new Sportman(arrayScore, new Person("Kirill", "RU", new GregorianCalendar(1987, 4, 29)));
		System.out.println(sportman);
	}
}
