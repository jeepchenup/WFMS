package com.wfms.spring.beans.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Cake implements Dessert {

	@Override
	public void description() {
		System.out.println("This is a cake.");
	}
}
