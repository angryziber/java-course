package net.azib.java.lessons.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * CommentBean
 *
 * @author anton
 */
public class CommentBean extends Canvas implements Serializable {
	private String comment = "Hello";  //  @jve:decl-index=0:
	private int x, y;
	private Image offscreen;  //  @jve:decl-index=0:
	private Graphics offscreenG;  //  @jve:decl-index=0:

	public CommentBean() {
		initialize();
		y = 50;
		
		Timer animationTimer = new Timer();
		animationTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				x--;
				if (x < 0) {
					x = getWidth();
				}
				y = (int) (Math.sin((double)x / 30) * 20) + 50;
				repaint();
			}
		}, 100, 10);
	}

	private void initialize() {
        this.setSize(new Dimension(300, 100));
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public void update(Graphics g) {
		if (offscreen == null) {
			offscreen = createImage(getWidth(), getHeight());
			offscreenG = offscreen.getGraphics();
		}
		offscreenG.clearRect(0, 0, getWidth(), getHeight());
		offscreenG.drawString(comment, x, y);
		g.drawImage(offscreen, 0, 0, this);
	}
}
