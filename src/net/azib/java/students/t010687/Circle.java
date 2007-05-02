package net.azib.java.students.t010687;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author t010687
 */
public class Circle extends Shape {
	private double r; 

	/**
	 * 
	 */
	public Circle(double r) {
		this.r = r;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */
	@Override
	public double area() {
		return java.lang.Math.PI * r*r;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if ((o instanceof Circle) || (o != null)){
			return (this.r ==((Circle)o).r);
		}
		else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode();
		
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#toString()
	 */
	@Override
	public String toString() {
		return "Circle: R = " + r +" ; Area = " + area();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("OK");
	}

}
