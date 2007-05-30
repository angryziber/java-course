package net.azib.java.students.t010687.Beans;

import java.io.Serializable;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.Runnable;
/**
 * CommentBean
 *
 * @author t010687
 */
public class CommentBean extends Canvas implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = -7152336889582940260L;
	private String comment;
	
	public CommentBean (){
		comment = "No comments Yet";
		setSize(300,150);
		Runnable animation = new Runnable() {
			public void run( ) {
				try{
					Thread.sleep(1000);
				}
				catch (InterruptedException e){
				}
				Graphics g = getGraphics();
				g.setFont(new Font("Arial",Font.BOLD,20));
				int pos = getWidth();
				while (true){
					g.clearRect(0,0, getWidth(), getHeight());
					g.drawString(comment, pos-=2, 30);
					if (pos < comment.length()*7){
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

	
	/* (non-Javadoc)
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawString(comment, 20, 20);
		
		
	}
	public void setProperty(String comment){
		this.comment = comment;
	}
	public String getProperty(){
		return comment;
	}
}
