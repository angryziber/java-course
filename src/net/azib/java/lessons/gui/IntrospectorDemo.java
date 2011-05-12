package net.azib.java.lessons.gui;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class IntrospectorDemo {
	public static void main(String[] args) throws IntrospectionException {
		BeanInfo info = Introspector.getBeanInfo(CommentBean.class);
		for (PropertyDescriptor descriptor : info.getPropertyDescriptors()) {
			System.out.print(descriptor.getName());
			System.out.println(descriptor.getWriteMethod() != null ? "(rw)" : "(ro)");
		}
	}
}
