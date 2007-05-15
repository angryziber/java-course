package net.azib.java.students.t030636.beans;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.Serializable;


/**
 * CommentBean
 *
 * @author Martin
 */
public class CommentBean extends Canvas implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = -1758214719730140303L;
	
	private String commentString;
	
	public CommentBean() {
		super();
		setComment("No comment yet");
		setSize(300, 150);
		
		Runnable animation = new Runnable() {
			public void run() {
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e1) {

				}
				
				Graphics g = getGraphics();
				int pos = getWidth();
				while (true) {
					g.clearRect(0, 0, getWidth(), getHeight());
					g.drawString(commentString, pos -= 2, 30);
					if (pos < -commentString.length() * 7) {
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
		Frame frame = new Frame();
		CommentBean commentBean = new CommentBean();
		frame.add(commentBean);
		frame.setSize(commentBean.getSize());
		frame.setVisible(true);
	}

}
