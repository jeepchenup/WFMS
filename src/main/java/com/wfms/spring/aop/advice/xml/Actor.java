package com.wfms.spring.aop.advice.xml;

public class Actor implements Performance {

	@Override
	public void perform() {
		System.out.println("------>The actor is performing.");
	}

}
