package net.azib.java.students.t104948;

public abstract class Pet extends Animal {
	private String name;
	private String owner;

	public void setName(String s){
		name = s;
	}
	public String getName(){
		return name;
	}

	public void setOwner(String s){
		owner = s;
	}
	public String getOwner(){
		return owner;
	}

	abstract void belongToOwner();

}
