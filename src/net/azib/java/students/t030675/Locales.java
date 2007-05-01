package net.azib.java.students.t030675;

/**
 * Locales
 *
 * @author t030675
 */


public class Locales {
	public static void main(String[] args) {
		//System.out.println(new Locale("et","EE"));
		
		long t1 = System.nanoTime();
		
		String s = "";
		
		for (int i = 0; i < 1000; i++) {
			s += i + " ";
		}
		System.out.println(s);
		
		long t2 = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 1000; i++) {
			sb.append(i).append(' ');
		}
		System.out.println(sb.toString());
	
		long t = System.nanoTime();
		
		System.out.println((t2 - t1) + " " + (t-t2));
		
	}
}
