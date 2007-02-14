package net.azib.java.simple;

public enum Season {
	WINTER,
	SPRING,
	SUMMER,
	AUTUMN;
	
	public Season next() {
//		switch (this) {
//			case WINTER: return SPRING;
//			case SPRING: return SUMMER;
//			case SUMMER: return AUTUMN;
//			case AUTUMN: return WINTER;
//			default: 	 return null;
//		}
		// alternative implementation
		return values()[(ordinal() + 1) % values().length];
	}
}
