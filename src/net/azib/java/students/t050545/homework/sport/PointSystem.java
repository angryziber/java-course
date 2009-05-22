package net.azib.java.students.t050545.homework.sport;

/**
 * PointSystem
 * 
 * @author libricon
 */
public class PointSystem {

	/**
	 * Takes results as a array in special order It is good to use Disciline
	 * enumeration to fill array
	 * 
	 * @param bareResults
	 *            array size to Decathlon should be 10
	 */
	public PointSystem(float[] bareResults) {
		results = (float[]) bareResults.clone();
		scores = new int[results.length];
		calculatePoints();
		calculatePointForTrack();
	}

	/**
	 * This constructor use special class for result representation
	 * 
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
		Jug100m(25.4347f, 18f, 1.81f) {
			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((b - result), c));
			}

		},
		/** LongJump */
		LongJump(0.14354f, 220f, 1.4f) {
			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((100 * result - b), c));
			}

		},
		/** ShotPut */
		ShotPut(51.39f, 1.5f, 1.05f) {

			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((result - b), c));
			}

		},
		/** HighJump */
		HighJump(0.8465f, 75f, 1.42f) {

			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((100 * result - b), c));
			}

		},
		/** Jug400m */
		Jug400m(1.53775f, 82f, 1.81f) {
			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((b - result), c));
			}

		},
		/** Hurdles110m */
		Hurdles110m(5.74352f, 28.5f, 1.92f) {
			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((b - result), c));
			}

		},
		/** DiscusThrow */
		DiscusThrow(12.91f, 4f, 1.1f) {
			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((result - b), c));
			}

		},
		/** PoleVault */
		PoleVault(0.2797f, 100f, 1.35f) {
			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((100 * result - b), c));
			}

		},
		/** JavelinThrow */
		JavelinThrow(10.14f, 7f, 1.08f) {
			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((result - b), c));
			}

		},
		/** Jug1500m */
		Jug1500m(0.03768f, 480f, 1.85f) {
			int returnPoints(float result) {
				return (int) Math.round(a * Math.pow((b - result), c));
			}

		};

		/**
		 * To initialise each discipline need 3 constants to calculate points..
		 * A B C
		 * 
		 * @param a
		 *            first constant
		 * @param b
		 *            second constant
		 * @param c
		 *            third constant
		 */
		Discipline(float a, float b, float c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		final float a;
		final float b;
		final float c;

		/**
		 * This method calculate score for discipline
		 * 
		 * @param result
		 *            Sportman's result in seconds, meters.... depend on
		 *            descipline
		 * @return score points according to results
		 */
		abstract int returnPoints(float result);
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

	/**
	 * @return the results
	 */
	public float[] getResults() {
		return (float[]) results.clone();
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
		return (int[]) scores.clone();
	}

	/** Raw result in meters, second results */
	private float[] results;
	/** Total score */
	private int score = 0;
	/** Scores for each discipline in points */
	private int[] scores;

	/**
	 * This method compares two PointSystem objects
	 * 
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
	 * 
	 * @return table: result and score
	 * */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		for (float f : results)
			buffer.append(f + "\t");
		buffer.append("\n");
		for (int i : scores)
			buffer.append(i + "\t");
		buffer.append("\n-----------------------------------------------------------------------------\n");
		buffer.append("Total score: " + score + "\n\n");
		return buffer.toString();
	}

	/** Main method for control class work
	 * @param args command line 
	 */
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
		System.exit(0);

	}
}
