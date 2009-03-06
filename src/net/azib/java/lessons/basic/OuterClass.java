package net.azib.java.lessons.basic;

/**
 * InnerClassDemo
 *
 * @author anton
 */
public class OuterClass {
	private static final String CONSTANT = "CONSTANT";
	
	private String outerField = "OUTER"; 
	InnerClass inner = new InnerClass();
	
	public class InnerClass {
		public void doSomething() {
			System.out.println(outerField);
		}
	}
	
	public static class StaticInnerClass {
		public void doSomething() {
			System.out.println(CONSTANT);
		}
	}
}
