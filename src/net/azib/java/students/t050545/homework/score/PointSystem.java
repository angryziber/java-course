package net.azib.java.students.t050545.homework.score;

import net.azib.java.students.t050545.homework.score.discipline.DiscusThrow;
import net.azib.java.students.t050545.homework.score.discipline.HighJump;
import net.azib.java.students.t050545.homework.score.discipline.Hurdles110m;
import net.azib.java.students.t050545.homework.score.discipline.JavelinThrow;
import net.azib.java.students.t050545.homework.score.discipline.Jug100m;
import net.azib.java.students.t050545.homework.score.discipline.Jug1500m;
import net.azib.java.students.t050545.homework.score.discipline.Jug400m;
import net.azib.java.students.t050545.homework.score.discipline.LongJump;
import net.azib.java.students.t050545.homework.score.discipline.PoleVault;
import net.azib.java.students.t050545.homework.score.discipline.ShotPut;

/**
 * PointSystem
 * 
 * @author libricon
 */
public class PointSystem {

	public PointSystem(float[] bareResults) {
		results = (float[]) bareResults.clone();
		scores = new int[results.length];
		calculatePoints();
		calculatePointForTrack();
	}
	
	public PointSystem(Score score){
		this(score.getScores());
		
	}

	private void calculatePoints() {
		scores[0] = Jug100m.returnPoints(results[0]);
		scores[1] = LongJump.returnPoints(results[1]);
		scores[2] = ShotPut.returnPoints(results[2]);
		scores[3] = HighJump.returnPoints(results[3]);
		scores[4] = Jug400m.returnPoints(results[4]);
		scores[5] = Hurdles110m.returnPoints(results[5]);
		scores[6] = DiscusThrow.returnPoints(results[6]);
		scores[7] = PoleVault.returnPoints(results[7]);
		scores[8] = JavelinThrow.returnPoints(results[8]);
		scores[9] = Jug1500m.returnPoints(results[9]);
	}

	private int calculatePointForTrack() {
		for (int i : scores)
			score += i;
		return score;
	}

	/**
	 * @return the results
	 */
	public float[] getResults() {
		return results;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the scores
	 */
	public int[] getScores() {
		return scores;
	}

	private float[] results;
	private int score = 0;
	private int[] scores;

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

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		for (float f : results)
			buffer.append(f + "\t");
		buffer.append("\n");
		for (int i : scores)
			buffer.append(i + "\t");
		buffer.append("\n-----------------------------------------------------------------------------\n");
		buffer.append("Total score: " + score +"\n\n");
		return buffer.toString();
	}

	
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

		PointSystem points = new PointSystem(arrayScore);
		System.out.println(points);
	}
}



