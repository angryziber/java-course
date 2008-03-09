package net.azib.java.lessons.enums;

import net.azib.java.lessons.basic.Todo;

public enum Season {
	WINTER,
	SPRING,
	SUMMER,
	AUTUMN;
	
	@Todo("Implement method next")
	public Season next() {
		return values()[(this.ordinal() + 1) % values().length];
	}
}
