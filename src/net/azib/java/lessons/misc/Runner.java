package net.azib.java.lessons.misc;

import java.util.Date;

/**
 * Runner
 *
 * @author anton
 */
public class Runner {
	
	public void runSomething(Runnable runnable) {
		System.out.println("Starting runnable: " + new Date());
		runnable.run();
		System.out.println("Runnable finished: " + new Date());
	}
	
	public static void main(String[] args) {
		Runnable runnable1 = new Runnable() {
			public void run() {
				System.out.println("Running some code...");
			}
		};
		Runnable runnable2 = new Runnable() {
			public void run() {
				System.out.println("Running another code...");
			}
		};
		
		Runner runner = new Runner();
		runner.runSomething(runnable1);
		runner.runSomething(runnable2);
	}
}
