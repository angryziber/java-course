package net.azib.java.students.t030630.beans;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * CommonApplet
 * 
 * @author Kasutaja
 */
public class CommonApplet extends Applet {

	private Image img;

	@Override
	public void start() {
		getGraphics().drawImage(img, 0, 0, null);
		add(new CommentBean());
		add(new Canvas(){
			{setSize(100, 100);}
		
		@Override
		public void paint(Graphics g){
			g.drawImage(img, 0, 0, this);
		}
		});		
	}

	@Override
	public void init() {
		img = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("java.jpg"));
		// getImage(getClass().getClassLoader().getResource("java.jpg"));
	}
}
