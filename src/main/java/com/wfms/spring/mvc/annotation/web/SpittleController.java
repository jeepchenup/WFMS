package com.wfms.spring.mvc.annotation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wfms.spring.mvc.annotation.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
			
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model, 
									 @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max, 
									 @RequestParam(value="count", defaultValue="20") int count) {
		model.addAttribute("spittlesList", spittleRepository.findSpittles(max, count));
		return "spittles";
	}
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String showSpittle(Model model,
											@RequestParam(value="spittle_id") long spittleId) {
		model.addAttribute("spittle", spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String spittle(Model model,
									@PathVariable long spittleId) {
		model.addAttribute("spittle", spittleRepository.findOne(spittleId));
		return "spittle";
	}
}
