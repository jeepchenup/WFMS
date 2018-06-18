package com.wfms.spring.mvc.annotation.data;

import java.util.List;

import com.wfms.spring.mvc.annotation.model.Spittle;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
	
	Spittle findOne(long id);
}
