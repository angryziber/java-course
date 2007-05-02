package net.azib.java.students.t020632.javaBeans;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * CommentBean
 *
 * @author t020632
 */
public class CommentBean extends java.awt.Canvas implements Serializable{
	

	private static final long serialVersionUID = 1L;
	public String comment;
	
	public CommentBean(){
		super();
		setComment("No comment yet");
		setSize(300,150);
		
		Runnable animation = new Runnable() {
			public void run() {
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Graphics g = getGraphics();
				g.setFont(new Font("Arial", Font.BOLD, 20));
				
				int pos = getWidth();
				while(true){
					g.clearRect(0, 0, getWidth(), getHeight());
					g.drawString(comment, pos-=2, 30);
					
					if(pos < -comment.length()* 7){
						pos = getWidth();
					}
					
					try {
						Thread.sleep(20);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
						break;
					}
				}
				
			}
		};
		
		Thread thread = new Thread(animation);
		thread.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(comment, 50, 50);
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment){
		this.comment = comment;
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		CommentBean bean = new CommentBean();
		frame.add(bean);
		frame.setSize(bean.getSize());
		frame.setVisible(true);
	}
	
}
