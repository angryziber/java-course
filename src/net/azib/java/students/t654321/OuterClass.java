package net.azib.java.students.t654321;

/**
 * OuterClass
 *
 * @author t999902
 */
public class OuterClass {
	
	private int i;
	
	private class InnerClass{
		public void inner(){
			System.out.println(OuterClass.this.i);
		}

	}
	
	private InnerClass createInner(){
		return new InnerClass();
	}

	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		InnerClass inner = outer.createInner();
		
		outer.i = 5;
		inner.inner();
	}
}
