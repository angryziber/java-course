package net.azib.java.students.t040719.lessons;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Master
 *
 * @author t040719
 */
public class Master {
	public static void main(String[] args) {
		Animal a = new Dog("Figaro","Cocker Spaniel",(byte)1);
		Animal b = new Cat("Cora","Persian",(byte)2);
		
		Exception e2 = new Exception();
		
		try {
			Animal c = (Animal) a.clone();
			//throw e2;
			c = null;
			System.out.println(c);
			System.out.println(c.equals(a));
		}
		catch (CloneNotSupportedException  e) {
			System.out.println("Can't clone");
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unknown error: " + e);
		}
		finally {
			System.out.println("finally");
			e2.printStackTrace();
		}
		System.out.println(a.getClass() + " ja " + b.getClass());
	
	}
}
