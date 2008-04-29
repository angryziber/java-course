package net.azib.java.lessons.applets;

import net.azib.java.lessons.gui.CommentBean;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;

/**
 * CommentApplet
 *
 * @author anton
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
		button.setText("Click me!");
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
