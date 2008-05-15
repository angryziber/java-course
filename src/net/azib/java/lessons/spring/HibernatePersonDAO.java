package net.azib.java.lessons.spring;

import net.azib.java.lessons.db.Person;
import net.azib.java.lessons.db.PersonDAO;

import java.util.Collection;

import org.springframework.orm.hibernate3.HibernateOperations;

/**
 * HibernatePersonDAO
 *
 * @author anton
 */
public class HibernatePersonDAO implements PersonDAO {
	
	private HibernateOperations hibernateOperations;
	
	public Person loadPerson(int id) {
		return (Person) hibernateOperations.get(Person.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Person> findAllPersons() {
		return hibernateOperations.find("from Person");
// 		alternative implementation where access to real Hibernate Session is needed
//		return (Collection<Person>) hibernateOperations.execute(new HibernateCallback() {
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				Criteria c = session.createCriteria(Person.class);
//				List<Person> persons = c.list();
//				return persons;
//			}
//		});
	}

	public void setHibernateOperations(HibernateOperations hibernateOperations) {
		this.hibernateOperations = hibernateOperations;
	}
}
