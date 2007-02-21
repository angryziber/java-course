package net.azib.java.students.t030656;

import java.util.Date;

/**
 * Runner
 *
 * @author t030656
 */
public class Runner {
	 public void runSomething(Runnable runnable){
		 System.out.println("/***************************");
		 System.out.println("Starting: " + new Date());
		 runnable.run();
		 System.out.println("Finished: " + new Date());
		 
	 }
	 
	 public static void main(String[] args){
		 Runnable runnable1 = new Runnable(){
			 public void run(){
				 System.out.println("Running some code");
			 }
		 };
		 Runnable runnable2 = new Runnable(){
			 public void run(){
				 System.out.println("Running some other code");
			 }
		 };
		 
		 Runner runner = new Runner();
		 runner.runSomething(runnable1);
		 runner.runSomething(runnable2);
	 }
}
