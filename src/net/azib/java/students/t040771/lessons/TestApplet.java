package net.azib.java.students.t040771.lessons;

import java.applet.Applet;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TestApplet
 *
 * @author t040771
 */
public class TestApplet extends Applet {
	
	CommentBean bean;

	void setComment(String comment) {
		bean.setComment(comment);
	}
	
	@Override
	public void start() {
		bean = new CommentBean();
		TextField textField = new TextField(20);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setComment(e.getActionCommand());			}
			}
		);
		add(bean);
		add(textField);
		textField.setLocation(10, 501);
	}
	
}
