package com.nemsolutions.aurabase.components.generic.dao;

import com.nemsolutions.aurabase.components.generic.model.Test;


public interface TestDao{
	Test getTestById(Integer id);
	void save(Test test);
}