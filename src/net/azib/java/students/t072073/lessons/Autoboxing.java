package net.azib.java.students.t072073.lessons;

/**
 * Autoboxing
 *
 * @author janika
 */
public class Autoboxing {

	public static void main(String[] args) {
		int a = 1, b = 1;
		Integer aa = 1, bb = 1, cc = new Integer(1); //a on autoboxitud ja cc käsitsi boxitud
		System.out.println(a==b);
		System.out.println(aa==cc);//võrdleme objekte
		System.out.println(aa==bb);
		System.out.println(aa.equals(cc)); //equals() võrdleb sisu

	}

}
