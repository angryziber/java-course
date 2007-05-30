package net.azib.java.students.t010687.Beans;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
/**
 * BeanIntrospector
 *
 * @author t010687
 */
public class BeanIntrospector {

	/**
	 * @param args
	 * @throws IntrospectionException 
	 */
	public static void main(String[] args) throws IntrospectionException {
		BeanInfo info =Introspector.getBeanInfo(CommentBean.class);
		for (PropertyDescriptor prop : info.getPropertyDescriptors()){
			System.out.println(prop.getName());
		}
	}

}
