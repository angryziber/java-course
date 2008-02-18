package net.azib.java.lessons;

/**
 * StringDemo
 *
 * @author anton
 */
public class StringDemo {
	
	static void printStuff(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
	
	public static void main(String[] args) {
		String s1 = "sa";
		String s2 = s1 + "";
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1 ; i <= 10; i++) {
			sb.append(i).append(' ');
		}
		
		printStuff(args);
		
		System.out.printf("Result: %d and %s", 5, sb);
	}
}
