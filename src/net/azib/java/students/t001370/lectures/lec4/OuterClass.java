package net.azib.java.students.t001370.lectures.lec4;

/**
 * innerClasses
 *
 * @author maksim
 */
public class OuterClass {
	
	private int i;
	
	private class InnerClass{
		public void inner(){
			int i=0;
			System.out.println("Inner i = " + i + ":: Outer i = " + OuterClass.this.i);
		}
	}

	private InnerClass createInner(){
		return new InnerClass();
	}
	
	private static class StaticInnerClass{
	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ie saa kuna ei ole veel outer class käimas InnerClass inner = new InnerClass();
		OuterClass outer = new OuterClass();
		InnerClass inner = outer.createInner();
		
		outer.i = 5;
		inner.inner();
		
		StaticInnerClass sInnerClass = new OuterClass.StaticInnerClass();
		
	}

}
