package net.azib.java.students.t030656.CommentBean;

import java.awt.Frame;
import java.beans.IntrospectionException;

/**
 * exec:
 * Written for execution of javapean
 *
 * @author t030656
 */
public class exec {

	/**
	 * @param args
	 * @throws IntrospectionException 
	 */
	public static void main(String[] args) throws IntrospectionException {
		
	/*		BeanInfo info = Introspector.getBeanInfo(CommentBean.class);
			
			for(PropertyDescriptor propDescr: info.getPropertyDescriptors())
			{
				System.out.println(propDescr.getName());				
			}
	*/		
			CommentBean commentBean = new CommentBean();
			
			Frame frame = new Frame();
			
			frame.add(commentBean);
			frame.setSize(200, 200);
			frame.setVisible(true);
	}

}
