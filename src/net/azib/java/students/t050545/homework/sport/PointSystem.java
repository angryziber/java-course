package net.azib.java.students.t050545.homework.sport;

/**
 * PointSystem class hold sportman results and total result
 * 
 * @author libricon
 */
public class PointSystem {

	/** Raw result */
	private float[] results;
	/** Total score */
	private int score = 0;
	/** Scores for each discipline in points */
	private int[] scores;

	/**
	 * @param bareResults
	 */
	public PointSystem(float[] bareResults) {
		results = (float[]) bareResults.clone();
		scores = new int[results.length];
		calculatePoints();
	}

	/**
	 * @param score
	 */
	public PointSystem(Score score) {
		this(score.getScores());

	}

	/**
	 * @return the results
	 */
	public float[] getResults() {
		return (float[]) results.clone();
	}

	/**
	 * @return the total score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the scores
	 */
	public int[] getScores() {
		return (int[]) scores.clone();
	}

	/**
	 * calculate points for each discipline in array
	 */
	private void calculatePoints() {

		for (Discipline dis : Discipline.values()) {
			scores[dis.ordinal()] = dis.returnPoints(results[dis.ordinal()]);
		}
		for (int i : scores)
			score += i;
	}

	/**
	 * @return true, if total score and scores the same
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		PointSystem p = (PointSystem) o;
		return this.score == p.getScore() && this.scores.equals(p.scores);
	}

	/**
	 * @return table: result and score
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		for (float f : results) {
			float k = (int) (100 * f);
			buffer.append(k / 100 + "\t");
		}
		buffer.append("\n");
		for (int i : scores)
			buffer.append(i + "\t");
		buffer.append("\n-----------------------------------------------------------------------------\n");
		buffer.append("Total score: " + score + "\n\n");
		return buffer.toString();
	}

}
