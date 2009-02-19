package net.azib.java.lessons.enums;

public enum Season {
	WINTER,
	SPRING,
	SUMMER,
	AUTUMN;
	
	public Season next() {
		return values()[(this.ordinal() + 1) % values().length];
	}
}
