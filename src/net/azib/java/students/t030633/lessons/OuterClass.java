package net.azib.java.students.t030633.lessons;

/**
 * OuterClass
 * 
 * @author t030633
 */
public class OuterClass {

	private int i;

	private class InnerClass {
		public void inner() {
			System.out.println(i);
		}
	}

	private InnerClass createInner() {
		return new InnerClass();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OuterClass outer = new OuterClass();
		InnerClass inner = outer.createInner();

		outer.i = 5;
		inner.inner();

	}

}
