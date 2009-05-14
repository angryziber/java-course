package net.azib.java.lessons.xml;

import net.azib.java.lessons.gui.CommentBean;

import java.beans.XMLEncoder;

/**
 * XMLEncoderDemo
 *
 * @author anton
 */
public class XMLEncoderDemo {
	public static void main(String[] args) {
		CommentBean bean = new CommentBean();
		bean.setComment("MegaComment");
		XMLEncoder encoder = new XMLEncoder(System.out);
		encoder.writeObject(bean);
		encoder.close();
	}
}
