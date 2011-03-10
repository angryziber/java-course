package net.azib.java.lessons.basic;

public class RunnableDemo {

	public static void time(Runnable code) {
		long start = System.nanoTime();
		code.run();
		System.out.println("it took " + (System.nanoTime() - start) + " ns");
	}

	public static void main(String[] args) {
		String[] s = new String[] {"a", "b", "c"};

		Runnable code = new Runnable() {
			public void run() {
				System.out.println("Hello World!");
			}
		};
		System.out.println(code.toString());

		time(code);
	}
}
