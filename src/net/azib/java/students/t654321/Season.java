package net.azib.java.students.t654321;

/**
 * Season
 *
 * @author t999902
 */
public enum Season {
	SPRING,
	SUMMER,
	WINTER,
	AUTUMN;
	
	public Season next(){
/*		switch (this){
			case WINTER: return SPRING;
			case SPRING: return SUMMER;
			case SUMMER: return AUTUMN;
			case AUTUMN: return WINTER;
		}
*/
		return values()[(this.ordinal() + 1) % values().length];
		
	}

}
