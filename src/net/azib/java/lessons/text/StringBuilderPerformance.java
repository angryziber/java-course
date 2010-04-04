package net.azib.java.lessons.text;

/**
 * StringBuilderPerformance
 *
 * @author anton
 */
public class StringBuilderPerformance {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();		
		stringConcat();
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		stringBuilder();		
		System.out.println(System.currentTimeMillis() - start);
	}

	private static void stringConcat() {
		String s = "";
		for (int i = 0; i < 10000; i++) {
			s += "a";
		}
	}
	
	private static void stringBuilder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append("a");
		}
		sb.toString();
	}

}
