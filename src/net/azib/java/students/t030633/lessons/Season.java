package net.azib.java.students.t030633.lessons;

/**
 * Season
 * 
 * @author t030633
 */
public enum Season {
	WINTER, SPRING, SUMMER, AUTUMN;

	public Season next() {

		// switch (this){
		// case WINTER: return SPRING;
		// case SPRING: return SUMMER;
		// case SUMMER: return AUTUMN;
		// case AUTUMN: return WINTER;
		// }
		// return null; // default:

		return values()[(this.ordinal() + 1) % values().length];
	}

}
