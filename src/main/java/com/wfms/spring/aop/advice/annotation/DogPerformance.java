package com.wfms.spring.aop.advice.annotation;

public class DogPerformance implements Performance {

	@Override
	public void perform() {
		System.out.println("dog is performing");
	}

}
