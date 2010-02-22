package net.azib.java.students.t100337;

/**
 * Turtle
 *
 * @author xyxeszter
 */
public class Turtle extends Animal implements Cooking{

	private int cookingTime;
	private String name;
	
	public Turtle(String name, int age){
		savouriness = true;
	    cuteness = true;
		this.name = name;
		this.age = age;		
		cookingTime = age*3;
	}
	
	public int getCookingTime(){ return cookingTime; } 
	
	public String cooking(){
		return(name + " " + "is cooking for" + " " + cookingTime +" " + "minutes");
	}
}
