package net.azib.java.students.t040719;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * CommentBean
 *
 * @author t040719
 */
public class CommentBean extends JPanel {
	private String comment = "test comment";
	private int x = 150;
	private int y = 30;
	private int speed = 40;
	
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public CommentBean() {
		setSize(300, 80); //suurus on beani omadus
		new Thread(){
			@Override
			public void run() {
				while (!Thread.interrupted()){
					x--;
					if (x<=-150)
						x=getSize().width;
					repaint();
					y = (int)(Math.sin((double)x/10)*40)+(int)(getSize().height/2)+5;
					try {
						Thread.sleep(speed);
					}
					catch (InterruptedException e) {
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

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getSize().width, getSize().height);
		g.setFont(new Font("Courier New",0,20));
		g.drawString(comment, x, y);
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public static void main(String[] args) {
		CommentBean cb = new CommentBean();
		JFrame frame = new JFrame();
		frame.getContentPane().add(cb);
		frame.setSize(cb.getSize());
		//frame.add(cb);
		//frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/ //see on vajalik ainult tavalise FRAME puhul
	}
}
