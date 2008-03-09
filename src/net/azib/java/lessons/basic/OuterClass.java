package net.azib.java.lessons.basic;

/**
 * InnerClasses
 *
 * @author anton
 */
public class OuterClass {
	
	private int i;
	
	private class InnerClass {
		public void inner() {
			@SuppressWarnings("unused")
			int i = 0;
			System.out.println(OuterClass.this.i);
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
		
		@SuppressWarnings("unused")
		StaticInnerClass staticInner = new OuterClass.StaticInnerClass();
	}

}
