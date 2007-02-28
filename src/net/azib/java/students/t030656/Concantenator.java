package net.azib.java.students.t030656;

/**
 * Concantenator
 *
 * @author t030656
 */
public class Concantenator {
	
	public String concanate(String strA, String strB){
		if(strB == null){
			return strA;
		}
		
		if(strA == null){
			return strB;
		}
	
		return strA + strB;
	} 

}
