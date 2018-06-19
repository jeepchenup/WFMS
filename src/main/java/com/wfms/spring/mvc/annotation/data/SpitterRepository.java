package com.wfms.spring.mvc.annotation.data;

import com.wfms.spring.mvc.annotation.model.Spitter;

public interface SpitterRepository {

	Spitter save(Spitter spitter);

	Spitter findByUsername(String username);
}
