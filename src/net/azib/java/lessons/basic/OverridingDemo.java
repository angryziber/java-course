package net.azib.java.lessons.basic;

/**
 * OverridingDemo
 *
 * @author anton
 */
public class OverridingDemo {
	static class Inner {
		private String a;

		public Inner(String a) {
			this.a = a;
		}

		// this doesn't actually override Object.equals()
		public boolean equals(Inner that) {
			return this.a.equals(that.a);
		}
	}
	
	public static void main(String[] args) {
		Object i1 = new Inner("a");
		Object i2 = new Inner("a");
		System.out.println(i1.equals(i2));
	}
}
