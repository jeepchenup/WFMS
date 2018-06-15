package com.wfms.spring.beans.primary;

import org.springframework.stereotype.Component;

@Component
@Cold
public class IceCream implements Dessert {

	@Override
	public void description() {
		System.out.println("This is a ice cream.");
	}
}
