package com.wfms.spring.selftest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/selftest/factorybean-bean.xml")
public class FactoryBeanTest {

	@Autowired
	private ToolFactory toolFactory;
	
	@Test
	public void testToolFactoryBean() {
		assertNotNull(toolFactory);
		assertEquals(1, toolFactory.getToolId());
		assertEquals(9090, toolFactory.getFactoryId());
	}
	
	@Test
	public void testToolFactoryBeanCreateByClassPathXmlApplicationContext() {
		String locationPath = "classpath:/spring/selftest/factorybean-bean.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(locationPath);
		Tool tool = context.getBean("tool", Tool.class);
		ToolFactory toolFactory = context.getBean("&tool", ToolFactory.class);
		
		assertNotNull(tool);
		assertEquals(1, tool.getId());
	}
}
