package net.azib.java.students.t020632.javaBeans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * TestBean
 *
 * @author t020632
 */
public class TestBean {

	
	public static void main(String[] args) throws IntrospectionException {
		BeanInfo info = Introspector.getBeanInfo(CommentBean.class);
		for(PropertyDescriptor prop : info.getPropertyDescriptors())
			System.out.println(prop.getName());

	}

}
