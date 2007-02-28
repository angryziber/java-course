package net.azib.java.students.t010687;

/**
 * Concatenator
 *
 * @author t010687
 */
public class Concatenator {
	public String Concat(String a,String b){
		if (a==null){
			return b;
		}
		if (b==null){
			return a;
		}
		return (a + b);
	}
}
