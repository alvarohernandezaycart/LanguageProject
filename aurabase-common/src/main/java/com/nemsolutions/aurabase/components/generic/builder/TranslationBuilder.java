package com.nemsolutions.aurabase.components.generic.builder;

import com.nemsolutions.auracore.builder.Builder;
import com.nemsolutions.language.translation.model.Translation;

public class TranslationBuilder extends Builder<Translation> {
	
	public TranslationBuilder() {
	}

	private TranslationBuilder(Translation instance) {
		super(instance);
	}

	public TranslationBuilder randomFor(Integer i) {
		instance = new Translation(randomKey(i),randomValue(i),null, null,i,i);
		return new TranslationBuilder(instance);
	}

	private String randomValue(int i) {
		return "Code "+i;
	}
	
	
	private String randomKey(int i) {
		return "Key "+i;
	}
}