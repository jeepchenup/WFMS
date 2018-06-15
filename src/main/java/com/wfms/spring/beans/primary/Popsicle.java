package com.wfms.spring.beans.primary;

import org.springframework.stereotype.Component;

@Component
@Creamy
public class Popsicle implements Dessert {

	@Override
	public void description() {
		System.out.println("This is popsicle.");
	}

}
