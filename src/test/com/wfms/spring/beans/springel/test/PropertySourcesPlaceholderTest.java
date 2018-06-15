package com.wfms.spring.beans.springel.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.beans.outerproperty.BlankDisc2;
import com.wfms.spring.beans.outerproperty.PropertySourcesPlaceholderConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PropertySourcesPlaceholderConfig.class)
public class PropertySourcesPlaceholderTest {
	
	@Autowired
	private BlankDisc2 blankDisc2;
	
	@Test
	public void testBlankDisc2IsNotNull() {
		assertNotNull(blankDisc2);
		System.out.println(blankDisc2);
	}
}
