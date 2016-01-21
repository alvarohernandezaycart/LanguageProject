package com.nemsolutions.aurabase.commands;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemsolutions.auracore.commands.Command;
import com.nemsolutions.auracore.commands.OptionsFactory;
import com.nemsolutions.auracore.commands.flyway.FlywayCleanCommand;
import com.nemsolutions.auracore.commands.flyway.FlywayMigrateCommand;
import com.nemsolutions.aurabase.commands.developmentScenario.DevelopmentScenarioCommand;
import com.nemsolutions.aurabase.language.LanguageCommand;

@Service
public class CommandFactory {
	private DevelopmentScenarioCommand demoScenarioCommand;
	private FlywayCleanCommand flywayCleanCommand;
	private FlywayMigrateCommand flywayMigrateCommand;
	private static LanguageCommand languageCommand;

	@Autowired
	public void setDemoScenarioCommand(DevelopmentScenarioCommand demoScenarioCommand) {
		this.demoScenarioCommand = demoScenarioCommand;
	}
	
	@Autowired
	public void setFlywayCleanCommand(FlywayCleanCommand flywayCleanCommand) {
		this.flywayCleanCommand = flywayCleanCommand;
	}
	
	@Autowired
	public void setFlywayMigrateCommand(FlywayMigrateCommand flywayMigrateCommand) {
		this.flywayMigrateCommand = flywayMigrateCommand;
	}
	
	@Autowired
	public void setLanguageCommand(LanguageCommand languageCommand) {
		this.languageCommand = languageCommand;
	}

	public Command get(CommandLine cli) {
		if (cli.hasOption(DevelopmentScenarioCommand.SHORT_CODE)) {      
			return demoScenarioCommand;
		}

		if (cli.hasOption(FlywayMigrateCommand.SHORT_CODE)){
			return flywayMigrateCommand;
		}

		if (cli.hasOption(FlywayCleanCommand.SHORT_CODE)){
			return flywayCleanCommand;
		}
		
		if (cli.hasOption(LanguageCommand.SHORT_CODE)){
			return languageCommand;
		}
		throw new IllegalArgumentException();
	}

	public static Options getOptions() {
		Options options = OptionsFactory.basic();
		options.addOption(FlywayMigrateCommand.getOption());
		options.addOption(FlywayCleanCommand.getOption());
		options.addOption(DevelopmentScenarioCommand.getOption());
		options.addOption(languageCommand.getOption());
		return options;
	}
}
