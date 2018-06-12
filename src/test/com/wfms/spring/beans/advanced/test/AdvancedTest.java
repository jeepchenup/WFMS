package com.wfms.spring.beans.advanced.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.beans.advanced.MagicBean;
import com.wfms.spring.beans.advanced.MagicConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MagicConfig.class)
public class AdvancedTest {
	
	@Autowired
	private MagicBean magicBean;
	
	@Test
	public void testMagicBeanIsNotNull() {
		assertNotNull(magicBean);
	}
}
