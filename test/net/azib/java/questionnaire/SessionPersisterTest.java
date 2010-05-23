package net.azib.java.questionnaire;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


/**
 * SessionPersisterTest
 *
 * @author anton
 */
public class SessionPersisterTest {
	
	@Test
	public void dontPersistASessionTwice() throws Exception {
		final boolean[] finishedCalled = {false};
		
		Session mockSession = new Session() {
			@Override
			public boolean isFinished() {
				finishedCalled[0] = true;
				return true;
			}			
		};
		
		try {
			new SessionPersister(mockSession);
			fail();
		}
		catch (IllegalStateException e) {			
		}
		assertTrue(finishedCalled[0]);
	}
	
	@Test
	public void dontPersistASessionTwiceWithEasyMock() throws Exception {
		Session mockSession = createMock(Session.class);
		expect(mockSession.isFinished()).andReturn(true).once();
		replay(mockSession);
		
		try {
			new SessionPersister(mockSession);
			fail();
		}
		catch (IllegalStateException e) {			
		}
		
		verify(mockSession);
	}
}
