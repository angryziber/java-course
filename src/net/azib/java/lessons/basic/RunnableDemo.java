package net.azib.java.lessons.basic;

/**
 * RunnableDemo
 *
 * @author anton
 */
public class RunnableDemo {
	
	public static void runAndTime(Runnable runnable) {
		System.out.println(runnable.getClass());
		
		long startTime = System.currentTimeMillis();
		runnable.run();
		System.out.println((System.currentTimeMillis() - startTime) + " ms");
	}
	
	public static void main(String[] args) {
		runAndTime(new Runnable() {
			public void run() {
				System.out.println("I am running!");
			}			
		});
	}
}
