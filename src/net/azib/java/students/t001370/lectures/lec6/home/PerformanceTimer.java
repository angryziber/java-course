package net.azib.java.students.t001370.lectures.lec6.home;

/**
 * PerformanceTimer
 *
 * @author maksim
 */
public class PerformanceTimer {
	public static long runAndMeasureTime(Runnable runnable){
		long t = System.currentTimeMillis();
		runnable.run();
		return System.currentTimeMillis() - t;
	}
	
	
	
	/*public static void main(String[] args) {
		long t = System.currentTimeMillis();
		//do 
		System.out.println("passeed: " + (System.currentTimeMillis() - t) + " ms");
	}*/

}
