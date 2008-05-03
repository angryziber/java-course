package net.azib.java.students.t020281;


import java.awt.Font;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * CommentBean
 *
 * @author Trial
 */
public class CommentBean extends JPanel{

	private String comment = "Hello World!";
	private int x = 20;
	private int y = 20;

	
	/**
	 * 
	 */
	public CommentBean() {
		// TODO Auto-generated constructor stub
		setSize(200, 100);
		
		new Thread() {
			@Override
			public void run() {
				while (!Thread.interrupted()){
					x--;
					if (x <= -100){
						x= getSize().width;
					}
					y = (int) (Math.sin((double)x /10)*20)+ 40;
					repaint();
					try {
						Thread.sleep(100);
					}
					catch (Exception e) {
						break;
					}
					
				}
			}
		}.start();
	}
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

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.clearRect(0, 0, getSize().width,getSize().height);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString(comment, x, y);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		CommentBean bean = new CommentBean();
		frame.add(bean);
		frame.setSize(bean.getSize());
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});	
	}
	
}
