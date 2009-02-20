package net.azib.java.students.t074918;

/**
 * Strings
 *
 * @author Mart Mangus
 */
public class Strings {
	
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = new String(new char[] {'a', 'b', 'c'});
		
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		System.out.println(s1 == s2.intern()); // Otsib sama instanc-i...
		
		String s3 = s1 + s2 + 123; // Kuidas kompillaator seda teeb:
		String s4 = new StringBuilder().append(s1).append(s2).append(123).toString();
		System.out.println(s3);
		System.out.println(s4);
		
		System.out.println(s1 == "abc"); // True sest kasutatakse sama instanc-i
		
		System.out.println("\nPerformance: ");
		
		String s = "";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			s += i;
		}
		System.out.println("  '+'-dega aeg=" + (System.currentTimeMillis() - start) + " ms");
		
		s = "";
		StringBuilder sb = new StringBuilder();
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			sb.append(i);
		}
		System.out.println("  StringBuilderiga aeg=" + (System.currentTimeMillis() - start) + " ms");
	}

}
