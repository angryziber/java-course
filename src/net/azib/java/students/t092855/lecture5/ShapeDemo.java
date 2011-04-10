package net.azib.java.students.t092855.lecture5;

import net.azib.java.lessons.collections.Shape;

import java.util.Collection;

public class ShapeDemo {

	public static void main(String[] args) {
		Square square1 = new Square(5.1);
		Square square2 = new Square(5.0);
		Square square3 = new Square(10.0);

		System.out.println(square1.toString());
		System.out.println(square2.toString());

		System.out.println(square1.equals(square2));
		System.out.println(square1.hashCode());
		System.out.println(square2.hashCode());

		Circle circle1 = new Circle(3.1);
		Circle circle2 = new Circle(3.0);

		System.out.println(circle1.toString());
		System.out.println(circle2.toString());

		System.out.println(circle1.equals(circle2));
		System.out.println(circle1.hashCode());
		System.out.println(circle2.hashCode());

		ShapeAggregatorImpl shapes1 = new ShapeAggregatorImpl();
		shapes1.addShapes(square1, square2, circle1, circle2);

        ShapeAggregatorImpl shapes2 = new ShapeAggregatorImpl();
		shapes2.addShapes(square3);

		System.out.println("The biggest shape: " + shapes1.max());
		System.out.println("The smallest shape: " + shapes1.min());
		System.out.println("Unsorted shapes: " + shapes1.getShapes());
		System.out.println("Sorted shapes: " + shapes1.<Shape>sortedShapes());
		System.out.println("Total area of shapes: " + shapes1.totalArea());

		System.out.println("Shape collection 2: " + shapes2.getShapes());
		shapes2.addShapes(shapes1.<Shape>getShapes());
		System.out.println("Merged collections to 2: " + shapes2.getShapes());

		ShapeAggregatorImpl shapes3 = new ShapeAggregatorImpl();

		shapes1.copyLargerTo(square1, shapes3.<Shape>getShapes());
		System.out.println("Shapes 3: " + shapes3.getShapes());

		shapes1.copyTo(shapes3.<Shape>getShapes());
		System.out.println("Shapes3 after copying shapes1: " + shapes3.getShapes());
	}


}