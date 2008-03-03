package net.azib.java.students.t040719.lessons;

import java.util.Properties;

/**
 * AnonymDemo
 *
 * @author t040719
 */
public class AnonymDemo {
	public static interface HelloCallback{
		public String name();
	}
	
	public static void sayHello(HelloCallback callback){
		System.out.println("Hello, "+callback.name() + "!");
	}
	//alternatiiv
	public static class Test implements HelloCallback{
		public String name() {
			return System.getProperty("user.name");
		}
		
	}
	
	public static void main(String[] args) {
		sayHello(new HelloCallback(){
			public String name(){
				return System.getProperty("user.name");
			}
		});
		
		//alternatiivne realisatsioon
		sayHello(new Test());
		
		
	}
}
