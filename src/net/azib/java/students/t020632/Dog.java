package net.azib.java.students.t020632;

/**
 * Dog
 *
 * @author t020632
 */
public class Dog {
	private String name;
	private byte age;
	
	public Dog(String name){
		this.name = name;
	}
	
	public Dog(String name, byte age){
		this.name = name;
		this.age = age;
	}
	
	
	public byte growUp(){
		age++; 
		
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public byte getAge(){
		return age;
	}
	
}
