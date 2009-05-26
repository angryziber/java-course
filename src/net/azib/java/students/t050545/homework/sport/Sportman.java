package net.azib.java.students.t050545.homework.sport;


import java.util.GregorianCalendar;

/**
 * Sportman
 * 
 * @author libricon
 */
public class Sportman implements Comparable<Sportman> {

	/** Sportman consist of person and score
	 * @param score object with sportman's results
	 * @param person object contain sportman's name and other data
	 */
	public Sportman(Score score, Person person) {
		this.person = new Person(person.getName(), person.getCountry(), person.getBirthDay());
		points = new PointSystem(score);
		
	}

	/**
	 * @param scores array with all results
	 * @param person object contain sportman's name and other data
	 */
	public Sportman(float[] scores, Person person) {
		this(new Score(scores), person);
	}

	/**
	 * @return the points
	 */
	public PointSystem getPoints() {
		return points;                         // think about clone() !
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {			      // person cann't be modified
		return person;
	}

	/**
	 * This Method compare 2 objects, if all field are equal, returns true
	 * 
	 * @param o The second object to compare
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
		Sportman p = (Sportman) o;
		return this.person.equals(p.getPerson()) && this.points.equals(p.getPoints());
	}

	/**
	 * This function returns String, with information about the Sportman
	 * 
	 * @return Return name, country and birthday and results in readable form
	 */
	@Override
	public String toString() {
		return person.toString() + points.toString();
	}

	/**
	 * This method allowed to sort Sportmans by score in TreeSet collection
	 * 
	 * @param o Second sportman
	 * @return other.score - this.score , what gives descending order
	 */
	@Override
	public int compareTo(Sportman o) {
		Sportman man = (Sportman) o;
		return man.getPoints().getScore() - this.getPoints().getScore();
	}

	/** person store name, country, birthday */
	private Person person;
	/** this member store results and points */
	private PointSystem points;

	/**
	 * Main function, only for test purposes
	 * 
	 * @param args command line arguments
	 */
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
		System.exit(0);
	}
}
