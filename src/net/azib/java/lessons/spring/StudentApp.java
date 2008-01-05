package net.azib.java.lessons.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * StudentApp
 *
 * @author anton
 */
public class StudentApp {
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml", StudentApp.class));
		
		StudentDao studentDao = (StudentDao) beanFactory.getBean(StudentDao.class.getName());

		Student student = studentDao.getStudent("960644");
		System.out.println(student.getName());
	}

}
