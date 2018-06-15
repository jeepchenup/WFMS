package com.wfms.spring.beans.outerproperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertySourcesPlaceholderConfig {

	@Value("${disc.title}")
	private String title;
	
	@Value("${disc.artist}")
	private String artist;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		final PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("/SpringEL/app.properties"));
		return propertySourcesPlaceholderConfigurer;
	}
	
	@Bean
	public BlankDisc2 blankDisc() {
		return new BlankDisc2(title, artist);
	}
}
