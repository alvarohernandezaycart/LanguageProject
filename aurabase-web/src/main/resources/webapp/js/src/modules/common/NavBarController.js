define(function () {
  'use strict';

  function NavBarController($scope, $window, $translate) {
    function setCurrent(languageCode) {
      $window.sessionStorage.setItem('i18n.current', languageCode);
    }

    function getCurrent() {
      return $window.sessionStorage.getItem('i18n.current');
    }

    function switchTo(language) {
      $translate.use(language);
      setCurrent(language);
    }

    function isCurrent(language) {
      return language == getCurrent();
    }

    function availables() {
      return i18n.languages;
    }

    var i18n = {
      languages: [
        {code: 'eu', name: 'Euskera'},
        {code: 'es', name: 'Castellano'},
        {code: 'en', name: 'English'}
      ]
    };
    i18n.default = i18n.languages[1];

    if (!getCurrent())
      setCurrent(i18n.default.code);
    switchTo(getCurrent());

    $scope.controller = {
      i18n: {
        switchTo: switchTo,
        isCurrent: isCurrent,
        availables: availables
      }
    };

  }

  NavBarController.$inject = ['$scope', '$window', '$translate'];

  return NavBarController;
});