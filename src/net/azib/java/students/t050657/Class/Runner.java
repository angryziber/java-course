package net.azib.java.students.t050657.Class;

import java.util.Date;

/**
 * Runner
 *
 * @author t050657
 */
public class Runner{

	/**
	 * @param args
	 */
	public void runSomething(Runnable runner) {
		System.out.println("Running... Start: " + new Date());
		runner.run();
		System.out.println("Running... End: " + new Date());
	}
	
	public static void main(String[] args) {
		Runnable runnable1 = new Runnable() {
			public void run() {
				System.out.println("First running!");
			}
		};
		
		Runnable runnable2 = new Runnable() {
			public void run() {
				System.out.println("Second running!");
			}
		};
		
		Runner runner = new Runner();
		runner.runSomething(runnable1);
		runner.runSomething(runnable2);
		
	}
	
}
