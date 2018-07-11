package com.wfms.spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.wfms.spring.selftest.Tool;
import com.wfms.spring.selftest.ToolFactory;

public class LearnBeanFactory {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("/spring/selftest/factorybean-bean.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader read = new XmlBeanDefinitionReader(factory);
		read.loadBeanDefinitions(resource);
	
		Tool tool = factory.getBean("tool", Tool.class);
		ToolFactory toolFactory = factory.getBean("&tool", ToolFactory.class);
		
		System.out.println(tool.getId());
	}
}
