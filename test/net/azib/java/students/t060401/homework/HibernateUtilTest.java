package net.azib.java.students.t060401.homework;

import net.azib.java.students.t060401.homework.util.HibernateUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.EntityPersister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * HibernateUtilTest
 * 
 * @author Astrid Pärn
 */
public class HibernateUtilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t060401.homework.util.HibernateUtil#getSessionFactory()}.
	 */
	@Test
	public void testGetSessionFactory() {

		String classNameAthleteVO = "net.azib.java.students.t060401.homework.decathlon.model.AthleteVO";
		String classNameResultsVO = "net.azib.java.students.t060401.homework.decathlon.model.ResultsVO";
		String classCompetitionVO = "net.azib.java.students.t060401.homework.decathlon.model.CompetitionVO";

		Vector<String> classNameVector = new Vector<String>();
		classNameVector.add(classNameAthleteVO);
		classNameVector.add(classNameResultsVO);
		classNameVector.add(classCompetitionVO);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Map metadata = sessionFactory.getAllClassMetadata();
		Collection persisters = metadata.values();

		assertEquals(classNameVector.size(), persisters.size());

		for (Iterator i = persisters.iterator(); i.hasNext();) {
			Session session = sessionFactory.openSession();
			try {
				EntityPersister persister = (EntityPersister) i.next();
				String className = persister.getClassMetadata().getEntityName();
				assertTrue(classNameVector.contains(className));
				// List result = session.createQuery("from " + className + " c").list();
				
			}
			catch (Exception e) {
				fail(""+e);
			}
			finally {
				session.close();
			}
		}
	}
}
