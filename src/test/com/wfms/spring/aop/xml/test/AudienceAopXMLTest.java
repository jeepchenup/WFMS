package com.wfms.spring.aop.xml.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.aop.advice.xml.Actor;
import com.wfms.spring.aop.advice.xml.CompactDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:./aop/Audience-aop.xml")
public class AudienceAopXMLTest {

	@Autowired
	private Actor actor;
	
	@Autowired
	private CompactDisc cd;
	
	@Test
	public void testActorIsNotNull() {
		assertNotNull(actor);
	}
	
	@Test
	public void testCDIsNotNull() {
		assertNotNull(cd);
	}
	
	@Test
	public void testAudience() {
		actor.perform();
	}
}
