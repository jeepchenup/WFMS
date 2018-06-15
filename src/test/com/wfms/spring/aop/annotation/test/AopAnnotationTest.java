package com.wfms.spring.aop.annotation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.aop.advice.annotation.AopConfig;
import com.wfms.spring.aop.advice.annotation.CompactDisc;
import com.wfms.spring.aop.advice.annotation.DefaultEncoreable;
import com.wfms.spring.aop.advice.annotation.DogPerformance;
import com.wfms.spring.aop.advice.annotation.Encoreable;
import com.wfms.spring.aop.advice.annotation.EncoreableIntroducer;
import com.wfms.spring.aop.advice.annotation.JavaConfig;
import com.wfms.spring.aop.advice.annotation.TrackCounter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JavaConfig.class, AopConfig.class})
public class AopAnnotationTest {

	@Autowired
	private DogPerformance dogPerformance;
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private TrackCounter trackCounter;
	
	@Test
	public void testDogPerformanceIsNotNull() {
		assertNotNull(dogPerformance);
		dogPerformance.perform();
	}
	
	@Test
	public void testCDAndTrackCounterIsNotNull() {
		assertNotNull(cd);
		assertNotNull(trackCounter);
	}
	
	@Test
	public void testTrackCounter() {
		cd.playTrack(1);
		cd.playTrack(2);
		cd.playTrack(3);
		cd.playTrack(3);
		cd.playTrack(4);
		
		assertEquals(1, trackCounter.getPlayCount(1));
		assertEquals(1, trackCounter.getPlayCount(2));
		assertEquals(2, trackCounter.getPlayCount(3));
		assertEquals(1, trackCounter.getPlayCount(4));
	}
	
	@Test
	public void testProduction() {
		dogPerformance.perform();
		
		assertTrue(dogPerformance instanceof Encoreable);
		
		((Encoreable)dogPerformance).performEncore();
	}
}
