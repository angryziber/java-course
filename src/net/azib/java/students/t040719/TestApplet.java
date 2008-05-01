package net.azib.java.students.t040719;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 * TestApplet
 *
 * @author t040719
 */
public class TestApplet extends JApplet implements ActionListener, DocumentListener {
	CommentBean cb;
	JTextField jt;
	@Override
	public void init() {
		setLayout(null);
		cb = new CommentBean();
		String param = getParameter("comment");
		if (param != null)
			cb.setComment(param);
		add(cb);
		JButton jb = new JButton();
		jb.setText("Klikka");
		jb.setBounds(0, cb.getSize().height, 100, 20);
		jt = new JTextField(cb.getComment());
		jt.addActionListener(this);
		jt.setBounds(0, cb.getSize().height+jb.getSize().height, 150, 20);
		add(jt);
		add(jb);
		Document doc = jt.getDocument();
        doc.addDocumentListener(this);
		setSize(cb.getSize().width+150, cb.getSize().height+jb.getSize().height+100);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
				Image img = getImage(getCodeBase(), "java-logo.gif");
				getGraphics().drawImage(img, cb.getSize().width, 0, TestApplet.this);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jt)
			cb.setComment(jt.getText());		
	}

	public void changedUpdate(DocumentEvent e) {
			cb.setComment(jt.getText());
	}

	public void insertUpdate(DocumentEvent e) {
		cb.setComment(jt.getText());
	}

	public void removeUpdate(DocumentEvent e) {
		cb.setComment(jt.getText());
	}

}
