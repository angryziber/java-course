package net.azib.java.students.t104948;

public abstract class Animal {
	private int age;
	private String size;
	private String color;

	public void setAge(int a){
		age = a;
	}
	public int getAge(){
		return age;
	}

	public void setSize(String s){
		size = s;
	}
	public String getSize(){
		return size;
	}

	public void setColor(String s){
		color = s;
	}
	public String getColor(){
		return color;
	}

	abstract void makeSound();
	abstract void getSomethingToEat();


}
