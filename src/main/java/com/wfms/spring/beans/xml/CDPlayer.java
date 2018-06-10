package com.wfms.spring.beans.xml;

public class CDPlayer implements MediaPlay {
	
	private CompactDisc cd;
	
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public void play() {
		cd.play();
	}

}
