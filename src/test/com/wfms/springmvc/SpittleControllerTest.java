package com.wfms.springmvc;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.wfms.spring.mvc.annotation.data.SpittleRepository;
import com.wfms.spring.mvc.annotation.model.Spittle;
import com.wfms.spring.mvc.annotation.web.SpittleController;

public class SpittleControllerTest {
	
	@Test
	public void testShowRecentSpittles() throws Exception {
		//init expected Spittle list
		List<Spittle> expectedSpittles = createSpittleList(20);
		//mock spittle repository
		SpittleRepository mockSpittleRepository = mock(SpittleRepository.class);
		//mock access /spittles and get spittle data source
		when(mockSpittleRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
		//mock controller
		SpittleController controller = new SpittleController(mockSpittleRepository);
		//mock mvc
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
																		.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
																		.build();
		mockMvc.perform(get("/spittles"))
					   .andExpect(view().name("spittles"))
					   .andExpect(model().attributeExists("spittlesList"));
	}
	
	@Test
	public void testShowPagedSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(50);
		SpittleRepository mockSpittleRepository = mock(SpittleRepository.class);
		when(mockSpittleRepository.findSpittles(238900, 50)).thenReturn(expectedSpittles);
		SpittleController controller = new SpittleController(mockSpittleRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
											.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
											.build();
		mockMvc.perform(get("/spittles.jsp?max=238900&count=50"))
						.andExpect(view().name("spittles"))
						.andExpect(model().attributeExists("spittlesList"))
						.andExpect(model().attribute("spittlesList", hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void testShowSpittle() throws Exception {
		Spittle expectedSpittle = new Spittle((long)1, "Hello", new Date());
		SpittleRepository mockSpittleRepository = mock(SpittleRepository.class);
		when(mockSpittleRepository.findOne((long)1)).thenReturn(expectedSpittle);
		SpittleController controller = new SpittleController(mockSpittleRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
																		.build();
		
		mockMvc.perform(get("/spittles/show?spittle_id=1"))
						.andExpect(view().name("spittle"))
						.andExpect(model().attributeExists("spittle"))
						.andExpect(model().attribute("spittle", expectedSpittle));
	}
	
	@Test
	public void testSpittle() throws Exception {
		Spittle expectedSpittle = new Spittle((long)1234, "Hello", new Date());
		SpittleRepository mockSpittleRepository = mock(SpittleRepository.class);
		when(mockSpittleRepository.findOne(1234)).thenReturn(expectedSpittle);
		SpittleController controller = new SpittleController(mockSpittleRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spittles/1234"))
						.andExpect(view().name("spittle"))
						.andExpect(model().attribute("spittle", expectedSpittle));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i = 0; i < count; i++) {
			spittles.add(new Spittle((long)i ,"Spittle " + i, new Date()));
		}
		return spittles;
	}
}
