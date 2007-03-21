package net.azib.java.students.t030636.v_05;

import java.util.Locale;

/**
 * Locales
 *
 * @author Martin
 */
public class Locales {
	public static void main(String[] args) {
		//Locale.setDefault(new Locale("et","EE"));
		System.out.println(Locale.getDefault().getDisplayCountry());
		System.out.println(new Locale("et", "EE"));
		
		long t1 = System.nanoTime();
		
		String s= "";
		for (int i=1; i<=100; i++) {
			s+= i + " ";
		}
		System.out.println(s);		
		
		long t2 = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=100; i++) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
		
		long t = System.nanoTime();
		System.out.println( (t2-t1) + " " + (t-t2));
	}

}
