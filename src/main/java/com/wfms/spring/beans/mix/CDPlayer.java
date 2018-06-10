package com.wfms.spring.beans.mix;

public class CDPlayer implements MediaPlay {
	
	private CompactDisc compactDisc;
	
	public CDPlayer(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}

	@Override
	public void play() {
		compactDisc.play();
	}

}
