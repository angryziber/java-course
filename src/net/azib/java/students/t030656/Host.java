package net.azib.java.students.t030656;

/**
 * MinuSingleton
 *
 * @author t030656
 */
public class Host {

	private static Host uniqueInstance = new Host();
	private static String strName;
	private int iNr;
	
	private Host(){
		iNr = 0;
		strName = "Peremees";
	}
	
	public static Host getInstance()
	{
		return uniqueInstance;
	}
	
	public String getName(){
		return strName;
		
	}
	
	public Dog createRndmDog(){
		iNr++;
		return new Dog("Dog nr: " + iNr);
	}
}
