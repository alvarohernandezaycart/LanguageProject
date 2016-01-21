package com.nemsolutions.aurabase.controller.json.prueba;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nemsolutions.aurabase.components.generic.TestService;
import com.nemsolutions.aurabase.components.generic.dto.TestDetail2;
import com.nemsolutions.aurabase.components.generic.model.Test2;
import com.nemsolutions.aurabase.dto.TestDto;
import com.nemsolutions.aurabase.util.StringMapperToClass;

@RestController
@RequestMapping(value = "/prueba")
public class TestJsonController {
	
	private TestService testService;//JAVA	
	

	private StringMapperToClass stringMapperToClass;
	
	@Autowired	
	public void setWoService(TestService TestService) {
		this.testService = TestService;
	}
	
	@Autowired	
	public void setStringMapperToClass(StringMapperToClass stringMapperToClass) {
		this.stringMapperToClass = stringMapperToClass;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<TestDetail2>> getTestList() throws Exception {
		
		List<TestDetail2> tests = testService.getAllTests();
		return new ResponseEntity<List<TestDetail2>>(tests, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/test/{testId}", method = RequestMethod.GET)
	public ResponseEntity<List<TestDetail2>>getTest(@PathVariable Integer testId) throws Exception {
		List<TestDetail2> tests = testService.getTest(testId);
		return new ResponseEntity<List<TestDetail2>>(tests, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/delete/{testId}", method = RequestMethod.DELETE)
	public ResponseEntity<Test2> removeTest(@PathVariable Integer testId) throws Exception {
		
		return new ResponseEntity<Test2>((testService.remove(testId))? HttpStatus.OK : HttpStatus.BAD_REQUEST);		
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Test2> restSave(@RequestBody String body) throws Exception {

		TestDto postData = stringMapperToClass.filterMapper(body, TestDto.class);
		if (postData != null) {
			testService.saveTest(postData.getId(), postData.getName(),
					postData.getSurname(), postData.getTlfNumber(),
					postData.getAddress());

			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Test2> restUpdate(@RequestBody String body) throws Exception {

		TestDto postData = stringMapperToClass.filterMapper(body, TestDto.class);
		
		if (postData != null) {
			testService.updateTest(postData.getId(), postData.getName(),
					postData.getSurname(), postData.getTlfNumber(),
					postData.getAddress());

			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
 