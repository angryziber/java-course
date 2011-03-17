package net.azib.java.students.t103784;

import net.azib.java.lessons.collections.Shape;
import net.azib.java.lessons.collections.ShapeAggregator;

import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 16.03.11
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
public class ShapeAggregatorImpl implements ShapeAggregator {
	@Override
	public void addShapes(Shape... shapes) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void addShapes(Collection<? extends Shape> shapesCollection) {
		throw new UnsupportedOperationException("unimplemented yet");
	}

	@Override
	public Shape min() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Shape max() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public <T extends Shape> List<T> sortedShapes() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void copyTo(Collection<? super Shape> shapesCollection) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void copyLargerTo(Shape smallestShape, Collection<? super Shape> shapesCollection) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public double totalArea() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
