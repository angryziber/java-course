package net.azib.java.lessons.gui;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * CommentBean
 *
 * @author anton
 */
public class CommentBean extends JPanel {
	
	private String comment = "Hello World!";  //  @jve:decl-index=0:
	private int x = 300;
	private int y;

	public CommentBean() {
		setSize(300, 100);
		
		new Thread() {
			@Override
			public void run() {
				while (!Thread.interrupted()) {
					x--;
					if (x <= -100)
						x = getSize().width;
					y = (int)(Math.sin((double)x / 10) * 20) + 40;
					repaint();
					
					try {
						Thread.sleep(100);
					}
					catch (InterruptedException e) {
						break;
					}
				}
			}
		}.start();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getSize().width, getSize().height);
		g.setFont(new Font("Arial", 0, 20));
		g.drawString(comment, x, y);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		CommentBean bean = new CommentBean();
		frame.add(bean);
		frame.setSize(bean.getSize());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}



