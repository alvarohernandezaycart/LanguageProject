define(function () {
  'use strict';

  function InputDirective($parse) {
    return {
      restrict: 'E',
      require: '?ngModel',
      link: function (scope, element, attrs) {
        if (!attrs.hasOwnProperty('modelIgnoreValue') && attrs.ngModel && attrs.value && attrs.value !== '')
          $parse(attrs.ngModel).assign(scope, attrs.value);
      }
    };
  }

  InputDirective.$inject = ['$parse'];

  return InputDirective;
});