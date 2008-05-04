package net.azib.java.students.t030633;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;

/**
 * TestApplet
 * 
 * @author t030633
 */
public class CommentApplet extends JApplet {

	@Override
	public void init() {
		setLayout(null);
		CommentBean bean = new CommentBean();
		String parameter = getParameter("comment");
		if (parameter != null)
			bean.setComment(parameter);
		add(bean);
		JButton button = new JButton();
		button.setText("OK");
		button.setBounds(0, 100, 100, 20);
		add(button);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Image img = getImage(getCodeBase(), "java-logo.gif");
				getGraphics().drawImage(img, 0, 100, CommentApplet.this);
			}

		});
	}

}
