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
		BeanInfo beanInfo = Introspector.getBeanInfo(CommentBean.class);
		System.out.println(beanInfo.getBeanDescriptor().getName());
		for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
			System.out.println(pd.getName());
		}
	}
}
