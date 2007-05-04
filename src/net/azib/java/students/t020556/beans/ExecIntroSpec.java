package net.azib.java.students.t020556.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * ExecIntroSpec
 *
 * @author Agu Aarna
 */
public class ExecIntroSpec {

	/**
	 * @param args
	 * @throws IntrospectionException 
	 */
	public static void main(String[] args) throws IntrospectionException {
		BeanInfo bi = Introspector.getBeanInfo(CommentBeans.class);
		
		for(PropertyDescriptor pd : bi.getPropertyDescriptors()){
			System.out.println(pd.getName());
		}
		
	}

}
