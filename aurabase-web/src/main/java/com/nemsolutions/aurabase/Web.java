package com.nemsolutions.aurabase;

import com.nemsolutions.auracore.commands.CommandLineParser;
import com.nemsolutions.auracore.commands.OptionsFactory;
import com.nemsolutions.auracore.spring.SpringHelpers;
import com.nemsolutions.aurabase.config.WebRootConfiguration;
import com.typesafe.config.Config;

public class Web implements Runnable {
  private final Config config;
  private final SpringHelpers springHelpers = new SpringHelpers();

  public Web(Config config) {
    this.config = config;
  }

  public static void main(String[] args) {
    String[] configModules = {"common", "web"};
    CommandLineParser commandLineParser = new CommandLineParser(OptionsFactory.basic(), configModules);
    commandLineParser.parseArgs(args);
    new Web(commandLineParser.getConfig()).run();
  }

  @Override
  public void run() {
    springHelpers.bootstrapContext(WebRootConfiguration.class, config);
  }

}
