package net.azib.java.students.t050209.beans;

import java.io.Serializable;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;

/**
 * CommentBean
 *
 * @author t050209
 */
public class CommentBean extends Canvas implements Serializable{	
		
	/** serialVersionUID */
	private static final long serialVersionUID = 2947679251393649965L;
	
	private String comment;
	
	public CommentBean() {
		super();
		setComment("Hello");
		setSize(300, 150);
		
		Runnable animation = new Runnable() {
			public void run() {
				try{
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
				}
				Graphics g = getGraphics();
				g.setFont(new Font("Arial", Font.BOLD, 20));
				
				int pos = getWidth();
				while(true) {
					g.clearRect(0, 0, getWidth(), getHeight());
					g.drawString(comment, pos -= 2, 30);
					if(pos < comment.length() * 7) {
						pos = getWidth();
					}
					
					try{
						Thread.sleep(20);
					}
					catch(InterruptedException ie){
						break;
					}
				}
			}
		};
		
		new Thread(animation).start();
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(comment, 20, 20);
	}
}
