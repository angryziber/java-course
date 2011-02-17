package net.azib.java.lessons.basic;

public class Bulldog extends Dog {
	public Bulldog(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Bulldog named " + name;
	}
}
