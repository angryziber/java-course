package net.azib.java.students.t020281.loeng4;

/**
 * AnonymusDemo
 *
 * @author Trial
 */
public class AnonymusDemo {
	
	public static interface HelloCallBack {
		public String name();
	}
	
	public static void sayHello(HelloCallBack callback) {
		System.out.println("Hello, " + callback.name() + "!");
		
	}
	
	public static class Test implements HelloCallBack {

		public String name() {
			
			return System.getProperty("user.name");
		}
		
	}
	
	public static void main(String[] args) {
		
		// 1 variant
		sayHello(new HelloCallBack() {
			public String name() {
				
				return System.getProperty("user.name");
			}
		});
		// 2 variant
		HelloCallBack helloCallBack = new HelloCallBack() {
			
			public String name() {
				
				return System.getProperty("user.name");
			}	
			
		};
		
		sayHello(helloCallBack);
	}
}
