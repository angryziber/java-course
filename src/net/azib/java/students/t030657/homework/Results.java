package net.azib.java.students.t030657.homework;

/**
 * @author Karina
 * public class Results
 * In this class comparing of the results is implemented
 * According to the result the sequence of the positions is set
 *
 */

public class Results implements Comparable<Results> {
	
	private int id;
	private String position;
	private Athlete athlete;
	private double[] results = new double[10];

	Results(String line) {
	}
	
	Results(Athlete athlete) {
		this.athlete=athlete;
	}
	
	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	Athlete getAthlete() {
		return athlete;
	}

	void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	void setResult(Event ev, double result) {
		this.results[ev.ordinal()] = result;
	}

	double getResult(Event ev) {
		return results[ev.ordinal()];
	}
	
	public int compareTo(Results o) {
		int me =getScore();
		int she = o.getScore();
		if (me < she) return -1;
		if (me > she) return 1;
		return 0;
	}
	
	int getScore() {
		int score = 0;
		for(Event ev: Event.values())
			score += ev.getScore(results[ev.ordinal()]);
		return score;
	}

	void setPosition(String position) {
		this.position=position;
	}
	
	void setPosition(int position) {
		this.position=Integer.toString(position);
	}
	
	String getPosition() {
		return position;
	}
}
