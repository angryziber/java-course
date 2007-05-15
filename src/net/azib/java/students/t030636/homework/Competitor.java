package net.azib.java.students.t030636.homework;

/**
 * Competitor
 *
 * @author Martin
 */
public class Competitor implements Comparable<Object> {
	public String name;
	public Integer score;
	public  String [] results = new String[10] ;
	public int [] resultsAsPoints = new int[10];
	public String nationality;
	public String born;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String[] getResults() {
		return results;
	}
	public void setResults(String[] results) {
		this.results = results;
	}
	public int[] getResultsAsPoints() {
		return resultsAsPoints;
	}
	public void setResultsAsPoints(int[] resultsAsPoints) {
		this.resultsAsPoints = resultsAsPoints;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getBorn() {
		return born;
	}
	public void setBorn(String born) {
		this.born = born;
	}

	@Override
	public int compareTo(Object anotherCompetitor) {
		if(!(anotherCompetitor instanceof Competitor))
			throw new ClassCastException("Another Competitor object expected.");
		int score = ((Competitor) anotherCompetitor).getScore();
		return score -this.getScore();
	
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Competitor) {
			Competitor compareComp = (Competitor) o;
			return compareComp.score == this.score;
		}
		else
			return false;
	}
	@Override
	public int hashCode() {
		return score;
	}
	@Override
	public String toString() {
		String s = this.score + " points for: " +this.name +","+this.born+","+this.nationality;
		for (String event: this.results)
			s = s + "," + event;
		return s;
	}

}
