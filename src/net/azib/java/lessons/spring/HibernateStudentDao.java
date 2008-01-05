package net.azib.java.lessons.spring;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * HibernateStudentDao
 *
 * @author anton
 */
public class HibernateStudentDao implements StudentDao {
	
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Student getStudent(String studentCode) {
		return (Student) hibernateTemplate.findByNamedQueryAndNamedParam("Student.getByStudentCode", "studentCode", studentCode).get(0);
	}

}
