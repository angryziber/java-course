package net.azib.java.students.t060397.homework;

/**
 * MathCalc class contains only Matchematical calculation
 *
 * @author Margus Ernits
 */
public class MathCalc {
	/**
	 * The distance between two points
	 * @param x1 first point x coordinate
	 * @param y1 first point y coordinate
	 * @param x2 second point x coordinate
	 * @param y2 second point y coordinate
	 * @return distance between two points
	 */
	public static double distBetweenPoints(int x1,int y1,int x2,int y2){
		
		return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
		
	}
	/**
	 * Is point in the circle
	 * @param x point x coordinate
	 * @param y point y coordinate
	 * @param circleX circle centre coordinate x
	 * @param circleY circle centre coordinate y
	 * @param radius circle radius
	 * @return true if point inside circle
	 */
	public static boolean inCircle(int x,int y, int circleX, int circleY,int radius){
		double distance = MathCalc.distBetweenPoints(x, y, circleX, circleY);
		if(distance>radius)	return false;
		return true;
	}
	

}
