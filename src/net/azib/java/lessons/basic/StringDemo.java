package net.azib.java.lessons.basic;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);

		String s3 = new String(new char[] {'a', 'b', 'c'});
		System.out.println(s1.equals(s3));
		System.out.println(s1 == s3);

		s3 = s3.intern();
		System.out.println(s1 == s3);

		String s4 = s3.substring(0, 1);

		String s5 = s4 + "def";
		String s6 = new StringBuilder().append(s4).append(s4).toString();

		long start = System.currentTimeMillis();
		String tmp = "";
		for (int i = 0; i < 1000; i++) {
			tmp += i;
		}
		System.out.println((System.currentTimeMillis() - start) + " ms");

		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
		}
		System.out.println((System.currentTimeMillis() - start) + " ms");
	}
}
