package net.azib.java.lessons.patterns;

public class LazyDemo {
	private static String somethingImportant;

	public static synchronized String getSomethingImportant() {
		if (somethingImportant == null)
			somethingImportant = "Large text coming from slow storage";
		return somethingImportant;
	}

	public static void main(String[] args) {
		System.out.println(getSomethingImportant());
	}
}
