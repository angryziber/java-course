package net.azib.java.lessons.db;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernatePersonDAO.
 * <p/>
 * Note: See the same class in the spring package for a better version.
 *
 * @author anton
 */
public class HibernatePersonDAO implements PersonDAO {
	
	private SessionFactory sessionFactory;
	
	public HibernatePersonDAO() {
		sessionFactory = new Configuration().configure(getClass().getResource("hibernate.cfg.xml")).buildSessionFactory();
	}

	public Person loadPerson(int id) {
		Session session = sessionFactory.openSession();
		Person person = (Person) session.get(Person.class, id);
		session.close();
		return person;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Person> findAllPersons() {
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Person.class);
		List<Person> persons = c.list();
		session.close();
		return persons;
	}

}
