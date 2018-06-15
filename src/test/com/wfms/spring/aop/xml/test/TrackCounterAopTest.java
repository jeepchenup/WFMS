package com.wfms.spring.aop.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.aop.advice.xml.Actor;
import com.wfms.spring.aop.advice.xml.CompactDisc;
import com.wfms.spring.aop.advice.xml.Encoreable;
import com.wfms.spring.aop.advice.xml.TrackCounter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:./aop/TrackCounter-aop.xml"})
public class TrackCounterAopTest {

	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private TrackCounter trackCounter;
	
	@Autowired
	private Actor actor;
	
	@Test
	public void testCompactDiscIsNotNull() {
		assertNotNull(cd);
	}
	
	@Test
	public void testTrackCounterIsNotNull() {
		assertNotNull(trackCounter);
	}
	
	@Test
	public void testActorIsNotNull() {
		assertNotNull(actor);
	}
	
	@Test
	public void testTrackCount() {
		cd.playTrack(1);
		cd.playTrack(2);
		cd.playTrack(2);
		cd.playTrack(2);
		cd.playTrack(3);
		cd.playTrack(3);
		cd.playTrack(3);
		cd.playTrack(3);
		
		assertEquals(1, trackCounter.getPlayCount(1));
		assertEquals(3, trackCounter.getPlayCount(2));
		assertEquals(4, trackCounter.getPlayCount(3));
	}
	
	@Test
	public void testAopIntroduction() {
		assertTrue(actor instanceof Encoreable);
		
		((Encoreable)actor).performEncore();
	}
}
