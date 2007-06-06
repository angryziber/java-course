package net.azib.java.students.t050657.homework.dao;

import net.azib.java.students.t050657.homework.ctrl.dataAccess.DBAccessor;
import net.azib.java.students.t050657.homework.model.Competition;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.sql.Date;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * CompetitionDaoTest
 * 
 * @author Boriss
 */
public class CompetitionDaoTest extends TestCase{
	
	CompetitionDao mock;
	DBAccessor da;
	
	@Before
	public void setUp() {
		mock = createMock(CompetitionDao.class);
		da = new DBAccessor();
		da.setComDao(mock);	
	}
	
	@Test
	public void testGetCompetition() {
		Competition competition = new Competition(1, "PL", Date.valueOf("2006-03-18"), "DECATHLON4BEER in Krakow");
		expect(mock.getCompetition("PL", Date.valueOf("2006-03-18"), "DECATHLON4BEER in Krakow")).andReturn(competition);
		replay(mock);
		
		assertTrue(competition.equals(da.getCompetition("PL", Date.valueOf("2006-03-18"), "DECATHLON4BEER in Krakow")));
		verify(mock);
	}
}
