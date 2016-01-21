package com.nemsolutions.aurabase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nemsolutions.auracore.json.JsonMapper;

@Service
public class StringMapperToClass {
	private static final Logger logger = LoggerFactory.getLogger(StringMapperToClass.class);

	//// COMMON FILTER MAPPING
	public <T> T filterMapper(String filters, Class<T> myClass) throws Exception {
		T projectFilter = null;
		if(filters!=null && !filters.equals("") && !filters.equals("undefined")){
			try {
			projectFilter = JsonMapper.jsonToClass(filters, myClass);
			} catch (Exception ex) {
				logger.error("JsonMapper error: {}", ex.getMessage());
			}
		}
		return projectFilter;
	}
}