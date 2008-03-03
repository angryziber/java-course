package net.azib.java.students.t030633.lessons;

/**
 * AnonymousDemo
 * 
 * @author t030633
 */
public class AnonymousDemo {

	public static interface HelloCallback {
		public String name();
	}

	// sayHello contains some other code
	public static void sayHello(HelloCallback callback) {
		System.out.println("Hello " + callback.name() + "!");
	}

	public static class HelloCallbackImpl implements HelloCallback {

		public String name() {
			return System.getProperty("user.name");
		}
		
	}

	public static void main(String[] args) {

		// implementation as a separate class
		sayHello(new HelloCallbackImpl());
		

		// implementation that declares an anonymous class
		sayHello(new HelloCallback(){
			public String name(){
				return System.getProperty("user.name");
			}
		});

	}

}
