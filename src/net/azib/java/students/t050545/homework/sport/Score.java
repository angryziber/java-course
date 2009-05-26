package net.azib.java.students.t050545.homework.sport;

import net.azib.java.students.t050545.homework.sport.PointSystem.Discipline;

/**
 * Score class hold scores in array, it convert values to SI system
 *
 * @author libricon
 */
public class Score {
	
	/** Constructor takes array of raw results and store all result inside
	 * @param scores
	 */
	public Score(float[] scores){
		this.scores = new float[Discipline.values().length];
		putScores(scores);	
	}
	
	/** Just initialise array, to fill array it's neede to run 
	 * <code> public void putScores(float[] rawResults) </code>
	 */
	public Score(){
		scores = new float[Discipline.values().length];
	}
	
	/**  Method store result in own array and convert all value to common Si system
	 *   @param rawResults results according to CSV file
	 */
	public void putScores(float[] rawResults){
		for (Discipline dis : Discipline.values()) {
			if(dis == Discipline.Long_jump){
				scores[dis.ordinal()] = 100*rawResults[dis.ordinal()];
			} else if(dis == Discipline.High_jump){
				scores[dis.ordinal()] = 100*rawResults[dis.ordinal()];
			} else if(dis == Discipline.Pole_vault){
				scores[dis.ordinal()] = 100*rawResults[dis.ordinal()];
			} else {
				scores[dis.ordinal()] = rawResults[dis.ordinal()];
			}
		}
	}

	/** Method return cloned object
	 * @return new array with results 
	 */
	public float[] getScores(){
		return (float[])scores.clone();
	}
	
	/** Array with sportman results */
	private float[] scores;

}
