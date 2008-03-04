package net.azib.java.students.t980814.lec4;

/**
 * OuterClass
 *
 * @author dell
 */
public class OuterClass {

	private int i;
	
	private class InnerClass {
		public void inner() {
			System.out.println(i);

			// kui siin oleks juba oma muutuja "i" olemas, siis
			// välimisele "i"-le ligipääsemiseks tuleb kasutada
			// OuterClass.this.i 
		}
	}
/*
	public static class StaticInnerClass() {
		public void staticInner() {
			System.out.println("Static inner!");
		}
	}
*/	
	private InnerClass createInner() {
		return new InnerClass();
	}
	
	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		// InnerClass inner = new InnerClass(); // nii ei saa teha
		InnerClass inner = outer.createInner(); // nii saab inneri instance

		outer.i = 5;
		inner.inner();
		
//		StaticInnerClass staticInner = new StaticInnerClass();
//		StaticInnerClass staticInner2 = new OuterClass.StaticInnerClass();
	}
}
