package net.azib.java.students.t030636.third;

import java.util.Date;

/**
 * RunSomeStuff
 *
 * @author t030636
 */
public class RunSomeStuff {
	
	public void runSomething(Runnable runnable){
		System.out.println("Starting: " + new Date());
		runnable.run();
		System.out.println("Ending: " + new Date());
	
	}

	public static void main(String[] args) {
		Runnable runnable1 = new Runnable(){
			public void run(){
				System.out.println("Running 1...");
			}	
		};
		Runnable runnable2 = new Runnable(){
			public void run(){
				System.out.println("Running 2...");
			}
		};
		
		RunSomeStuff runner = new RunSomeStuff();
		runner.runSomething(runnable1);
		runner.runSomething(runnable2);
	}
}
