package net.azib.java.lessons.basic;

/**
 * Strings
 *
 * @author anton
 */
public class Strings {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = new String(new char[] {'a', 'b', 'c'});
		
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		System.out.println(s1 == "abc");
		System.out.println(s1 == s2.intern());
		
		String s3 = s1 + s2 + 123;
		String s4 = new StringBuilder().append(s1).append(s2).append(123).toString();
		System.out.println(s3);
		System.out.println(s3.equals(s4));
		
		long start = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 10000; i++) { 
			s += i;
		}
		System.out.println("String concatenation: t=" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) { 
			sb.append(i);
		}
		System.out.println("StringBuilder: t=" + (System.currentTimeMillis() - start));
		
		System.out.println(s.equals(sb.toString()));
	}
}
