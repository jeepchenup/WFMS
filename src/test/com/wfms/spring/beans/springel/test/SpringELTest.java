package com.wfms.spring.beans.springel.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.beans.outerproperty.BlankDisc;
import com.wfms.spring.beans.outerproperty.BlankDisc2;
import com.wfms.spring.beans.outerproperty.ExpressiveConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ExpressiveConfig.class)
public class SpringELTest {

	@Autowired
	private BlankDisc disc;
	
	@Autowired
	private BlankDisc2 disc2;
	
	@Test
	public void testDiscIsNotNull() {
		assertNotNull(disc);
		System.out.println(disc);
	}
	
	@Test
	public void testBlankDisc2IsNotNull() {
		assertNotNull(disc2);
		System.out.println(disc2);
	}
}
