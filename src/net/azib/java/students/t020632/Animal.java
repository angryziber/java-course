package net.azib.java.students.t020632;

/**
 * Animal
 *
 * @author t020632
 */
public class Animal {
	private String name;
	private byte age;
	
	public Animal(String name){
		this.name = name;
	}
	
	public Animal(String name, byte age){
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
