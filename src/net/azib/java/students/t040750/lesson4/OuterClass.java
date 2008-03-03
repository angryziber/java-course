package net.azib.java.students.t040750.lesson4;

/**
 * OuterClass
 *
 * @author t040750
 */
public class OuterClass {
	
	private int i;
	
	private class InnerClass {
		public void inner() {
//			int i = 0;
			System.out.println(OuterClass.this.i); // i = 5
		}
	}
	
	private static class StaticInnerClass {
		
	}
	
	private InnerClass createInner() {
		return new InnerClass();
	}
	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		InnerClass inner = outer.createInner();
		
		outer.i = 5;
		inner.inner();
		
		StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
		staticInner.toString();
	}
}
