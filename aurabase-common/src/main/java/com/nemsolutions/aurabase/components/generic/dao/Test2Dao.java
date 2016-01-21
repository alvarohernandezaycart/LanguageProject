package com.nemsolutions.aurabase.components.generic.dao;

import java.util.List;

import com.nemsolutions.aurabase.components.generic.model.Test2;


public interface Test2Dao{
	Test2 getTestById(Integer id);
	void save(Test2 test2);
	List<Test2> getAllTests();
	void remove(Integer testId);
	void update(Test2 test);
}