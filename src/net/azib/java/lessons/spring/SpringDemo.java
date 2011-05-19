package net.azib.java.lessons.spring;

import net.azib.java.lessons.db.FakeDB;
import net.azib.java.lessons.db.Person;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.simple.SimpleJdbcOperations;
import org.springframework.orm.hibernate3.HibernateOperations;

import java.sql.SQLException;
import java.util.List;

/**
 * @author anton
 */
public class SpringDemo {
	private SimpleJdbcOperations jdbc;
	private HibernateOperations hibernate;

	private void doSomething() throws SQLException {
		System.out.println(jdbc.queryForInt("select count(*) from persons") + " people in the DB");

		Person extraPerson = new Person();
		extraPerson.setName("Josh Smith");
		hibernate.save(extraPerson);
		System.out.println("new id: " + extraPerson.getId());

		Person examplePerson = new Person();
		examplePerson.setName("Josh Smith");
		for (Person person : (List<Person>)hibernate.findByExample(examplePerson)) {
			System.out.println(person);
		}

		//hibernate.findByNamedQuery("Person.allJohns");

		for (Person person : hibernate.loadAll(Person.class)) {
			System.out.println(person);
		}
	}

	public void setJdbc(SimpleJdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	public void setHibernate(HibernateOperations hibernate) {
		this.hibernate = hibernate;
	}

	public static void main(String[] args) throws SQLException {
		FakeDB.prepare();

		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml", SpringDemo.class));

		SpringDemo demo = beanFactory.getBean(SpringDemo.class);
		demo.doSomething();
	}
}
