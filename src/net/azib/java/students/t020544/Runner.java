package net.azib.java.students.t020544;

import java.util.Date;

/**
 * Runnar
 * 
 * @author Julija Kondratjeva
 */
public class Runner {

	public void runSomething(Runnable runnable) {
		System.out.println("Starting runnable: " + new Date());
		runnable.run();
		System.out.println("Runnable finished: " + new Date());
	}

	public static void main(String[] args) {
		Runnable runnable1 = new Runnable(){
			public void run(){
				System.out.println("Running some code");
			}
		};
		
		Runnable runnable2 = new Runnable(){
			public void run(){
				System.out.println("Running another code");
			}
		};
		
		Runner runner =new Runner();
		runner.runSomething(runnable1);
		runner.runSomething(runnable2);
		
		
	}

}
