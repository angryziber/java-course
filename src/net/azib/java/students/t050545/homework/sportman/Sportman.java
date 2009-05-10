package net.azib.java.students.t050545.homework.sportman;

import net.azib.java.students.t050545.homework.score.PointSystem;
import net.azib.java.students.t050545.homework.score.Score;
import java.util.GregorianCalendar;

/**
 * Sportman
 *
 * @author libricon
 */
public class Sportman {
	
    public Sportman(Score score, Person person){
    	this.person = person;
    	points = new PointSystem(score);
    }
    
    public Sportman(float[] scores, Person person){
    	this.person = person;
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
	public String toString(){
		return person.toString() + points.toString();
	}
	
	private Person person;
	private PointSystem points;
	
	
	public static void main(String[] args) {
		float[] arrayScore = new float[10];
		arrayScore[0] = 9.69f;
		arrayScore[1] = 8.95f;
		arrayScore[2] = 23.12f;
		arrayScore[3] = 2.45f;
		arrayScore[4] = 43.18f;
		arrayScore[5] = 12.87f;
		arrayScore[6] = 74.08f;
		arrayScore[7] = 6.14f;
		arrayScore[8] = 98.48f;
		arrayScore[9] = 206f;

		Sportman sportman = new Sportman(arrayScore,new Person("Kirill", "RU",  new GregorianCalendar(1987, 4, 29)));
		System.out.println(sportman);
	}
}
