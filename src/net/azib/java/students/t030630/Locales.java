package net.azib.java.students.t030630;

import java.util.Locale;

/**
 * Locales
 *
 * @author Kasutaja
 */
public class Locales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(new Locale("et", "EE"));
		System.out.println(Locale.getDefault());
		long t1 = System.currentTimeMillis();
		String s = " ";
		for(int i=1; i<=1000; i++){
			s += i + " ";	
		}
		//System.out.println(s);
		long t2 = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=1000; i++){
			sb.append(i).append(' ');	
		}
		//System.out.println(sb.toString());
		long t = System.currentTimeMillis();
		System.out.println((t2-t1) + "  " + (t-t2));

	}

}
