package com.wfms.spring.beans.xml;

public class CDPlayerProperty implements MediaPlay{
	
	private CompactDisc cd;
	
	public void setCd(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public void play() {
		cd.play();
	}

}
