package net.azib.java.students.t020556.beans;

import java.applet.Applet;

/**
 * CommentApllet
 *
 * @author Agu Aarna
 */
public class CommentApllet extends Applet{

	/** serialVersionUID */
	private static final long serialVersionUID = 587455512502630316L;

	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	@Override
	public void start() {
		add(new CommentBeans());
	}
}
