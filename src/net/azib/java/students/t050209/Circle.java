package net.azib.java.students.t050209;

import net.azib.java.lessons.collections.Shape;

/**
 * Circle
 *
 * @author t050209
 */
public class Circle extends Shape {

	double r;
	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#area()
	 */
	public Circle(){
		this.r = r;
	}
	
	@Override
	public double area() {		
		return Math.PI * r * r;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.lessons.collections.Shape#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Circle || o != null){			
			return (this.r == ((Circle)o).r);
		}
		else
			return false;
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
		return "Circle area is:" + area();
	}
	
	public static void main(String[] args) {
		
	}

}
