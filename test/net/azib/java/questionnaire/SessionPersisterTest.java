package net.azib.java.questionnaire;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
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
	public void dontPersistASessionTwiceWithMockito() throws Exception {
		Session session = mock(Session.class);
		when(session.isFinished()).thenReturn(true);

		try {
			new SessionPersister(session);
			fail();
		}
		catch (IllegalStateException e) {			
		}
	}
}
