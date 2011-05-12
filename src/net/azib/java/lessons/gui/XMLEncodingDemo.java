package net.azib.java.lessons.gui;

import java.beans.XMLEncoder;

public class XMLEncodingDemo {
	public static void main(String[] args) {
		CommentBean commentBean = new CommentBean();
		commentBean.setComment("Hello World!");

		XMLEncoder encoder = new XMLEncoder(System.out);
		encoder.writeObject(commentBean);
		encoder.close();
	}
}
