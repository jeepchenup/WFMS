package com.wfms.spring.beans.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public class CDPlayerConfig {

	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}
	
	@Bean
	public CDPlayer cdPlayer() {
		System.out.println("invoke cdPlayer method.");
		return new CDPlayer(sgtPeppers());
	}
	
	@Bean
	public CDPlayer anotherCDPlayer() {
		System.out.println("invoke anotherCDPlayer method.");
		return new CDPlayer(sgtPeppers());
	}
}
