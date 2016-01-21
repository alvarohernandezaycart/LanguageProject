/*global module: true */
module.exports = function (config) {
  "use strict";
  config.set({
    basePath: '../',

    files: [
      'test/main-test.js',
      {pattern: 'bower_components/**/*', included: false},
      {pattern: 'node_modules/**/*', included: false},
      {pattern: 'non_bower_components/**/*', included: false},
      {pattern: 'test/unit/**/*', included: false},
      {pattern: 'modules/**/*', included: false}
    ],

    autoWatch: false,

    frameworks: ['jasmine', 'requirejs'],

    browsers: ['PhantomJS'],

    plugins: [
      'karma-requirejs',
      'karma-jasmine',
      'karma-phantomjs-launcher',
      'karma-junit-reporter',
      'karma-coverage'
    ],

    reporters: ['junit', 'coverage'],

    junitReporter: {
      outputFile: 'test-results/unit-tests.xml'
    },

    coverageReporter: {
      type: 'cobertura',
      dir: 'test-results/',
      file: 'coverage.xml'
    },

    preprocessors: {
      'src/**/*.js': 'coverage'
    }
  });
};