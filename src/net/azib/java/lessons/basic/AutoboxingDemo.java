package net.azib.java.lessons.basic;

public class AutoboxingDemo {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int j = 0;
		for (int i = 0; i < 10000000; i++) {
			j++;
		}
		System.out.println("it took " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(j);

		start = System.currentTimeMillis();
		Integer k = 0;
		for (Integer i = 0; i < 10000000; i++) {
			k++;
		}
		System.out.println("it took " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(k);

		int i = 5;
		Integer i1 = i;
		Integer i2 = i;
		System.out.println(i1 == i2);

		i = 200;
		i1 = i; // new Integer(i)
		i2 = i; // new Integer(i)
		System.out.println(i1 == i2);  // if they are the same
		System.out.println(i1.equals(i2)); // if their values are equal
		System.out.println(i1.intValue() == i2.intValue());
	}
}
