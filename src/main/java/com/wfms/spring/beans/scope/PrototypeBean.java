package com.wfms.spring.beans.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PrototypeBean {

	public static int count = 1;

	public PrototypeBean() {
		count ++;
	}
	
}
