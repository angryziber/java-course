package net.azib.java.students.t654321;

/**
 * AnonymousDemo
 *
 * @author t999902
 */
public class AnonymousDemo {

	public static interface HelloCallBack{
		public String name();
	}
	/*Ei pea enam arvutama. Saame implementeerida name
	meetodit erinevalt.*/
	public static void sayHello(HelloCallBack cb) {
		System.out.println("Hello " + cb.name() + "'");
	}
	
	public static void main(String[] args) {
		sayHello(new HelloCallBack() {
			public String name() {
				return System.getProperty("user.name");
			}
		});
	}
}
