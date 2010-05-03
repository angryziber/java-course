package net.azib.java.lessons.gui;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.TextField;

/**
 * CommentApplet
 *
 * @author anton
 */
public class CommentApplet extends Applet {

	private static final long serialVersionUID = 1L;
	private CommentBean commentBean = null;
	private Button button = null;
	private TextField textField = null;

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
		this.setSize(298, 149);

		this.add(getCommentBean(), null);
		this.add(getTextField(), null);
		this.add(getButton(), null);
		this.getCommentBean().setSize(getSize());
		getTextField().setText(getCommentBean().getComment());
	}

	/**
	 * This method initializes commentBean	
	 * 	
	 * @return net.azib.java.lessons.gui.CommentBean	
	 */
	private CommentBean getCommentBean() {
		if (commentBean == null) {
			commentBean = new CommentBean();
		}
		return commentBean;
	}

	/**
	 * This method initializes button	
	 * 	
	 * @return java.awt.Button	
	 */
	private Button getButton() {
		if (button == null) {
			button = new Button();
			button.setLabel("Change comment");
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getCommentBean().setComment(textField.getText());
				}
			});
		}
		return button;
	}

	/**
	 * This method initializes textField	
	 * 	
	 * @return java.awt.TextField	
	 */
	private TextField getTextField() {
		if (textField == null) {
			textField = new TextField();
			textField.setText("sdsds");
		}
		return textField;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
