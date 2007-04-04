package net.azib.java.students.t010687;

import java.util.Locale;

/**
 * Locales
 *
 * @author t010687
 */
public class Locales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Locale.getDefault());
		
		long t1 = System.currentTimeMillis();
		String s = "";
		for(int i=1;i<=1000;i++) {
			s += i + " ";
		}
		long t2 = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=1000;i++) {
			sb.append(i).append(' ');
		}
		long t3 = System.currentTimeMillis();
		
		System.out.println(sb.toString());
		System.out.println((t2 - t1) + " " + (t3-t2));
	}


}
