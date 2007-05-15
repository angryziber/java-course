package net.azib.java.students.t030636.beans;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 * CommentApplet
 *
 * @author Martin
 */
public class CommentApplet extends Applet {

	private Image img;
	@Override
	public void start() {
		
		add(new Canvas() {{
			setSize(400,400);
		}
		@Override 
		public void paint(Graphics g) {
//				g.drawImage(img, 100, 20, this);
				g.drawImage(img, 100, 20, 300, 200, this);
		}}
		
		);
		
	}
//		add(new CommentBean());


	@Override
	public void init() {
		img = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("ham.gif"));
	}
	

}
