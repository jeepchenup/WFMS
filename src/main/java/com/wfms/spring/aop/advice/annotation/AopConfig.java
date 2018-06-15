package com.wfms.spring.aop.advice.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan
public class AopConfig {

	@Bean
	public AudienceByPointcut audience() {
		return new AudienceByPointcut();
	}
	
	@Bean
	public EncoreableIntroducer encoreableIntroducer() {
		return new EncoreableIntroducer();
	}
}
