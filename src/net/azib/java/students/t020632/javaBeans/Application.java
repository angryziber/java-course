package net.azib.java.students.t020632.javaBeans;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

/**
 * Application
 *
 * @author t020632
 */
public class Application extends Composite {

	public Application(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		setSize(new Point(300, 200));
		setLayout(new GridLayout());
	}

}
