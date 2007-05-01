package net.azib.java.lessons.text;


/**
 * Locales
 *
 * @author anton
 */
public class Locales {
	public static void main(String[] args) {
//		Locale.setDefault(new Locale("et", "EE"));
//		System.out.println(Locale.getDefault());

		long t1 = System.nanoTime();
		String s = "";
		for (int i = 1; i <= 1000; i++) {
			s += i + " ";
		}
		System.out.println(s);
		
		long t2 = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 1000; i++) {
			sb.append(i).append(' ');
		}
		System.out.println(sb.toString());
		
		long t3 = System.nanoTime();
		System.out.println((t2-t1) + " " + (t3-t2));
	}
}
