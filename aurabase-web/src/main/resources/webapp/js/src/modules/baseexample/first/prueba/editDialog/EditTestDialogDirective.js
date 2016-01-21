define(function (require) {
	'use strict';
	
	//var Duration = require('aura/types/Duration');

	var tpl = require('text!./editTestDialog.html');
	
	function EditTestDialogDirective($filter, TestService, MessageHelper, UtilsHelper, ngDialog){
		
		function controller($scope, $element, $attrs){
			
			$scope.testDialog = {};		
			$scope.testDialog.Test = {};			
			$scope.createTest = openDialog;
			$scope.showTestData = showTestData;
			$scope.submit = submitForm;
			$scope.submitUpdate = submitFormUpdate;
			
			$scope.testDialog.id;
			$scope.testDialog.name;
			$scope.testDialog.surname;
			$scope.testDialog.tlfNumber;
			$scope.testDialog.address;
			$scope.editTest = openEditDialog;
			
			$scope.closeEditPopup = closeEditPopup;

			$scope.$on('ngDialog.closed', function (e, $dialog) {
			    $scope.onClose();
			});

			function initPopup() {
				$scope.testDialog.Test = {};
				$scope.testDialog.id = null;
				$scope.testDialog.name = 'name';
				$scope.testDialog.surname = 'surname';
				$scope.testDialog.tlfNumber = 'tlfNumber';
				$scope.testDialog.address = 'address';
			
			}

			
			function submitForm() {

				TestService.saveTest($scope.testDialog.id, $scope.testDialog.name, $scope.testDialog.surname, $scope.testDialog.tlfNumber, $scope.testDialog.address).then(function() {
					MessageHelper.showMessageToBeTranslated("success", "message.success.save.test.ok");
					closeEditPopup();
				});	

			}
			
			function submitFormUpdate() {

				TestService.updateTest($scope.testDialog.id, $scope.testDialog.name, $scope.testDialog.surname, $scope.testDialog.tlfNumber, $scope.testDialog.address).then(function() {
					MessageHelper.showMessageToBeTranslated("success", "message.success.update.test.ok");
					closeEditPopup();
				});	

			}
							
			function openDialog(){
				initPopup();
				$scope.testDialog.editId = true;
				$scope.testDialog.show = true;
				openPopup();
			}
			
			function openEditDialog(test) {
				
				$scope.testDialog.id = test.id;
				$scope.testDialog.name = test.name;
				$scope.testDialog.surname = test.surname;
				$scope.testDialog.tlfNumber = test.tlfNumber;
				$scope.testDialog.address = test.address;
				$scope.testDialog.show = true;
				$scope.testDialog.editId = false;
				
				openPopup();
		
			}
			
			function showTestData(test) {

				$scope.testDialog.id = test.id;
				$scope.testDialog.name = test.name;
				$scope.testDialog.surname = test.surname;
				$scope.testDialog.tlfNumber = test.tlfNumber;
				$scope.testDialog.address = test.address;
				$scope.testDialog.show = false;
				$scope.testDialog.editId = false;
							
				openPopup();

			}
			
			function submitUpdate() {
				
			}
			
			function closeEditPopup(){
				ngDialog.close();
			}
			
			function openPopup() {
				ngDialog.open({
					template: 'editTestPopup.html',
					showClose: false,
					disableAnimation: true,
					closeByDocument: false,
					className: 'ngdialog-aura',
			  		scope: $scope
			  	});
			}
		}
			
		return{
			restrict:'E',
			template: tpl,
			scope: {
				control: '=',
				onClose: '&',
			},
			replace: true,
			controller:controller,
			link: function (scope, element, attrs) {
				scope.control = scope.control || {};
				scope.control.createTest = scope.createTest;
				scope.control.editTest = scope.editTest;
				scope.control.activeEdit = scope.activeEdit;
				scope.control.showTestData = scope.showTestData;
			}
		};
	}
	
	EditTestDialogDirective.$inject = ['$filter', 'TestService', 'MessageHelper', 'UtilsHelper', 'ngDialog'];
	
	return EditTestDialogDirective;
});


