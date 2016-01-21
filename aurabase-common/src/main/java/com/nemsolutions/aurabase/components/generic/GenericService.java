package com.nemsolutions.aurabase.components.generic;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemsolutions.aurabase.components.generic.dao.TestDao;
import com.nemsolutions.aurabase.components.generic.dao.Test2Dao;
import com.nemsolutions.aurabase.components.generic.dto.TestDetail;
import com.nemsolutions.aurabase.components.generic.dto.TestDetail2;
import com.nemsolutions.aurabase.components.generic.model.Test;
import com.nemsolutions.aurabase.components.generic.model.Test2;

@Service
@Transactional
public class GenericService {
	
	private TestDao testDao;
	
	@Autowired
	public void setCodeDao(TestDao testDao) {
		this.testDao = testDao;
	}
	
	public TestDetail getTest(Integer testId){
		Test t = testDao.getTestById(testId);
		TestDetail td = new TestDetail(t.getId(), t.getName());
		return td;
	}
	
	public void saveAllTests(List<Test> tests){
		for(Test test : tests){
			testDao.save(test);
		}
	}
}