package net.azib.java.lessons.gui;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * IntrospectorDemo
 *
 * @author anton
 */
public class IntrospectorDemo {
	public static void main(String[] args) throws IntrospectionException {
		BeanInfo info = Introspector.getBeanInfo(CommentBean.class);
		for (PropertyDescriptor prop : info.getPropertyDescriptors()) {
			System.out.println(prop.getName());
			System.out.println(prop.getDisplayName());
			if (prop.getWriteMethod() == null) {
				System.out.println("(ro)");
			}
		}
	}
}
