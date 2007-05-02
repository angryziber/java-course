package net.azib.java.students.t050209.beans;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 * CommentApplet
 *
 * @author t050209
 */
public class CommentApplet extends Applet {

	private Image img;
	
	
	@Override
	public void init() {
		img = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("hansa.jpg"));
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		add(new CommentBean());
		
		add(new Canvas(){
			{
				setSize(300,300);
			}
			public void paint(Graphics g) {
				getGraphics().drawImage(img, 10, 10, this);
			}
		});
	}
	
}
