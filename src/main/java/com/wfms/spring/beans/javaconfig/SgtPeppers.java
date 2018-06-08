package com.wfms.spring.beans.javaconfig;

public class SgtPeppers implements CompactDisc {

	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";

	@Override
	public void play(String from) {
		System.out.println("Playing " + title + " by " + artist + " from " + from);
	}

}
