/*global module: true */
module.exports = function (grunt) {
  'use strict';

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    meta: {
      banner: '/*! <%= pkg.title || pkg.name %> - v<%= pkg.version %> - ' +
          '<%= grunt.template.today("yyyy-mm-dd") %>\n' +
          '<%= pkg.homepage ? "* " + pkg.homepage + "\n" : "" %>' +
          '* Copyright (c) <%= grunt.template.today("yyyy") %> */'
    },
    clean: {
      options: {
        force: true
      },
      all: ['<%= pkg.folders.build %>', '<%= pkg.folders.wwwRoot %>/images', '<%= pkg.folders.wwwRoot %>/font', '<%= pkg.folders.wwwRoot %>/libs', '<%= pkg.folders.wwwRoot %>/stylesheets']
    },
    jshint: {
      src: '<%= pkg.folders.jsSource %>**/*.js',
      options: {
        jshintrc: '.jshintrc'
      }
    },
    watch: {
      javascript: {
        files: ['<%= pkg.folders.jsSource %>**/*.js'],
        tasks: ['jshint', 'karma:unit:run'],
        options: {
          livereload: true
        }
      },
      unit_tests: {
        files: ['<%= pkg.folders.testRoot %>**/*.js'],
        tasks: ['karma:unit:run']
      }
    },
    copy: {
      modules: {
        files: [
          {
            expand: true,
            dest: '<%= pkg.folders.build %>',
            src: ['**', '!**/*.js', '!**/README'],
            cwd: '<%= pkg.folders.jsSource %>'
          }
        ]
      },
      auradirectives: {
        files: [
          {
            expand: true,
            dest: '<%= pkg.folders.wwwRoot %>/stylesheets',
            src: ['angular-csp.css'],
            cwd: '<%= pkg.folders.bowerComponents %>angular'
          }
        ]
      },
      aurastyleguide: {
        files: [
          {
            expand: true,
            dest: '<%= pkg.folders.wwwRoot %>',
            src: ['font/**/*', 'images/*', 'stylesheets/print-aura.css', 'stylesheets/screen-aura.css', 'libs/**/*'],
            cwd: '<%= pkg.folders.bowerComponents %>aura-styleguide/dist'
          }
        ]
      }
    },
    karma: {
      options: {},
      unit: {
        options: {
          background: true,
          configFile: '<%= pkg.folders.testRoot %>karma.conf.js'
        }
      },
      ci: {
        options: {
          singleRun: true,
          configFile: '<%= pkg.folders.testRoot %>karma.conf.ci.js'
        }
      }
    },
    requirejs: {
      compile: {
        options: {
          baseUrl: '<%= pkg.folders.jsSource %>',
          name: '../<%= pkg.folders.bowerComponents %>requirejs/require',
          include: 'main',
          mainConfigFile: '<%= pkg.folders.jsSource %>/main.js',
          out: '<%= pkg.folders.build %>/main.js',
          optimize: 'none',
          generateSourceMaps: false,
          preserveLicenseComments: false,
          useSourceUrl: false
        }
      }
    },
    license: {
      options: {
        unknown: true,
        start: '.',
        depth: null,
        output: 'file'
      }
    }
  });

  grunt.registerTask('build', 'Construir los js de la aplicación',
      function () {
        //grunt.task.run('jshint');
        grunt.task.run('clean:all');
        grunt.task.run('requirejs');
        grunt.task.run('copy:modules');
        grunt.task.run('copy:auradirectives');
        grunt.task.run('copy:aurastyleguide');
      }
  );

  grunt.registerTask('license', 'Lista de licencias de los js que se usan en esta aplicación', function () {
    function convertToCsv(data) {
      var ret = '', module, licenses, repository;

      for (module in data) {
        if (data.hasOwnProperty(module)) {
          licenses = data[module].licenses || '';
          repository = data[module].repository || '';
          ret = ret + module + ';' + licenses + ';' + repository + '\r\n';
        }
      }

      return ret;
    }

    var checker = require('license-checker'),
        fs = require('fs'),
        done = this.async(),
        defaults = {
          start: '.',
          unknown: false,
          depth: 1,
          include: 'all',
          output: 'console', //console or file
          filename: 'LICENSES',
          format: 'json' //json or csv
        },
        options = grunt.util._.extend(defaults, this.options());

    checker.init(options, function (data) {
      if (options.format === 'csv') {
        data = convertToCsv(data);
      } else {
        data = JSON.stringify(data, null, 4);
      }

      if (options.output === 'file') {
        fs.writeFile(options.filename, data, function () {
          console.log('Successfully written '.green + options.filename.grey);
          done();
        });
      } else if (options.output === 'console') {
        grunt.log.writeln(data);
      } else {
        grunt.log.writeln('Unknown output channel: ' + options.output);
      }
    });
  });

  grunt.registerTask('unit', ['karma:unit', 'watch']);

  require('matchdep').filterDev('grunt-*').forEach(grunt.loadNpmTasks);
};
