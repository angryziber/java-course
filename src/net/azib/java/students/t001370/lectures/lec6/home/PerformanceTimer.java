package net.azib.java.students.t001370.lectures.lec6.home;

import java.io.PrintStream;

/**
 * PerformanceTimer
 *
 * @author maksim
 */
/**
 * PerformanceTimer
 *
 * @author maksim
 */
public class PerformanceTimer {
	
	PrintStream output;
	
	PerformanceTimer(){
		output = System.out;
	}
	
	PerformanceTimer(PrintStream out){
		this.output = out;
	}
	
	public void runAndMeasureTime(Runnable runnable){
		long t = System.currentTimeMillis();
		
		output.print(runnable.getClass().getSimpleName() + " performance is: ");
		runnable.run();
		output.println((System.currentTimeMillis() - t) + "ms");
	}
	
	public static void main(String[] args) {
		new PerformanceTimer().runAndMeasureTime(new BufferedCopyProgram());
		new PerformanceTimer().runAndMeasureTime(new SimpelCopyProgram());
	}

}
