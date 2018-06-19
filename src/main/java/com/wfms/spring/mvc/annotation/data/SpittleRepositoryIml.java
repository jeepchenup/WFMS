package com.wfms.spring.mvc.annotation.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wfms.spring.mvc.annotation.model.Spittle;
/**
 * Just used for display
 */
@Component
public class SpittleRepositoryIml implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i = 0; i < count; i++) {
			spittles.add(new Spittle((long)i, "Spittle " + i, new Date()));
		}
		return spittles;
	}

	@Override
	public Spittle findOne(long id) {
		System.out.println("SpittleRepositoryIml findOne(" + id + ")");
		return new Spittle(id, "Hello", new Date());
	}

}
