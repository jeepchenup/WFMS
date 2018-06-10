package com.wfms.spring.mixed;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.beans.mix.BlankDisc;
import com.wfms.spring.beans.mix.SystemConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SystemConfig.class)
public class MixedTest {

	@Autowired
	private BlankDisc blankDisc;
	
	@Test
	public void testBlankDiscIsNotNull() {
		assertNotNull(blankDisc);
	}
	
	@Test
	public void testBlankDiscPlayMethod() {
		blankDisc.play();
	}
}
