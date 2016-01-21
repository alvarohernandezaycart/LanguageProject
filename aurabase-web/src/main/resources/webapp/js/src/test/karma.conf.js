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

		browsers: ['Chrome'],

		plugins: [
			'karma-requirejs',
			'karma-jasmine',
			'karma-chrome-launcher'
		],

    reporters: ['dots']
	});
};