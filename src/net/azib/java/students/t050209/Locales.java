package net.azib.java.students.t050209;

import java.util.Locale;

/**
 * Locales
 *
 * @author t050209
 */
public class Locales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Locale.getDefault());
		System.out.println(Locale.getDefault().getDisplayCountry());
		// Locale.setDefault(new Locale("et", "EE"));
		
		//long t1 = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 100; i++){
			sb.append(i).append(' ');  // kiire variant
		}
		System.out.println(sb.toString());
		
		//long t = System.currentTimeMillis();
		//System.out.println(t-t1);
	}

}
