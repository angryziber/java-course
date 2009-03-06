package net.azib.java.lessons.enums;

import net.azib.java.lessons.basic.Todo;

public enum Season {
	WINTER,
	SPRING,
	SUMMER,
	AUTUMN;
	
	@Todo("Implement me")
	public Season next() {
		Season[] values = values();
		return values[(ordinal()+1) % values.length];
	}
}
