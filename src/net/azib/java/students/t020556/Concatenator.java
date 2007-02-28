package net.azib.java.students.t020556;

/**
 * Concatenator
 *
 * @author t020556
 */
public class Concatenator {
	public String concatenate(String strA, String strB){
		if(strA == null)
			strA = "";
		if(strB == null)
			strB = "";
		
		return strA + strB;
	}
}
