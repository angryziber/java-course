package net.azib.java.lessons.collections;

/**
 * A base class of all Shapes, like Circle, Square, etc.
 * All shapes should be immutable.
 * 
 * Used in the 5th lesson - Generics.
 * 
 * @author anton
 */
public abstract class Shape implements Comparable<Shape>, Cloneable {
	
	/**
	 * Constructs a Shape instance.
	 */
	protected Shape() {
	}
	
	/**
	 * @see Object#equals(Object)
	 */
	@Override
	public abstract boolean equals(Object o);
	
	/**
	 * @see Object#hashCode()
	 */
	@Override
	public abstract int hashCode();
	
	/**
	 * Shapes are compared according to their area.
	 * Note that areas are compared with 0.00001 precision.
	 * @param anotherShape a Shape to compare with
	 * @return -1, 0, or 1 showing whether the current Shape is smaller, equal, or greater than anotherShape
	 * @throws NullPointerException in case anotherShape is null
	 */
	@Override
	public int compareTo(Shape anotherShape) {
		double areaDifference = area() - anotherShape.area();
		return Math.abs(areaDifference) <= 0.00001 ? 0 : (int)Math.signum(areaDifference);
	}

	/**
	 * @see Object#toString()
	 */
	@Override
	public abstract String toString();
	
	/**
	 * @return the area of the Shape
	 */
	public abstract double area();

	/**
	 * Clones the Shape instance
	 */
	@Override
	protected Shape clone() {
		try {
			return (Shape) super.clone();
		}
		catch (CloneNotSupportedException e) {
			// this cannot happen
			throw new RuntimeException(e);
		}
	}
	
}
