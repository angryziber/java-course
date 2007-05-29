package net.azib.java.students.t030630;

/**
 * Concatenator
 *
 * @author t030630
 */
public class Concatenator {

 public String concatenate(String a, String b){
	 if(b == null)
		 return a;
	 if(a == null)
		 return b;
	 return a+b;
 }
}
