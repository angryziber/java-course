package net.azib.java.students.t030675;

import java.math.BigDecimal;


/**
 * MainClass
 *
 * @author t030675
 */
public class MainClass {
	
	static final String HELLO = "abc";
	
	public static void main(String[] args) {
		//Dog dog = new Dog();
		//char c='a' + 2;//'\u0020';
		//System.out.println(0.51f);
		//System.out.println(0.5f - 0.3f - 0.1f);
		
		
		/*BigDecimal db = new BigDecimal("1.025");
		BigDecimal db2 = BigDecimal.ONE;
		System.out.println(db.add(db2));
		System.out.println(db);
		System.out.println(db2);*/
		
		System.out.println(128>>2);
		Object ob = "aa";
		System.out.println(ob instanceof Integer);
		if (ob instanceof String) {
			System.out.println("AAA");
			
		}
		System.out.println(new Number2Staff.MegaClass());
	}
}
