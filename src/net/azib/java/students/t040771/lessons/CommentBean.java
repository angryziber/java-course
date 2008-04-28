package net.azib.java.students.t040771.lessons;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * CommentBean
 * Check teacher example for the same, but with Swing
 * @author t040771
 */
public class CommentBean extends Canvas {
	String comment = "Hello World!";
	int x = 10;
	int y = 50;

	public String getComment() {
		return comment;
	}

	public CommentBean() {
		setSize(500,500);
		new Thread() {
			public void run() {
				int i = 0;
				boolean reverse = false;
				try {
					while(!Thread.interrupted()) {
						if(reverse) i--;
						else i++;
						if(i <= 0 || i >= 450) reverse = !reverse;
						x = i;
						y = (int)(10*Math.sin((double)i/10))+100;
						repaint();
						Thread.sleep(50);
					}
				}
				catch (Exception e) {
					System.out.println("Error");
				}
			}
		}.start();

	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.drawString(comment, x, y);
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		CommentBean commentBean = new CommentBean();
		frame.add(commentBean);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
