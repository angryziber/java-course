package net.azib.java.students.t030656.CommentBean;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * CommentBean
 *
 * @author t030656
 */
public class CommentBean extends Canvas implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -5973918857618778346L;
	
	private String _strComment = "No comments"; //comment string
	
	/**
	 * 
	 */
	public CommentBean() {
		super();
		setStrComment("O");
		setSize(1152, 400);
		
		Runnable animation = new Runnable(){
			public void run() {
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
				}
				Graphics g = getGraphics();
				int pos = getWidth();
				int pos2 = getHeight(); 
				int y_modifier = 10;
				int x_modifier = 5;
				while(true){
					g.clearRect(0, 0, getWidth(), getHeight());
					g.setFont(new Font("Arial", Font.BOLD, 25));
					if(y_modifier > 0)
					{
						g.drawString("Modifier: " + y_modifier, 20, 30);
					}
					else
					{
						g.drawString("Modifier: " + (-y_modifier), 20, 30);
					}
					g.drawString(_strComment, pos -= x_modifier, pos2 -= y_modifier);
					
					if(pos <- _strComment.length() * 7){
						pos = getWidth();
					}
					
					if(pos2 <= 5 || pos2 == getHeight()){
						y_modifier =- y_modifier;
						g.drawString("Control pos2: "+pos2, 20, 60);
					}
					
					y_modifier -= 1;
		/*			if(y_modifier  == 0){
						x_modifier = 1;
					}else{
						if(y_modifier != 0)
							y_modifier -= 1;
					}
					if(y_modifier > 300){
						slow = 0;
					}
					if(slow == 0){
						y_modifier += 10;
					}else{
						y_modifier -= 10;
					}*/
					
					
					
					try {
						Thread.sleep(500);
					}
					catch (InterruptedException e) {
						break;
					}
				}
			}
		};
		
		new Thread(animation).start();
	}

	/**
	 * @return the strComment
	 */
	public String getStrComment() {
		return _strComment;
	}

	/**
	 * @param strComment the strComment to set
	 */
	public void setStrComment(String strComment) {
		this._strComment = strComment;
	}

	/* (non-Javadoc)
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
/*	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawString(_strComment, 20, 20);
	}
*/
	
}  
