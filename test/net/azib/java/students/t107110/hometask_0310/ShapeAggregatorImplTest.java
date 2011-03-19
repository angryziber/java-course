package net.azib.java.students.t107110.hometask_0310;

import net.azib.java.lessons.collections.Shape;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Eduard Shustrov
 */
public class ShapeAggregatorImplTest {
	private final ShapeAggregatorImpl aggregator = new ShapeAggregatorImpl();
	final Shape smallestShape = mock(Shape.class);
	final Shape mediumShape = mock(Shape.class);
	final Shape largestShape = mock(Shape.class);

	public ShapeAggregatorImplTest() {
		when(smallestShape.area()).thenReturn(1.0);
		when(smallestShape.compareTo(any(Shape.class))).thenReturn(-1);

		when(mediumShape.area()).thenReturn(2.0);
		when(mediumShape.compareTo(smallestShape)).thenReturn(1);
		when(mediumShape.compareTo(largestShape)).thenReturn(0);

		when(largestShape.area()).thenReturn(3.0);
		when(largestShape.compareTo(any(Shape.class))).thenReturn(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantAddNullShapeCollection() {
		addShapeCollection(null);
	}

	@Test
	public void addingEmptyShapeCollection() {
		addShapeCollection(new ArrayList<Shape>());
		assertThat(shapes().size(), is(0));
	}

	@SuppressWarnings({"NullArgumentToVariableArgMethod"})
	@Test(expected = IllegalArgumentException.class)
	public void cantAddNullShapeList() {
		addShapeList(null);
	}

	@Test
	public void addingNoShape() {
		addShapeList();
		assertThat(shapes().size(), is(0));
	}

	@Test
	public void addingOneShape() {
		addShapeList(mediumShape);
		assertThat(shapes(), is(asList(mediumShape)));
	}

	@Test
	public void addingSameShapeTwice() {
		addShapeList(mediumShape, mediumShape);
		assertThat(shapes(), is(asList(mediumShape, mediumShape)));
	}

	@Test
	public void addingTwoShapes() {
		addShapeList(smallestShape, largestShape);
		assertThat(shapes(), is(asList(smallestShape, largestShape)));
	}

	@Test
	public void findingSmallestShape() {
		addShapeList(mediumShape, smallestShape, largestShape);
		assertThat(aggregator.min(), is(smallestShape));
	}

	@Test
	public void findingLargestShape() {
		addShapeList(mediumShape, largestShape, smallestShape);
		assertThat(aggregator.max(), is(largestShape));
	}

	@Test
	public void sortingShapes() {
		addShapeList(mediumShape, largestShape, smallestShape);
		assertThat(aggregator.sortedShapes(), is(asList(smallestShape, mediumShape, largestShape)));
	}

	@Test
	public void copingLargerShapes() {
		addShapeList(mediumShape, largestShape, smallestShape);
		final List<Shape> largerShapes = new ArrayList<Shape>();
		aggregator.copyLargerTo(smallestShape, largerShapes);
		assertThat(largerShapes, is(asList(mediumShape, largestShape)));
	}

	@Test
	public void totalShapeArea() {
		addShapeList(mediumShape, largestShape, smallestShape);
		assertThat(aggregator.totalArea(), is(6.0));
	}

	private void addShapeCollection(final Collection<Shape> shapes) {
		aggregator.addShapes(shapes);
	}

	private void addShapeList(final Shape... shapes) {
		aggregator.addShapes(shapes);
	}

	private List<Shape> shapes() {
		final List<Shape> shapes = new ArrayList<Shape>();
		aggregator.copyTo(shapes);
		return shapes;
	}
}
