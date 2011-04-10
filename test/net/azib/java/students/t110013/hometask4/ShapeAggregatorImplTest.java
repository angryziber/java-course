package net.azib.java.students.t110013.hometask4;

import net.azib.java.lessons.collections.Shape;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Vadim
 */
public class ShapeAggregatorImplTest {
	ShapeAggregatorImpl sa = new ShapeAggregatorImpl();
	Shape smallestShape = mock(Shape.class);
	Shape mediumShape = mock(Shape.class);
	Shape largestShape = mock(Shape.class);

	@Before
	public void teachMocks() {
		when(smallestShape.area()).thenReturn(1.0);
		when(smallestShape.compareTo(any(Shape.class))).thenReturn(-1);

		when(mediumShape.area()).thenReturn(2.0);
		when(mediumShape.compareTo(smallestShape)).thenReturn(1);
		when(mediumShape.compareTo(mediumShape)).thenReturn(0);
		when(mediumShape.compareTo(largestShape)).thenReturn(-1);

		when(largestShape.area()).thenReturn(3.0);
		when(largestShape.compareTo(any(Shape.class))).thenReturn(1);
	}

	@SuppressWarnings("NullArgumentToVariableArgMethod")
	@Test(expected = NullPointerException.class)
	public void addingNullArrayNotAllowed() {
		addShapesArray(null);
	}

	@Test(expected = NullPointerException.class)
	public void addingNullCollectionNotAllowed() {
		addShapesCollection(null);
	}

	@Test
	public void addingEmptyShapesArray() {
		addShapesArray();
		assertTrue(getShapes().isEmpty());
	}

	@Test
	public void addingEmptyShapesCollection() {
		addShapesCollection(new ArrayList<Shape>());
		assertTrue(getShapes().isEmpty());
	}

	@Test
	public void addingOneShape() {
		addShapesArray(mediumShape);
		assertThat(getShapes(), is(Arrays.asList(mediumShape)));
		addShapesArray(mediumShape);
		assertThat(getShapes(), is(Arrays.asList(mediumShape, mediumShape)));
	}

	@Test
	public void addingTwoEqualShapes() {
		addShapesArray(mediumShape, mediumShape);
		assertThat(getShapes(), is(Arrays.asList(mediumShape, mediumShape)));
	}

	@Test
	public void addingTwoDifferentShapes() {
		addShapesArray(mediumShape, largestShape);
		assertThat(getShapes(), is(Arrays.asList(mediumShape, largestShape)));
	}

	@Test
	public void findingSmallestShape() {
		addShapesArray(smallestShape, mediumShape, largestShape);
		assertThat(sa.min(), is(smallestShape));
	}

	@Test
	public void findingLargestShape() {
		addShapesArray(smallestShape, mediumShape, largestShape);
		assertThat(sa.max(), is(largestShape));
	}

	@Test
	public void sortingShapes() {
		addShapesArray(mediumShape, largestShape, smallestShape);
		assertThat(sa.sortedShapes(), is(Arrays.asList(smallestShape, mediumShape, largestShape)));
	}

	@Test
	public void copingShapesLargerThanCompared() {
		addShapesArray(smallestShape, mediumShape, largestShape);
		assertThat(copyOfShapesLargerThan(smallestShape), is(Arrays.asList(mediumShape, largestShape)));
	}

	@Test
	public void copingShapesLargerWhenNoLarger() {
		addShapesArray(smallestShape, mediumShape, mediumShape);
		assertTrue(copyOfShapesLargerThan(mediumShape).isEmpty());
	}

	@Test
	public void calculatingTotalArea() {
		addShapesArray(smallestShape, mediumShape, largestShape);
		assertThat(sa.totalArea(), is(6.0));
	}

	private void addShapesArray(Shape... shapes) {
		sa.addShapes(shapes);
	}

	private void addShapesCollection(Collection<Shape> shapes) {
		sa.addShapes(shapes);
	}

	private List<Shape> getShapes() {
		List<Shape> shapes = new ArrayList<Shape>();
		sa.copyTo(shapes);
		return shapes;
	}

	private List<Shape> copyOfShapesLargerThan(Shape comparedShape) {
		List<Shape> largerShapes = new ArrayList<Shape>();
		sa.copyLargerTo(comparedShape,largerShapes);
		return largerShapes;
	}
}
