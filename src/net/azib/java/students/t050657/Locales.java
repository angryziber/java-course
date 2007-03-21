package net.azib.java.students.t050657;

import java.util.Locale;

/**
 * Formatting
 *
 * @author t050657
 */
public class Locales {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("et", "EE"));
		System.out.println(Locale.getDefault());

		
		long strL = System.nanoTime();
		String str = "";
		for(int i=0; i<=10000; i++) {
			str += i + " " ; 
		}
		//System.out.println(str);
		long t1 = System.nanoTime() - strL;
		
		long sbL = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<=10000; i++) {
			sb.append(i).append(" "); 
		}
		//System.out.println(sb);
		long t2 = System.nanoTime() - sbL;
		System.out.println("t1/t2 = " + t1/t2);
	}

}
