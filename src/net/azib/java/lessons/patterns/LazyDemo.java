package net.azib.java.lessons.patterns;

/**
 * LazyDemo
 *
 * @author anton
 */
public class LazyDemo {
	private String meaningOfEverything;
	
	private synchronized String getMeaningOfEverything() {		
		if (meaningOfEverything == null) {
			meaningOfEverything = "42";
		}
		return meaningOfEverything;
	}

	@Override
	public String toString() {
		return getMeaningOfEverything();
	}


	public static void main(String[] args) {
		LazyDemo demo = new LazyDemo();
		System.out.println(demo);
	}
}
