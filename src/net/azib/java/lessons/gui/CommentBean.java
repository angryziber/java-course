package net.azib.java.lessons.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Dimension;

/**
 * CommentBean
 *
 * @author anton
 */
public class CommentBean extends Canvas implements Serializable {
	private String comment;  //  @jve:decl-index=0:
	private int x, y;
	
	public CommentBean() {
		initialize();
	}
	
	private void initialize() {
		this.setSize(new Dimension(360, 143));			
		this.setComment("Hello World!");
		
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				x--;
				if (x < 0)
					x = getSize().width;
				y = (int) (Math.sin(x / 10d) * 20 + getSize().height/2); 
				repaint();
			}
		}, 10, 1000/25);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public boolean isCommentPresent() {
		return comment != null && !comment.isEmpty();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (isCommentPresent()) {
			g.drawString(comment, x, y);
		}
	}
	
	
}  //  @jve:decl-index=0:visual-constraint="10,2"
