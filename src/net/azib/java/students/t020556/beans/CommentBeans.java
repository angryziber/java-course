package net.azib.java.students.t020556.beans;

import java.awt.Graphics;

/**
 * CommentBeans
 *
 * @author Agu Aarna
 */
public class CommentBeans extends java.awt.Canvas {
	
	/**
	 * 
	 */
	public CommentBeans() {
		super();
		setSize(300, 150);
		
		Runnable anim = new Runnable(){
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			public void run() {
				try {
					Thread.sleep(100);
				}
				catch (InterruptedException e1) {
					return;
				}
				Graphics g = getGraphics();
				int pos = getWidth();
				
				while(true){
					g.clearRect(0, 0, getWidth(), getHeight());
					g.drawString(comment, pos--, 30);
					
					if(pos < -comment.length() * 7)
						pos = getWidth();
					
					try {
						Thread.sleep(20);
					}
					catch (InterruptedException e) {
						break;
					}
				}	
			}
		};
		
		new Thread(anim).start();
	}

	/** serialVersionUID */
	private static final long serialVersionUID = -277985287162884378L;
	
	String comment = "Some comment";  //  @jve:decl-index=0:

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
