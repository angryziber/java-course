package net.azib.java.students.t040750.lessons.lesson1;


import java.util.Date;

/**
 * HelloWorld
 *
 * @author t040750
 */
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println(Constants.GREETING_MESSAGE);
		System.out.println(new Date());
		
		char c = 'A' + 1 + '\u0020'; // 'A' + 1 = B
						   			 // '\u0020' = 0x32 = space
		
		//long l = 4568780112211212L; //L peab lõpus olema, 
									//kuna muidu on default parempoolne väärtus int
									
		
		
		//Integer i = new Integer(5); //mõlemad variandid on lubatud
		//Integer j = 5;				//ja samaväärsed
		
		//int k = Integer.parseInt("5");
		
		System.out.println("Character c is: " + c);
		
		/*
		 * Kirjuta klass, mis arvutab 100-nda Fibonacci arvu
		 * 
		 * 1 1 2 3 5 8 13 21 ...
		 * 
		 * Iga arv on temale kahe eelneva arvu summa
		 * */
		
	}

}
