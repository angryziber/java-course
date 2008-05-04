package net.azib.java.students.t030633;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * CommentBean
 * 
 * @author t030633
 */
public class CommentBean extends JPanel {

	private String comment;
	private int x = 300;
	private int y;

	public CommentBean() {
		setSize(300, 100); // size is a property
		new Thread() {
			@Override
			public void run() {
				while (!Thread.interrupted()) {
					if (x-- < -100)
						x = getSize().width;
					y = (int) (Math.sin((double) x / 10) * getSize().height / 4) + getSize().height / 2;

					repaint();
					try {
						sleep(50);
					}
					catch (InterruptedException e) {
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
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		CommentBean bean = new CommentBean();
		frame.getContentPane().add(bean);
		frame.setSize(bean.getSize());
		frame.setVisible(true);
		// WindowAdapter is an empty class that implements WindowListener
		// can use it to override/implement WindowListener methods like this:
		// frame.addWindowListener(new WindowAdapter() {
		// @Override
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// });
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getSize().width, getSize().height);
		g.setFont(new Font("Courier New", 0, 20));
		g.drawString("Nyah!", x, y);
	}

}
