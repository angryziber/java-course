package net.azib.java.students.t050209;

import java.math.BigDecimal;

/**
 * NumberStaff
 *
 * @author t050209
 */
public class NumberStaff {
	static int b; /* static'ut tuleks vältida */
	/* static final on konstant */
	
	static final String HELLO = "abc"; /* HELLO = null */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Dog on muutuja tüüp, dog - muutuja tüüp*/
		Dog dog = new Dog("Pitsu");
		/* Dog dog;
		   dog = new Dog(); */
		
		Boolean d = new Boolean(true);
		
		char c = '\u0050';
		System.out.println(c);
		
	    /*NumberStaff.b=7;*/ /* teises klassis olles vaja ette */
		/*final int hello = 7;*/ /* ei saa väärtust muuta */
	    /*System.out.println(NUmber2Stuff.accessMe); *//* sysout + ctrl + space*/
		/*System.out.println(HELLO);*/
		System.out.println(dog.getName());
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.parseInt("123", 16)); /*Hex -> dec*/ 
	    
		BigDecimal db = new BigDecimal("1.025");
		BigDecimal db2 = BigDecimal.TEN;
		System.out.println(db.add(db2));
		
		Object str = "aaa";
		System.out.println(str instanceof String);
	}

}
