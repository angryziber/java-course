package net.azib.java.students.t040750.lessons.lesson4;

/**
 * Season
 *
 * @author t040750
 */
public enum Season {
	WINTER,
	SPRING,
	SUMMER,
	AUTUMN;
	
	public Season next() {
		/*
		switch (this) {
		case WINTER: return SPRING;
		case SPRING: return SUMMER;
		case SUMMER: return AUTUMN;
		case AUTUMN: return WINTER;
		}
		*/
		return values()[(this.ordinal() + 1) % values().length];
	}
}
