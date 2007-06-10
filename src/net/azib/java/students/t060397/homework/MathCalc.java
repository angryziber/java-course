package net.azib.java.students.t060397.homework;

/**
 * MathCalc class contains only Matchematical calculation
 * 
 * @author Margus Ernits
 */
public class MathCalc {
	/**
	 * The distance between two points
	 * 
	 * @param x1
	 *            first point x coordinate
	 * @param y1
	 *            first point y coordinate
	 * @param x2
	 *            second point x coordinate
	 * @param y2
	 *            second point y coordinate
	 * @return distance between two points
	 */
	public static double distBetweenPoints(int x1, int y1, int x2, int y2) {

		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

	}

	/**
	 * Is point in the circle
	 * 
	 * @param x
	 *            point x coordinate
	 * @param y
	 *            point y coordinate
	 * @param circleX
	 *            circle centre coordinate x
	 * @param circleY
	 *            circle centre coordinate y
	 * @param radius
	 *            circle radius
	 * @return true if point inside circle
	 */
	public static boolean inCircle(int x, int y, int circleX, int circleY, int radius) {
		double distance = MathCalc.distBetweenPoints(x, y, circleX, circleY);
		if (distance > radius)
			return false;
		return true;
	}

	/*
	 * Nord, West, South, O -east (Ost)
	 */

	public static enum Rumb {
		N, NW, W, SW, S, SO, O, NO
	}

	/**
	 * Gives rumb from angle
	 * 
	 * @param angle
	 * @return rumb
	 */

	public static Rumb getRumb(int angle) {

		angle = angle % 360;

		if (angle >= 0 && angle < 22) {
			return Rumb.O;
		}
		else if (angle >= 22 && angle < 68) {
			return Rumb.NO;
		}
		else if (angle >= 68 && angle < 113) {
			return Rumb.N;
		}
		else if (angle >= 113 && angle < 158) {
			return Rumb.NW;
		}
		else if (angle >= 158 && angle < 203) {
			return Rumb.W;
		}
		else if (angle >= 203 && angle < 248) {
			return Rumb.SW;
		}
		else if (angle >= 248 && angle < 293) {
			return Rumb.S;
		}
		else if (angle >= 293 && angle < 338) {
			return Rumb.SO;
		}
		return Rumb.O;
	}

}
