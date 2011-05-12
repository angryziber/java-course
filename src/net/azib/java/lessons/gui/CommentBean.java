package net.azib.java.lessons.gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class CommentBean extends JPanel implements Serializable {
	private Image buffer;
	private Graphics offscreen;

	private String comment = "Hello!";
	private int x;
	private int y = 50;

	public CommentBean() {
		setSize(400, 100);

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				synchronized (CommentBean.this) {
					if (x < 0) x = getWidth();
					x--;
					y = 50 + (int)(Math.sin(x / 15f) * 25);
				}
				repaint();
			}
		}, 500, 20);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public void paint(Graphics g) {
		if (offscreen == null) {
			buffer = createImage(getWidth(), getHeight());
			offscreen = buffer.getGraphics();
		}

		offscreen.clearRect(0, 0, getWidth(), getHeight());
		synchronized (this) {
			offscreen.drawString(comment, x, y);
		}
		g.drawImage(buffer, 0, 0, this);
	}
}
