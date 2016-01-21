package com.nemsolutions.aurabase.commands.developmentScenario;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemsolutions.aurabase.components.generic.GenericService;
import com.nemsolutions.aurabase.components.generic.TestService;
import com.nemsolutions.aurabase.components.generic.builder.Test2Builder;
import com.nemsolutions.aurabase.components.generic.builder.TestBuilder;
import com.nemsolutions.aurabase.components.generic.builder.TranslationBuilder;
import com.nemsolutions.aurabase.components.generic.builder.AppBuilder;

import com.nemsolutions.aurabase.components.generic.model.Test;
import com.nemsolutions.aurabase.components.generic.model.Test2;
import com.nemsolutions.aurabase.constants.ConsoleConstants;
import com.nemsolutions.auracore.commands.Command;
import com.nemsolutions.language.app.AppService;
import com.nemsolutions.language.app.model.App;
//import com.nemsolutions.language.language.LanguageService;
//import com.nemsolutions.language.language.model.Language;
import com.nemsolutions.language.translation.TranslationService;
import com.nemsolutions.language.translation.model.Translation;


@Service
public class DevelopmentScenarioCommand implements Command {
	private static final Logger logger = LoggerFactory.getLogger(DevelopmentScenarioCommand.class);
	public static final String SHORT_CODE = "create_development_scenario";
	public static final String DESCRIPTION = "Create development scenario";
		
	private DataDeleteService dataDeleteService;
	private GenericService genericService;
	private TestService testService;
	private AppService appService;
////	private LanguageService languageService;
	private TranslationService translationService;
	
	@Autowired
	public void setDataDeleteService(DataDeleteService dataDeleteService) {
		this.dataDeleteService = dataDeleteService;
	}
	@Autowired
	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}
	@Autowired
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	@Autowired
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
//	
////	@Autowired
////	public void setLanguageService(LanguageService languageService) {
////		this.languageService = languageService;
////	}
//	
	@Autowired
	public void setTranslationService(TranslationService translationService) {
		this.translationService = translationService;
	}
	
	public static Option getOption() {
		Option opt = new Option(SHORT_CODE, false, DESCRIPTION);
		return opt;
	}

	@Override
	public void execute() {
		clearOldData();
		createScenario();
		endScenario();
	}

	private void clearOldData() {
		logger.info("########################################################################");
		logger.info("## C L E A R I N G    D E V E L O P M E N T  S C E N A R I O ###########");
        logger.info("########################################################################");
		logger.info(String.format("### Clearing development scenario for %d clientId: ####################", ConsoleConstants.DEVELOPMENT_SCENARIO_CLIENT_ID));
		dataDeleteService.deleteData();
	}
	
	private void createScenario() {
		logger.info("########################################################################");
		logger.info("## C R E A T I N G    D E V E L O P M E N T  S C E N A R I O ###########");
		logger.info("########################################################################");
		logger.info(String.format("### Creating development scenario for %d clientId: ####################", ConsoleConstants.DEVELOPMENT_SCENARIO_CLIENT_ID));
		
		TestBuilder testBuilder = new TestBuilder();
		Test2Builder test2Builder = new Test2Builder();
		AppBuilder appBuilder = new AppBuilder();
//		LanguageBuilder languageBuilder = new LanguageBuilder();
		TranslationBuilder translationBuilder = new TranslationBuilder();
		
		List<Test> tests = new ArrayList<Test>();
		List<Test2> tests2 = new ArrayList<Test2>();	
		
		List<App> apps = new ArrayList<App>();
//		List<Language> languages = new ArrayList<Language>();
		List<Translation> translations = new ArrayList<Translation>();

		for(int i=1; i < ConsoleConstants.DEVELOPMENT_SCENARIO_NUMBER_OF_TESTS+30; i++){
			tests.add(testBuilder.randomFor(i).build());
			tests2.add(test2Builder.randomFor(i).build());
			
			
////			languages.add(languageBuilder.randomFor(i).build());
			translations.add(translationBuilder.randomFor(i).build());
		}
		for(int i=0; i < 5; i++){
			apps.add(appBuilder.randomFor(i).build());
		}
		
		genericService.saveAllTests(tests);
		testService.saveAllTests2(tests2);
		appService.saveAllApps(apps);
//		languageService.saveAllLanguages(languages);
		translationService.saveAllTranslations(translations);
		
		logger.info(String.format("##### Projects: %d created.",tests.size()));
	}	

	private void endScenario() {
		logger.info("########################################################################");
		logger.info("## E N D    D E V E L O P M E N T  S C E N A R I O #####################");
		logger.info("########################################################################");
	}

	
}