package net.azib.java.lessons.applets;

import net.azib.java.lessons.gui.CommentBean;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * CommentApplet
 *
 * @author anton
 */
public class CommentApplet extends Applet {
	
	private Image img;
	
	@Override
	public void init() {
		img = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("java-logo.gif"));
	}

	@Override
	public void start() {
		add(new CommentBean());
		add(new Canvas() {
			{
				setSize(300, 300);
			}
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, this);
			}
			
		});
	}
	
	

}
