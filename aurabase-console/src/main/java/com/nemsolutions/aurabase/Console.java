package com.nemsolutions.aurabase;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.nemsolutions.auracore.commands.CommandLineParser;
import com.nemsolutions.auracore.commands.ExitStatus;
import com.nemsolutions.auracore.config.ConsoleRootConfiguration;
import com.nemsolutions.auracore.spring.SpringHelpers;
import com.nemsolutions.aurabase.commands.CommandFactory;
import com.typesafe.config.Config;

public class Console implements Runnable {

  private static final Logger logger = LoggerFactory.getLogger(Console.class);
  private final Config config;
  private final CommandLine cli;
  private final CommandLineParser cliParser;
  private final SpringHelpers springHelpers = new SpringHelpers();


  public Console(CommandLineParser cliParser) {
    this.cliParser = cliParser;
    this.config = cliParser.getConfig();
    this.cli = cliParser.getCli();
  }

  public static void main(String[] args) {
    String[] configModules = {"common", "console"};
    Options options = CommandFactory.getOptions();
    CommandLineParser commandLineParser = new CommandLineParser(options, configModules);
    commandLineParser.parseArgs(args);
    new Console(commandLineParser).run();
  }

  @Override
  public void run() {
    ApplicationContext ctx = springHelpers.bootstrapContext(ConsoleRootConfiguration.class, config);
    CommandFactory commandFactory = ctx.getBean(CommandFactory.class);
    try {
      commandFactory.get(cli).execute();
    } catch (IllegalArgumentException e) {
      logger.error("Error parsing command line options", e);
      cliParser.showHelpAndExit(ExitStatus.ERROR);
    }
  }
}
