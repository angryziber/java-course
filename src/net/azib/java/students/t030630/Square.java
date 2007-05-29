package net.azib.java.students.t030630;

import net.azib.java.lessons.collections.Shape;

/**
 * Square
 *
 * @author Kasutaja
 */
public class Square extends Shape{
	private double a;

	public Square(double a) {
		super();
		this.a = a;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (a*a);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Square)
			if(this.a == ((Square)o).getA())
				return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int)a;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("It is a square with side equals " + a);
	}
	
}
