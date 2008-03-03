package net.azib.java.students.t030611;

/**
 * OuterClass
 *
 * @author t030611
 */
public class OuterClass {
	private int i;
	private class InnerClass{
		public void Inner(){
			int i=0;
			System.out.println(OuterClass.this.i);
		}
	}
	
	private InnerClass createInner(){
		return new InnerClass();
	}
	
	public static void main(String[] args) {
		OuterClass outer=new OuterClass();
		InnerClass inner=outer.createInner();
		
		outer.i=5;
		inner.Inner();
		
	}
}
