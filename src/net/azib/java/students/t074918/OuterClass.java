package net.azib.java.students.t074918;

/**
 * OutherClass
 *
 * @author Mart Mangus
 */
public class OuterClass {

	private static String CONSTANT = "CONSTANT";
	private String outerField = "OUTER";
	private InnerClass inner = new InnerClass();
	
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
	
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
		o.inner.doSomething();
	}

}
