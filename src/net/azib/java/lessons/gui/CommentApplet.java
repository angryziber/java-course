package net.azib.java.lessons.gui;

import java.applet.Applet;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CommentApplet
 *
 * @author anton
 */
public class CommentApplet extends Applet {

	private static final long serialVersionUID = 1L;
	private CommentBean commentBean;
	private TextField text;
	private Button button;

	/**
	 * This is the default constructor
	 */
	public CommentApplet() {
		super();
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void init() {
		this.setSize(500, 300);
		commentBean = new CommentBean();
		this.add(commentBean);
		text = new TextField();
		text.setText(commentBean.getComment());
		add(text);		
		button = new Button();
		button.setLabel("Change comment");
		add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commentBean.setComment(text.getText());
			}
		});
	}

}
