package com.wfms.spring.aop.advice.annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class TrackCounterConfig {

	@Bean
	public CompactDisc sgtPeppers() {
		BlankDisc blankDisc = new BlankDisc();
		blankDisc.setArtist("The Beatles");
		blankDisc.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
		List<String> tracks = new ArrayList<String>();
		tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
		tracks.add("With a Little Help from My Friends");
		blankDisc.setTracks(tracks);
		return blankDisc;
	}
	
	@Bean
	public TrackCounter trackCounter() {
		return new TrackCounter();
	}
}
