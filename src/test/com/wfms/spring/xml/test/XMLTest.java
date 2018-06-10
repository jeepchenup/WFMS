package com.wfms.spring.xml.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wfms.spring.beans.xml.BlankDisc;
import com.wfms.spring.beans.xml.BlankDiscList;
import com.wfms.spring.beans.xml.BlankDiscListProperty;
import com.wfms.spring.beans.xml.CDPlayer;
import com.wfms.spring.beans.xml.CDPlayerProperty;
import com.wfms.spring.beans.xml.SgtPeppers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:application.xml", "classpath:list-BlankDiscBean.xml" ,"classpath:CDPlayerProperty-bean.xml", "classpath:BlankDiscListProperty-bean.xml"})
public class XMLTest {

	@Autowired
	private SgtPeppers sgtPeppers;
	
	@Autowired
	private CDPlayer cdPlayer;
	
	@Autowired
	private BlankDisc blankDisc;
	
	@Autowired
	private BlankDiscList blankDiscList;
	
	@Autowired
	private CDPlayerProperty cdPlayerProperty;
	
	@Autowired
	private BlankDiscListProperty blankDiscListProperty;
	
	@Test
	public void testSgtPeppersIsNotNull() {
		assertNotNull(sgtPeppers);
	}
	
	@Test
	public void testCDPlayerIsNotNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testBlankDiscIsNotNull() {
		assertNotNull(blankDisc);
	}
	
	@Test
	public void testBlankDiscListIsNotNull() {
		assertNotNull(blankDiscList);
	}
	
	@Test
	public void testCDPlayerPropertyIsNotNull() {
		assertNotNull(cdPlayerProperty);
	}
	
	@Test
	public void testBlankDiscListPropertyIsNotNull() {
		assertNotNull(blankDiscListProperty);
	}
	
	@Test
	public void testCDPlayerPlayMethod() {
		cdPlayer.play();
	}
	
	@Test
	public void testBlankDiscPlayMethod() {
		blankDisc.play();
	}
	
	@Test
	public void testBlankDiscListPlayMethod() {
		blankDiscList.play();
	}
	
	@Test
	public void testCDPlayerPropertyPlayMethod() {
		cdPlayerProperty.play();
	}
	
	@Test
	public void testBlankDiscListPropertyPlayMethod() {
		blankDiscListProperty.play();
	}
}
