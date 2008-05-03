package net.azib.java.students.t020281;

import javax.swing.JApplet;
import javax.swing.JButton;

/**
 * CommentApplet
 *
 * @author Trial
 */
public class CommentApplet extends JApplet{
 /**
 * 
 */

	@Override
	public void init() {
		setLayout(null);
		setSize(500,500);
		CommentBean bean = new CommentBean();
		String parameter = getParameter("comment");
		if (parameter != null)
			bean.setComment(parameter);
		add(bean);
		JButton button = new JButton();
		button.setText("Click Me!");
		button.setBounds(0, 150, 100, 20);
		add(button);
		
		
	}
}