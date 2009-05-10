package net.azib.java.students.t050545.homework.score;

/**
 * Score
 *
 * @author libricon
 */
public class Score {
	public Score(float[] scores){
		this.scores = (float[])scores.clone();
		
	}
	
	public float[] getScores(){
		return scores;
	}
	private float[] scores;

}
