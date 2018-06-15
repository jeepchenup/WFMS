package com.wfms.spring.mvc.annotation.data;

import java.util.List;

import com.wfms.spring.mvc.annotation.model.Spittle;

public interface SpitterRepository {

	List<Spittle> findSpittles(long max, int count);
}
