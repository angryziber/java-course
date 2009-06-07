package net.azib.java.students.t050545.homework.sport;

/**
 * Hold athlete scores
 * 
 * @author libricon
 */
public class Score {

	/**
	 * @param scores array with result
	 */
	public Score(float[] scores) {
		this.scores = new float[Discipline.values().length];
		putScores(scores);
	}

	/**
	 *  to fill array it's need to run <code> putScores(float[] rawResults) </code>
	 */
	public Score() {
		scores = new float[Discipline.values().length];
	}

	/**
	 * Method store result in own array and convert all value to common Si
	 * system
	 * @param rawResults results according to CSV file
	 */
	public void putScores(float[] rawResults) {
		for (Discipline dis : Discipline.values()) {
			if (dis == Discipline.Long_jump) {
				scores[dis.ordinal()] = 100 * rawResults[dis.ordinal()];
			}
			else if (dis == Discipline.High_jump) {
				scores[dis.ordinal()] = 100 * rawResults[dis.ordinal()];
			}
			else if (dis == Discipline.Pole_vault) {
				scores[dis.ordinal()] = 100 * rawResults[dis.ordinal()];
			}
			else {
				scores[dis.ordinal()] = rawResults[dis.ordinal()];
			}
		}
	}

	/**
	 * Method return cloned object
	 * @return results
	 */
	public float[] getScores() {
		return (float[]) scores.clone();
	}

	/** Array with athlete results */
	private float[] scores;

}
