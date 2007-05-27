package net.azib.java.students.t010691.homework;

/**
 * OutputDataScr
 * 
 * Console output.
 * Results are printed to the screen.
 *
 * @author Ilja Lutov
 */
class OutputDataScr extends OutputData {

	/**
	 * Outputs competitor data to a screen
	 * 
	 * @see net.azib.java.students.t010691.homework.OutputData#write(Competitor)
	 */
	public void write(Competitor competitor, String place) {
		String[] data = competitor.toStringArray();

		System.out.println(
			place + " | " +
			data[0] + " | " +
			data[1] + " | " +
			data[2] + " | " +
			data[3] + " | " +
			data[4] + " | " +
			data[5] + " | " +
			data[6] + " | " +
			data[7] + " | " +
			data[8] + " | " +
			data[9] + " | " +
			data[10] + " | " +
			data[11] + " | " +
			data[12] + " | " +
			data[13]
		);
	}

	/**
	 * Does nothing
	 * 
	 * @see net.azib.java.students.t010691.homework.OutputData#close()
	 */
	public void close() {
		System.out.println("\nDone.\n");
	}
}
