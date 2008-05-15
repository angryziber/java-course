package net.azib.java.lessons.spring;

import net.azib.java.lessons.db.FakeDB;
import net.azib.java.lessons.db.Person;
import net.azib.java.lessons.db.PersonDAO;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * SpringDemo
 *
 * @author anton
 */
public class SpringDemo {
	public static void main(String[] args) throws SQLException {
		new FakeDB().prepare();
		
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml", SpringDemo.class));
		PersonDAO dao = (PersonDAO) beanFactory.getBean(PersonDAO.class.getName());
		
		Person person = dao.loadPerson(1);
		System.out.println(person);
	}
}
