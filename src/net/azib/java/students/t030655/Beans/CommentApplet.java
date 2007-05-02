package net.azib.java.students.t030655.Beans;

import java.applet.Applet;

/**
 * CommentApplet
 *
 * @author qtrines
 */
public class CommentApplet extends Applet {

	@Override
	public void start() {
		add(new CommentBean());
	}
	

}
