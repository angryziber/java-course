package net.azib.java.students.t020281.loeng4;

/**
 * OuterClass
 *
 * @author Trial
 */
public class OuterClass {
	private int i;
	
	private class InnerClass {
		public void inner(){
			int i = 0;
			System.out.println(OuterClass.this.i);
			System.out.println(i);
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
		
	}
}
