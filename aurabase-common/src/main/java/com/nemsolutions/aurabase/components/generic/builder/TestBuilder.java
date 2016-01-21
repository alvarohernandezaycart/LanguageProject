package com.nemsolutions.aurabase.components.generic.builder;

import com.nemsolutions.aurabase.components.generic.model.Test;
import com.nemsolutions.auracore.builder.Builder;

public class TestBuilder extends Builder<Test> {
		
	public TestBuilder() {
	}

	private TestBuilder(Test instance) {
		super(instance);
	}

	public TestBuilder randomFor(Integer i) {
		instance = new Test(i, randomName(i));
		return new TestBuilder(instance);
	}


	private String randomName(int i) {
		return "Test "+i;
	}

}