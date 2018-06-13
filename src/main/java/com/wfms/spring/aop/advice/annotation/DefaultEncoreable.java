package com.wfms.spring.aop.advice.annotation;

public class DefaultEncoreable implements Encoreable {

	@Override
	public void performEncore() {
		System.out.println("This is a default encoreable implementation.");
	}

}
