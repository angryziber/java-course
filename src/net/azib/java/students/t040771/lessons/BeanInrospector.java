package net.azib.java.students.t040771.lessons;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * BeanInrospector
 *
 * @author t040771
 */
public class BeanInrospector {
public static void main(String[] args) {
	try {
		BeanInfo bInfo = Introspector.getBeanInfo(CommentBean.class);	
		PropertyDescriptor bDesc[] = bInfo.getPropertyDescriptors();
		for(PropertyDescriptor p : bDesc) {
			System.out.println(p.getName());
		}
	}
	catch (Exception e) {
		// TODO: handle exception
	}	
	
}
}
