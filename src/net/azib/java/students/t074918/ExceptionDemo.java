package net.azib.java.students.t074918;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ExceptionDemo
 *
 * @author Mart Mangus
 */
public class ExceptionDemo {

	public static void main(String[] args) {
//		NullPointerException
//		Animal a = null;
//		a.toString();

//		ArrayIndexOutOfBoundsException
//		try {
//			String[] sm = {"a"};
//			System.out.println(sm[10]);			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}

//		ConcurrentModificationException
		try {
			Collection c = new ArrayList();
			c.add("uhuu");
			for (Object object : c) {
				//c.add("ehee");
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Saab eraldada erinevate vigade töötlemist");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally { // Käivaitatakse alati... isegi kui viga ei catch-ita...
			System.out.println("Tehtud!");	
		}
	}

}
