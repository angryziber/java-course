package net.azib.java.students.t020544.hometasks.task04;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 * 
 * @author Julija Kondratjeva
 */
public class Square extends Shape {

	private double squareSide;

	/**
	 * 
	 */
	public Square(double squareSide) {
		this.squareSide = squareSide;
	}

	@Override
	public double area() {
		return Math.pow(squareSide, 2);
	}

	/**
	 * @param squareSide
	 *            the squareSide to set
	 */
	public void setSquareSide(double squareSide) {
		this.squareSide = squareSide;
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Square) && (Double.valueOf(squareSide).equals(((Square) o).squareSide));
	}

	@Override
	public int hashCode() {
		return Double.valueOf(squareSide).hashCode();
	}

	@Override
	public String toString() {
		return "Created square with area: " + area() + " and hashCode(): " + hashCode();
	}

}
