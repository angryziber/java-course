package net.azib.java.students.t030656;

import java.util.Locale;

/**
 * Locales
 *
 * @author t030656
 */
public class Locales {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	
	 	Locale.setDefault(new Locale("et", "EE"));
		System.out.println(Locale.getDefault());
	*/
		double sum = 0;
		for(int j = 1; j <= 1000; j++){
			long t1 = System.nanoTime();
			String s = new String();
			for(int i = 1; i <= 100; i++){
				s += i + " ";
			}
			long tout1 = System.nanoTime() - t1;
			
			long t2 = System.nanoTime();
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= 100; i++){
				sb.append(i).append(' ');
			}
			
			long tout2 = System.nanoTime() - t2;
			
			sum += (double)tout1/tout2;
			System.out.print(j);
			System.out.println(" ");
			System.out.println(sum);
		}
		System.out.println(sum/1000);
	}

}
