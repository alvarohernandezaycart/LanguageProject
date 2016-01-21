define(function (require) {
	'use strict';

	require('jquery');
	
	function MessageHelper($translate) {
		
		function showMessage(type, text) {
			Messenger.options = {
				extraClasses: 'messenger-fixed messenger-on-top',
				theme: 'flat'
			}
				
			Messenger().post({
				message: text,
			  	type: type,
			  	showCloseButton: true
			});
		}
		
		function showMessageToBeTranslated(type, textKey) {
			$translate(textKey).then(
					function(translation){
						showMessage(type, translation);
			        }
			);
		}
		
		return {
			showMessage: showMessage,
			showMessageToBeTranslated: showMessageToBeTranslated
		};
	}
	MessageHelper.$inject = ['$translate'];

	return MessageHelper;
});