package net.azib.java.students.t104948.Lecture5;


import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.text.DecimalFormat;
import java.util.*;

public class ShapeAggregatorImpl implements ShapeAggregator{
	Set<Shape> shapeSet;

	public ShapeAggregatorImpl(){
		shapeSet = new TreeSet<Shape>();
	}

	@Override
	public void addShapes(Shape... shapes) {
		shapeSet.addAll(Arrays.asList(shapes));
		for(Shape shape: shapeSet){
			System.out.println(shape);
		}
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		 shapeSet.addAll(shapesCollection);
		  for(Shape shape: shapeSet){
			  System.out.println(shape);
		}
	}

	@Override
	public Shape min() {
		return Collections.min(shapeSet);
	}

	@Override
	public Shape max() {
		return Collections.max(shapeSet);
	}

	@Override
	public <T extends Shape> List<T> sortedShapes() {
		List <T> sortedList = new ArrayList<T>();
		Collections.addAll(shapeSet);
		Collections.sort(sortedList);
		return sortedList;
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
		shapesCollection.addAll(shapeSet);
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		for(Shape shape: shapeSet){
			if(shape.compareTo(smallestShape)==1)
				shapesCollection.add(smallestShape);
		}
	}

	@Override
	public double totalArea() {
		double totalArea = 0;
		for(Shape shape: shapeSet){
			totalArea += shape.area();
		}
		return totalArea;
	}

	public static void main(String[] args) {
		ShapeAggregatorImpl shapeAggregator = new ShapeAggregatorImpl();
		//Shape[] shapes = {new Circle(4), new Square(3), new Circle(5), new Circle(3), new Square(3)};
		//System.out.println("Array of Shapes:");
		//shapeAggregator.addShapes(shapes);
		//System.out.println();

		//Circle[] circles = {new Circle(3), new Circle(5), new Circle(3), new Circle(4), new Circle(11)};
		//Collection<Circle> circleCollection = new LinkedList<Circle>();
		//circleCollection.addAll(Arrays.asList(circles));
		//System.out.println("Collection of Circles:");
		//shapeAggregator.addShapes(circleCollection);
		//System.out.println();

		Square[] squares = {new Square(14), new Square(8), new Square(11), new Square(5), new Square(14)};
		Collection<Square> squareCollection = new LinkedList<Square>();
		squareCollection.addAll(Arrays.asList(squares));
		System.out.println("Collection of Squares:");
		shapeAggregator.addShapes(squareCollection);
		System.out.println();


		System.out.println("max: " + shapeAggregator.max().toString());
		System.out.println();
		System.out.println("min: " + shapeAggregator.min().toString());

		Collection<Shape> shapeCollection = new ArrayList<Shape>();

		shapeAggregator.copyTo(shapeCollection);
		System.out.println();
		System.out.println("Copy of collection: ");
		for(Shape shape: shapeCollection){
			System.out.println(shape);
		}

		System.out.println();
		System.out.println("Sort: ");
		shapeAggregator.sortedShapes();
		for(Shape shape: shapeCollection){
			System.out.println(shape);
		}

		System.out.println();
		System.out.println("Smallest shape: ");
		Shape smallShape = new Square(0.1);
		Collection <Shape> shapeCollection1= new ArrayList<Shape>();
		shapeAggregator.copyLargerTo(smallShape, shapeCollection1);
		for(Shape shape: shapeCollection1){
			System.out.println(shape);
		}
		System.out.println();
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Total area: " + df.format(shapeAggregator.totalArea()));
	}
}
