package net.azib.java.lessons.enums;

import net.azib.java.lessons.basic.Todo;

public enum Season {
	WINTER,
	SPRING,
	SUMMER,
	AUTUMN;

	@Todo("not implemented")
	public Season next() {
		return values()[(ordinal() + 1) % values().length];
	}
}
