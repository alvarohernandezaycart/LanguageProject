define(function () {
  'use strict';

  function range(from, to) {
    var numbers = [from];
    while (from < to)
      numbers.push(++from);
    return numbers;
  }

  return function ($window) {
    function back() {
      $window.history.back();
    }

    return {
      range: range,
      back: back
    };
  };
});