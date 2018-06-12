package com.wfms.spring.beans.advanced.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.beans.primary.Cold;
import com.wfms.spring.beans.primary.Creamy;
import com.wfms.spring.beans.primary.Dessert;
import com.wfms.spring.beans.primary.DessertConfig;
import com.wfms.spring.beans.primary.IceCream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DessertConfig.class)
public class PrimaryTest {

	@Autowired
	private IceCream ice;
	
	@Autowired
	@Creamy
	private Dessert dessert;
	
	@Test
	public void testIceIsNotNull() {
		assertNotNull(ice);
	}
	
	@Test
	public void testDessertIsNotNull() {
		assertNotNull(dessert);
	}
	
	@Test
	public void testPrimaryOrQuolifierProperty() {
		dessert.description();
	}
	
}
