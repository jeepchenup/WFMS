package com.wfms.spring.beans.javaconfig;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
	
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";  
	private String artist = "The Beatles";
	public void paly() {
		System.out.print("Playing " + title + " by " + artist);
	}

}
