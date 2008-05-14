package net.azib.java.students.t030633.homework.view.in.hibernate;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;
import net.azib.java.students.t030633.homework.view.in.Input;
import net.azib.java.students.t030633.homework.view.in.hibernate.athletes.HibAthlete;
import net.azib.java.students.t030633.homework.view.in.hibernate.competitions.HibCompetition;
import net.azib.java.students.t030633.homework.view.in.hibernate.results.HibResult;
import net.azib.java.students.t030633.homework.view.in.hibernate.util.HibernateUtil;
import net.azib.java.students.t030633.homework.view.in.hibernate.util.TestSchema;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * HibernateTest
 * 
 * @author t030633
 */
public class HibernateTest {

	private static final Athlete ATHLETE = createMock(Athlete.class);
	private static final String COMPETITION = "Discus Disco";
	private static final String COUNTRY = "EE";
	private static final String NAME = "Goofy";

	@BeforeClass
	public static void setUp() {
		TestSchema.setTestDatabase();

		HibAthlete athlete = new HibAthlete();
		athlete.setName(NAME);
		athlete.setCountry(COUNTRY);
		TestSchema.addAthlete(athlete);

		HibCompetition comp = new HibCompetition();
		comp.setName(COMPETITION);
		TestSchema.addCompetition(comp);

		HibResult result = new HibResult();
		result.setDiscus_throw(4.4F);
		result.setAthlete(athlete);
		result.setCompetition(comp);
		TestSchema.addResult(result);
	}

	@SuppressWarnings("unchecked")	// Hibernate list
	@Test
	public void canGetCompetition() throws IOException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		Query query = session.createQuery("from HibCompetition as c where c.id = ? or c.name = ?");
		List competitions = query.setInteger(0, 1).setString(1, "DiscusDisco").list();
		session.getTransaction().commit();

		assertEquals(((HibCompetition) competitions.get(0)).getName(), COMPETITION);
	}

	@SuppressWarnings("unchecked") // Hibernate list
	@Test
	public void canGetAthlete() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		List athletes = session.createQuery("from HibAthlete as a where a.name = ?").setString(0, NAME).list();
		session.getTransaction().commit();

		assertEquals(((HibAthlete) athletes.get(0)).getName(), NAME);
	}

	@SuppressWarnings("unchecked") // Hibernate list
	@Test
	public void canGetResult() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		List results = session.createQuery("from HibResult as r where r.discus_throw = ?").setFloat(0, 4.4F).list();
		session.getTransaction().commit();

		HibResult theResult = (HibResult) results.get(0);
		assertEquals(4.4D, theResult.getDiscus_throw());
		assertEquals(1, theResult.getAthlete_id());
		assertEquals(1, theResult.getCompetition_id());
	}

	@Test
	public void implementInput() throws IOException {
		Input hib = new Hibernate();
		hib.setParameters(new String[] { null, "1" });
		List<Athlete> athletes = hib.read(createMockBuilder());

		assertEquals(1, athletes.size());
		assertEquals(ATHLETE, athletes.get(0));
	}

	private AthleteBuilder createMockBuilder() {
		AthleteBuilder mockBuilder = createMock(AthleteBuilder.class);
		expect(mockBuilder.name(NAME)).andReturn(mockBuilder);
		expect(mockBuilder.country(COUNTRY)).andReturn(mockBuilder);
		expect(mockBuilder.date(null)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.R100M, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.LONGJ, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.SHOT, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.HIGH, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.R400M, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.R110MH, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.DISCUS, 4.4D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.POLE, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.JAVELIN, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.addResult(Event.R1500M, 0D)).andReturn(mockBuilder);
		expect(mockBuilder.build()).andReturn(ATHLETE);
		replay(mockBuilder);
		return mockBuilder;
	}

}
