package net.azib.java.students.t073857;

/**
 * Gender
 *
 * @author Joonas Vali
 */
public enum Gender {
	MALE, FEMALE;
	
	public String thirdSubject(){
		if(this == MALE) return "he";
		else return "she";
	}
	
	public String thirdObject(){
		if(this == MALE) return "him";
		else return "her";
	}
	
	public String thirdPosessive(){
		if(this == MALE) return "his";
		else return "hers";
	}
}
