package com.wfms.spring.aop.advice.xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	public Actor actor() {
		return new Actor();
	}
}
