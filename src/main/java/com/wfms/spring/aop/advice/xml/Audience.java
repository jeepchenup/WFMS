package com.wfms.spring.aop.advice.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	
	public void silenceCellPhones() {
		System.out.println("silencing cell phone.");
	}
	
	public void takeSeats() {
		System.out.println("Taking seats.");
	}
	
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}
	
	public void demandRefund() {
		System.out.println("Demanding a refund.");
	}
	
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("silencing cell phone.");
			System.out.println("Taking seats.");
			jp.proceed();
			System.out.println("CLAP CLAP CLAP!!!");
		} catch (Throwable e) {
			System.out.println("Demanding a refund.");
		}
		
	}
}
