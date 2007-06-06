package net.azib.java.students.t050657.homework.dao;

import net.azib.java.students.t050657.homework.ctrl.dataAccess.DBAccessor;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.Result;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.sql.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * ResultsDaoTest
 *
 * @author Boriss
 */
public class ResultsDaoTest extends TestCase{
	ResultsDao mock;
	DBAccessor da;
	
	
	
	@Before
	public void setUp() {
		mock = createMock(ResultsDao.class);
		da = new DBAccessor();
		da.setResDao(mock);	
	}
	
	@Test
	public void testGetCompetition() {
		Competition competition = new Competition(1, "EE", Date.valueOf("2005-12-01"), "Training in Tallinn");
		Competition results = new Competition(1, "EE", Date.valueOf("2005-12-01"), "Training in Tallinn");
		SortedSet<Result> set = new TreeSet<Result>();
		
		Result r = new Result(6);
		set.add(r);
		
		results.setResults(set);
		expect(mock.getCompetitionResults(competition)).andReturn(results);
		replay(mock);
		
		assertEquals((new Result(6)),(da.getCompetition("EE", Date.valueOf("2005-12-01"), "Training in Tallinn").getResults().first()));
		verify(mock);
	}
	
}
