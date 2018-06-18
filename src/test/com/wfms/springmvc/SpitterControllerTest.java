package com.wfms.springmvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.wfms.spring.mvc.annotation.data.SpitterRepository;
import com.wfms.spring.mvc.annotation.model.Spitter;
import com.wfms.spring.mvc.annotation.web.SpitterController;

public class SpitterControllerTest {

	@Test
	public void testShowRegistrationForm() throws Exception {
		SpitterController controller = new SpitterController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/register"))
						.andExpect(view().name("registerForm"));
	}
	
	@Test
	public void testProcessRegistration() throws Exception {
		SpitterRepository mockSpitterRepository = mock(SpitterRepository.class);
		
		Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
	    Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
	    when(mockSpitterRepository.save(unsaved)).thenReturn(saved);
	    
	    SpitterController controller = new SpitterController(mockSpitterRepository);
	    MockMvc mockMvc = standaloneSetup(controller).build();
	    
	    mockMvc.perform(post("/spitter/register")
	    							 .param("firstName", "Jack")
	    							 .param("lastName", "Bauer")
	    							 .param("username", "jbauer")
	    							 .param("password", "24hours")
	    							 .param("email", "jbauer@ctu.gov"))
	    							.andExpect(redirectedUrl("/spitter/jbauer"));
	}
}
