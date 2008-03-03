package net.azib.java.students.t040771.lessons;

/**
 * OuterClass
 *
 * @author t040771
 */
public class OuterClass {

	private int i;
	
	private class InnerClass {
		public void inner() {
			int i = 0;
			System.out.println(i);
			System.out.println(OuterClass.this.i);
		}
	}
	
	private static class StaticInnerClass {
		public void inner() {
			System.out.println("Static");
		}		
	}
	
	private InnerClass createInner() {
		return new InnerClass();
	}
	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		InnerClass inner = outer.createInner();
		
		StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
		staticInner.inner();
		
		outer.i = 5;
		inner.inner();
	}
	
}
