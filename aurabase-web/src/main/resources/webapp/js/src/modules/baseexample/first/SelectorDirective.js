define(function (require) {
	'use strict';

	var jquery = require("jquery");

	function formatStatus(status) {
		if (!status.id) return status.text;
		return '<span class="status status--' + status.id.toLowerCase() + ' status--horizontal status--s"><span class="status__label">' + status.text + '</span></span>';
	}

	function link(scope, element, attrs){
		jquery(element).select2({
			minimumResultsForSearch : -1,
			formatResult : formatStatus,
			formatSelection : formatStatus,
			escapeMarkup : function(m) {
				return m;
			}
		});
	}

	function SelectorDirective() {
		return {
			restrict: 'A',
			link: link
		};
	}

	SelectorDirective.$inject = [];

	return SelectorDirective;
});