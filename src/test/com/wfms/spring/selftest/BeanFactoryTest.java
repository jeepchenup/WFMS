package com.wfms.spring.selftest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {

	@Test
	public void testClassPathXmlApplicationContext() {
		
		String configLocation = "classpath:/spring/selftest/school-bean.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		School school =context.getBean("school", School.class);
		assertNotNull(school);
		assertEquals("浙江财经大学", school.getSchoolName());
	}
	
}
