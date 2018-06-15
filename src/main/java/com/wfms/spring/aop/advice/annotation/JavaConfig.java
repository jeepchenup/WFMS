package com.wfms.spring.aop.advice.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JavaConfig {

	@Bean
	public DogPerformance dogPerformance() {
		return new DogPerformance();
	}
	
}
