package com.wfms.spring.beans.outerproperty;

import org.springframework.beans.factory.annotation.Value;

public class BlankDisc2 {
	private final String title;
	private final String artist;

	public BlankDisc2(@Value("${disc.title}") String title, @Value("${disc.artist}") String artist) {
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return "BlankDisc [title=" + title + ", artist=" + artist + "]";
	}
}
