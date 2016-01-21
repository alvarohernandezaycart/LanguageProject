package com.nemsolutions.aurabase.components.generic.builder;

import com.nemsolutions.aurabase.components.generic.model.Test2;
import com.nemsolutions.auracore.builder.Builder;

public class Test2Builder extends Builder<Test2> {
		
	public Test2Builder() {
	}

	private Test2Builder(Test2 instance) {
		super(instance);
	}

	public Test2Builder randomFor(Integer i) {
		instance = new Test2(i, randomName(i),randomSurname(i), randomTlf(i), randomAddress(i));
		return new Test2Builder(instance);
	}


	private String randomSurname(Integer i) {
		// TODO Auto-generated method stub
		return "Surname " + i;
	}

	private String randomTlf(Integer i) {
		// TODO Auto-generated method stub
		return "Tlf " + i;
	}

	private String randomAddress(Integer i) {
		// TODO Auto-generated method stub
		return "Address " + i;
	}

	private String randomName(int i) {
		return "Test "+i;
	}

}