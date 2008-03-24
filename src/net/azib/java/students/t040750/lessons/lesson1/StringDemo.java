package net.azib.java.students.t040750.lessons.lesson1;

/**
 * StringDemo
 *
 * @author t040750
 */
public class StringDemo {
	static void printStuff(String ...strings) {
		for (int i = 1; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}
	
	public static void main(String[] args) {
		String s1 = "s";
		String s2 = s1;
		
		System.out.println(s1 == s2); //true
		
		String s3 = "sa";
		String s4 = "sa";
		
		System.out.println(s3 == s4); 	//teooria järgi on vastus false, kuid kompilaator optimeerib
										//midagi (String pooling) ja selle tulemusena kasutatakse ühte 
										//ja sama stringi mõlema muutuja deklareerimisel. 
		
		String s5 = "sa";
		String s6 = s5 + "";
		
		System.out.println(s5 == s6); 
		s5 = new StringBuilder().append(s6).append("").toString();
		
		String s = "";
		StringBuilder sb = new StringBuilder();
			
		for (int i = 1 ; i <= 10; i++) {	//sellise tsükli jaoks peaks kasutama manuaalselt StringBuilderit
			s += i + " "; 					//(vt edasi) kuna praegusel juhul kopeeritakse iga iteratsiooni ajal 
											//uus ja eelmisest suurem tükk ja tehakse uus String objekt
		}
		
		for (int i = 1 ; i <= 10; i++) {
			sb.append(i).append(' '); 
		}
		
		System.out.printf("Result: %s", sb);	//c++ mehikeste jaoks
		
		printStuff(args);
	}
}
