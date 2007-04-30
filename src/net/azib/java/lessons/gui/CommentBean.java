package net.azib.java.lessons.gui;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * CommentBean
 *
 * @author anton
 */
public class CommentBean extends Canvas implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -4592037671827056864L;
	
	private String commentString;
	
	public CommentBean() {
		super();
		setComment("No comments yet");
		setSize(300, 150);
		
		Runnable animation = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1500);
				}
				catch (InterruptedException e1) {
				}
				
				Graphics g = getGraphics();
				g.setFont(new Font("Arial", Font.BOLD, 20));
				
				int pos = getWidth();
				while (true) {
					g.clearRect(0, 0, getWidth(), getHeight());
					g.drawString(commentString, pos -= 2, 30);
					if (pos < -commentString.length() * 20) {
						pos = getWidth();
					}
					
					try {
						Thread.sleep(20);
					}
					catch (InterruptedException e) {
						break;
					}
				}
			}
		};
		
		new Thread(animation).start();
	}

	public String getComment() {
		return commentString;
	}

	public void setComment(String comment) {
		this.commentString = comment;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(commentString, 20, 20);
	}
	
	public static void main(String[] args) {
		CommentBean commentBean = new CommentBean();

		Frame frame = new Frame();
		frame.add(commentBean);
		frame.setSize(commentBean.getSize());
		frame.setVisible(true);
	}
}
