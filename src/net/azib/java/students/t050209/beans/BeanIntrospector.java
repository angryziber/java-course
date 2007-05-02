package net.azib.java.students.t050209.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * BeanIntrospector
 *
 * @author t050209
 */
public class BeanIntrospector {

	/**
	 * @param args
	 * @throws IntrospectionException 
	 */
	public static void main(String[] args) throws IntrospectionException {
		// TODO Auto-generated method stub
		BeanInfo info = Introspector.getBeanInfo(CommentBean.class);
		for (PropertyDescriptor prop : info.getPropertyDescriptors()){
			System.out.println(prop.getName());
		}
	}
}
