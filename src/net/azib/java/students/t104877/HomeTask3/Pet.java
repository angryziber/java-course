package net.azib.java.students.t104877.HomeTask3;

public abstract class Pet extends Animal{
	private String owner;
	private String respondsTo;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getRespondsTo() {
		return respondsTo;
	}

	public void setRespondsTo(String respondsTo) {
		this.respondsTo = respondsTo;
	}

	public String toString () {
		return super.toString() + "\nIts owner " + getOwner() + " named it " + getRespondsTo();
	}
}
