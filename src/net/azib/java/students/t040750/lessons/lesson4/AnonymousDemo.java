package net.azib.java.students.t040750.lessons.lesson4;

/**
 * AnonymousDemo
 *
 * @author t040750
 */
public class AnonymousDemo {
	
	public static interface HelloCallback {
		public String name();
	}
	
	public static void sayHello(HelloCallback callback) {
		System.out.println("Hello, " + callback.name() + "!");
	}
	/*
	public static class Test implements HelloCallback{ //inner class
		public String name() {
			return System.getProperty("user.name");
		}
	}
	
	public static void main(String[] args) { 
		sayHello(new Test());
	}
	*/
	
	public static void main(String[] args) { //anonüümne klass
		sayHello(new HelloCallback() {
			public String name() {
				return System.getProperty("user.name");
			}
		});
	}
}
