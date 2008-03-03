package net.azib.java.students.t040771.lessons;

/**
 * AnonymousDemo
 *
 * @author t040771
 */
public class AnonymousDemo {

	public static interface HelloCallback {
		public String name();
	}
	
	public static void sayHello(HelloCallback callback) {
		System.out.println("Hello, " + callback.name() + "!");
	}
	
	public static void main(String[] args) {
		sayHello(new HelloCallback() {
			public String name() {
				return System.getProperty("user.name");
			}
		});
	}
	
}
