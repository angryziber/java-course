package net.azib.java.students.t030655.Beans;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * CommentBean
 *
 * @author qtrines
 */
public class CommentBean extends Canvas implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -4204961126401142099L;
	
	
	private String commentString;
	
	public CommentBean(){
		super();
		setComment("No comments yet");
		setSize(300, 150);
		
		Runnable animation = new Runnable(){
			public void run(){
				try{
					Thread.sleep(500);
				}
				catch (InterruptedException e1){
				}
				
				Graphics g = getGraphics();
				int pos = getWidth();
				while (true){
					g.clearRect(0,0, getWidth(), getHeight());
					g.drawString(commentString, pos -= 2, 30);
					if (pos< -commentString.length()* 20){
						pos = getWidth();
					}
					
					try{
						Thread.sleep(20);
					}
					catch (InterruptedException e){
						break;
					}
				}
			}
		};
		new Thread(animation).start();
	}
	
	public void setComment(String string){
		this.commentString = string;
	}
	
	String getComment(){
		return commentString;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.drawString(commentString, 20, 20);
	}
	
	public static void main(String[] args) {
		CommentBean commentBean = new CommentBean();
		
		Frame frame= new Frame();
		frame.add(commentBean);
		frame.setSize(commentBean.getSize());
		frame.setVisible(true);
	}
}
