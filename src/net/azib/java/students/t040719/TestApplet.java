package net.azib.java.students.t040719;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;

/**
 * TestApplet
 *
 * @author t040719
 */
public class TestApplet extends JApplet {

	@Override
	public void init() {
		setLayout(null);
		final CommentBean cb = new CommentBean();
		String param = getParameter("comment");
		if (param != null)
			cb.setComment(param);
		add(cb);
		JButton jb = new JButton();
		jb.setText("Klikka");
		jb.setBounds(0, cb.getSize().height, 100, 20);
		add(jb);
		setSize(cb.getSize().width+150, cb.getSize().height+jb.getSize().height+100);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
				Image img = getImage(getCodeBase(), "java-logo.gif");
				getGraphics().drawImage(img, cb.getSize().width, 0, TestApplet.this);
			}
		});
	}

}
