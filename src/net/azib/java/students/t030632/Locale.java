package net.azib.java.students.t030632;

/**
 * Locale
 *
 * @author t020632
 */
public class Locale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		long t1 = System.nanoTime();
		String s = "";
		for(int i = 1; i<=1000; i++){
			s += i + " ";
		}
		
		long t2 = System.nanoTime();
		
		System.out.println(t2-t1);
		
		t1 = System.nanoTime();
		
		for(int i = 1; i <= 1000; i++){
			sb.append(i).append(' ');
		}
		
		t2 = System.nanoTime();
		
		System.out.println(t2-t1);
		// System.out.println(sb);

	}

}
