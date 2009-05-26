package net.azib.java.students.t050545.homework.sport;

/**
 * PointSystem class hold sportman results, calculate points for each discipline 
 * and total result
 * @author libricon
 */
public class PointSystem {

	/**
	 * Takes results as a array in special order It is good to use Disciline
	 * enumeration to fill array
	 * 
	 * @param bareResults array size to Decathlon should be 10
	 */
	public PointSystem(float[] bareResults) {
		results = (float[]) bareResults.clone();
		scores = new int[results.length];
		calculatePoints();
		calculatePointForTrack();
	}

	/**
	 * This constructor use special class for result representation
	 * score check result in addition
	 * @param score
	 */
	public PointSystem(Score score) {
		this(score.getScores());

	}

	/**
	 * Disciplines enumeration each discipline have own method to calculate
	 * points and constants. method name is
	 * <code>returnPoints(float results)</code> return type is integer
	 * <pre>Points = INT(A*(B-P)C) for track events
            Points = INT(A*(P-B)C) for field events</pre>
	 * @author libricon
	 */
	public enum Discipline {

		/** Jug100m */
		Race_100m(25.4347f, 18f, 1.81f, 1),
		/** LongJump */
		Long_jump(0.14354f, 220f, 1.4f, -1),
		/** ShotPut */
		Shot_put(51.39f, 1.5f, 1.05f, -1),
		/** HighJump */
		High_jump(0.8465f, 75f, 1.42f, -1),
		/** Jug400m */
		Race_400m(1.53775f, 82f, 1.81f, 1),
		/** Hurdles110m */
		Hurdles_110m(5.74352f, 28.5f, 1.92f, 1),
		/** DiscusThrow */
		Discus_throw(12.91f, 4f, 1.1f, -1),
		/** PoleVault */
		Pole_vault(0.2797f, 100f, 1.35f, -1),
		/** JavelinThrow */
		Javelin_throw(10.14f, 7f, 1.08f, -1),
		/** Jug1500m */
		Race_1500m(0.03768f, 480f, 1.85f, 1);

		/**
		 * To initialise each discipline need 3 constants to calculate points..
		 * A B C
		 * @param a first constant
		 * @param b second constant
		 * @param c third constant
		 * @param koef determine specific calculation for each discipline all races 1, polevault -1 ....
		 */
		Discipline(float a, float b, float c, int koef) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.koef = koef;
		}
		
		/** this rotate (B-P) or (P-B) in method <code>returnPoints()</code> */
		final int koef;
		final float a;
		final float b;
		final float c;

		/**
		 * This method calculate score for discipline
		 * 
		 * @param result Sportman's result in seconds, meters.... depend on descipline
		 * @return score points according to results
		 */
		int returnPoints(float result) {
			return (int) Math.round(a * Math.pow((koef*(b - result)), c));
		}

	}

	/**
	 * @return the results
	 */
	public float[] getResults() {
		return (float[]) results.clone();
	}

	/** Return total score for  sportman in decathlon
	 * @return the score
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
	 * Method calculate points for each discipline in array, order the same, as
	 * in enumerations
	 * 
	 */
	private void calculatePoints() {

		for (Discipline dis : Discipline.values()) {
			scores[dis.ordinal()] = dis.returnPoints(results[dis.ordinal()]);
		}
	}

	/**
	 * Method sums scores and return total score for one sportman
	 * 
	 * @return total score
	 */
	private int calculatePointForTrack() {
		for (int i : scores)
			score += i;
		return score;
	}
	

	/** Raw result in meters, second results */
	private float[] results;
	/** Total score */
	private int score = 0;
	/** Scores for each discipline in points */
	private int[] scores;

	/**
	 * This method compares two PointSystem objects
	 * @return true is total score and scores the same
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
	 * Method returns string with result and score in pair
	 * @return table: result and score
	 * */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		for (float f : results){
			float k = (int)(100*f);
			buffer.append(k/100 + "\t");
		}
		buffer.append("\n");
		for (int i : scores)
			buffer.append(i + "\t");
		buffer.append("\n-----------------------------------------------------------------------------\n");
		buffer.append("Total score: " + score + "\n\n");
		return buffer.toString();
	}


		/**
		 * Test method
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
			
			Score score = new Score(arrayScore);
			
			PointSystem points = new PointSystem(score.getScores());
			System.out.println(points);

			
		}

	
}
