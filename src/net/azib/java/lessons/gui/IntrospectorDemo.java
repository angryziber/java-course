package net.azib.java.lessons.gui;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * IntrospectorDemo
 *
 * @author anton
 */
public class IntrospectorDemo {
	public static void main(String[] args) throws IntrospectionException, UnsupportedEncodingException {
		// introspection
		BeanInfo info = Introspector.getBeanInfo(SimpleBean.class);
		PropertyDescriptor[] props = info.getPropertyDescriptors();
		for (PropertyDescriptor p : props) {
			System.err.print(p.getName());
			if (p.getWriteMethod() == null)
				System.err.println(" (read-only)");
			else
			if (p.getReadMethod() == null)
				System.err.println(" (write-only)");
			else
				System.err.println();
		}
		
		// xml serialization
		SimpleBean bean = new SimpleBean();
		bean.setName("abc");
		bean.setColor(0);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		XMLEncoder encoder = new XMLEncoder(out);
		encoder.writeObject(bean);
		encoder.close();
		System.out.println(out.toString());
		
		byte[] bytes = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
					   "<java version=\"1.6.0\" class=\"java.beans.XMLDecoder\">" +
					   "<object class=\"net.azib.java.lessons.gui.SimpleBean\">" +
					   "<void property=\"name\"><string>abc</string></void>" +
					   "</object>" +
					   "</java>").getBytes("UTF-8");
		XMLDecoder decoder = new XMLDecoder(new ByteArrayInputStream(bytes));
		SimpleBean bean2 = (SimpleBean) decoder.readObject();
		decoder.close();
		
		System.out.println("Read bean with name: " + bean2.getName());
	}
}
