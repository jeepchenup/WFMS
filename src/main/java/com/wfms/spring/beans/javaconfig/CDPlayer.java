package com.wfms.spring.beans.javaconfig;

import com.wfms.spring.beans.javaconfig.CompactDisc;
import com.wfms.spring.beans.javaconfig.MediaPlay;

public class CDPlayer implements MediaPlay {
	
	private CompactDisc cd;

	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public void play(String from) {
		cd.play(from);
	}

}
