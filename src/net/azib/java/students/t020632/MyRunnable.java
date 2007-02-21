package net.azib.java.students.t020632;

/**
 * MyRunnable
 *
 * @author t020632
 */
public class MyRunnable {
	
	public void runSomething(Runnable runnable){
		System.out.println("Starting runnable" );
		runnable.run();
		System.out.println("Runnable finished" );
	}
	
	public static void main(String [] args){
		
		Runnable r =  new Runnable(){
			public void run(){
				System.out.println("MyRunnable");
			}
		};
		
		new MyRunnable().runSomething(r); 
		
	}	
	
	
}
