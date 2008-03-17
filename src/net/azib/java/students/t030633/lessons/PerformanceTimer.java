package net.azib.java.students.t030633.lessons;

// import net.azib.java.lessons.io.FileCopier;

/**
 * PerformanceTimer
 * 
 * @author t030633
 */
public class PerformanceTimer {
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		// do, put things here
		// FileCopier copier = new SimpleCopyProgram();
		// copier.copy(new File(".classpath"), new File("/tmp/foo"));
		System.out.println("Passed: " + (System.currentTimeMillis() - t) + " ms");
	}
}
