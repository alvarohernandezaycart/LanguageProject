define(function (require) {
  'use strict';

  var jquery = require('jquery');
  function BodyDirective($parse) {
    return {
      restrict: 'E',
      link: function (scope, element, attrs) {
    	  if(jquery(".tabopts").length>0){
    		  element.addClass("body--tabopts");
    	  }
    	  else{
    		  element.addClass("body--solo");
    	  }
      }
    };
  }

  BodyDirective.$inject = ['$parse'];

  return BodyDirective;
});