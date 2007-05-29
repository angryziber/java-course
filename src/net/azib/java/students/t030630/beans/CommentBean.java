package net.azib.java.students.t030630.beans;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * CommentBean
 * 
 * @author Kasutaja
 */
public class CommentBean extends Canvas implements Serializable {

	private String commentString = "";

	public CommentBean() {
		 super();
		 setComment("No comments yet");
		 setSize(300, 150);
		 
		 Runnable animatsion = new Runnable() {
			public void run() {
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Graphics g = getGraphics();
				g.setFont(new Font("Arial", Font.BOLD, 20));
				int pos = getWidth();
				while(true){
					g.clearRect(0, 0, getWidth(), getHeight());
					g.drawString(commentString, pos -= 2, 30);
					if(pos < -commentString.length() * 20){
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
	 
	 new Thread(animatsion).start();
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
