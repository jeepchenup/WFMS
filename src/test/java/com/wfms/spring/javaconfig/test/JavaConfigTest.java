package com.wfms.spring.javaconfig.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.beans.javaconfig.CDPlayer;
import com.wfms.spring.beans.javaconfig.CDPlayerConfig;
import com.wfms.spring.beans.javaconfig.CompactDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class JavaConfigTest {

	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private CDPlayer cdPlayer;
	
	@Autowired
	private CDPlayer anotherCDPlayer;
	
	@Test
	public void testCompactDiscIsNotNull() {
		assertNotNull(cd);
	}
	
	@Test
	public void testCDPlayerIsNotNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testAnotherCDPlayerIsNotNull() {
		assertNotNull(anotherCDPlayer);
	}
	
	@Test
	public void invokeCompactDiscPlay() {
		cd.play("invoke Compact Disc play() method");
	}
	
	@Test
	public void invokeCDPlayerPlay() {
		cdPlayer.play("invoke CDPlayer play() method");
	}
}
