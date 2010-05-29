package net.azib.java.students.t092859.hometask5;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author kostya
 */
public class Square extends Shape{

	private final double side;
	
	/**
	 * @param side - length of square side
	 */
	public Square(double side) {
		super();
		this.side = side;
	}

	@Override
	public double area() {
		return side*side;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if ((o != null) && (o.getClass().equals(this.getClass()))){
			return side == ((Square)o).side;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Double.toHexString(side).hashCode();
	}

	@Override
	public String toString() {
		return getClass().getName() + '@' + Integer.toHexString(hashCode());
	}

}
