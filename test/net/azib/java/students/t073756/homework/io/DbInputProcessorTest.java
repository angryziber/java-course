package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.DecathlonEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class DbInputProcessorTest {

	private DbInputProcessor processor;

	@Before
	public void setUp() throws Exception {
		TestDecathlonDB.prepare();
	}

	@Test
	public void testReadAthletesByCompetitionId() throws Exception {
		processor = new DbInputProcessor(TestDecathlonDB.openConnection(), 1);
		fixSQL();
		assertResult(processor.readAthletes());
	}

	@Test
	public void testReadAthletesByCompetitionName() throws Exception {
		processor = new DbInputProcessor(TestDecathlonDB.openConnection(), "DECATHLON4BEER");
		fixSQL();
		assertResult(processor.readAthletes());
	}

	@After
	public void tearDown() throws Exception {
		TestDecathlonDB.clean();
	}

	private void fixSQL() {
		processor.setSql(processor.getSql().replace("DATE_FORMAT(dob, '%d.%m.%Y')", "EXTRACT(DAY FROM dob) || '.' || EXTRACT(MONTH FROM dob) || '.' || EXTRACT(YEAR FROM dob)"));
	}

	private void assertResult(List<Athlete> athletes) {
		assertEquals(1, athletes.size());
		Athlete a = athletes.iterator().next();
		assertEquals("Siim Susi", a.getName());
		assertEquals("325.72", a.getResult().getResults().get(DecathlonEvent.M_1500));
	}
}
