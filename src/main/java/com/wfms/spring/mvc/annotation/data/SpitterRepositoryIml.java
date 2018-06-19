package com.wfms.spring.mvc.annotation.data;

import org.springframework.stereotype.Component;

import com.wfms.spring.mvc.annotation.model.Spitter;

@Component
public class SpitterRepositoryIml implements SpitterRepository {

	@Override
	public Spitter save(Spitter spitter) {
		return spitter;
	}

	@Override
	public Spitter findByUsername(String username) {
		return new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
	}

}
