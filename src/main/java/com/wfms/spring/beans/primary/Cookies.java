package com.wfms.spring.beans.primary;

import org.springframework.stereotype.Component;

@Component
public class Cookies implements Dessert {

	@Override
	public void description() {
		System.out.println("This is a cookies.");
	}
}
