package net.azib.java.students.t107110.homework;

/**
 * @author Eduard Shustrov
 */
public class DecathlonCalculator {
	public static void main(final String[] args) {
		try {
			new CommandLineParser(args);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
