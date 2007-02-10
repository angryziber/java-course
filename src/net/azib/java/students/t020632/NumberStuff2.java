package net.azib.java.students.t020632;

/**
 * NumberStuff2
 *
 * @author t020632
 */
public class NumberStuff2 {
	protected static int accessMe;
	private int dontAccess;
	
	public NumberStuff2(){
		dontAccess = 1;
	}
	
	public NumberStuff2(int i){
		dontAccess = i;
	}
	
	public class MegaClass{
		int accessMe2 = accessMe;
	}
	
	public int getDontAccess(){
		return dontAccess;
	}
}
