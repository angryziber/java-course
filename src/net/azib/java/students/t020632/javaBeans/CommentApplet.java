package net.azib.java.students.t020632.javaBeans;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * CommentApplet
 *
 * @author t020632
 */
public class CommentApplet extends Applet{

	private Image img;
	
	
	@Override
	public void init() {
		img = Toolkit.getDefaultToolkit().getImage("H:/p_logo_online.gif");
	}
	

	@Override
	public void start() {
		//super.init();
		//getGraphics().drawImage(img, 0, 0, null);
		add(new CommentBean());
		add(new Canvas(){
			{
				setSize(300, 300);
			}

			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, null);
			}
			
		});
	}
	
}
