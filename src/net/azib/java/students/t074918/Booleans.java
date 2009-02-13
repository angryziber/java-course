package net.azib.java.students.t074918;

/**
 * Booleans
 * 
 *  & vs &&
 *  & - laseb mõlemad pooled käima
 *  && - kui esimene true siis teist ei kontrollita
 *
 * @author matikati
 */
public class Booleans {
	
	static boolean a() {
		System.out.println("Kontrollitakse a -d...");
		return true;
	}
	
	static boolean b() {
		System.out.println("Kontrollitakse b -d...");
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Üksik & | evalueerib mõlemad pooled:");
		System.out.println(a() | b());
		
		System.out.println("Kaksik && || evalueerib vajadusel ainult ühe poole:");
		System.out.println(a() || b());
	}

}
