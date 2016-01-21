define(function(){
	'use strict';
		
	function MenuController($scope, $filter, MenuService, MessageHelper, UtilsHelper, ngDialog){
		
		console.log("TESTCONTROLLER")
		
		function initData(){
			getTests();
		};
		
		function getTests(){
			$scope.tests = {};

			MenuService.getAllTests().then(function(data) {	
				$scope.tests = data;
				$scope.tests2 = data;
			});
		};
		
		$scope.xFunction = function(){
            return function(d) {
              return d.key;
            };
          }
        $scope.yFunction = function(){
	            return function(d){
		            return d.y;
	            };
          }
		
		function getTest(select){
			$scope.tests = {};
			
			MenuService.getTest($scope.select).then(function(data) {
				$scope.tests = data;		
			});
			
		};

		
		function onDeleteTest(test){
			$scope.testSelected = angular.copy(test);
			ngDialog.open({
				template: 'testDeleteDialog.html',
				showClose: false,
				disableAnimation: true,
				closeByDocument: false,
				className: 'ngdialog-aura',
		  		scope: $scope
		  	});
		};
		
		function confirmDeleteTest(test) {
			$scope.closeDialog();
			MenuService.deleteTest($scope.testSelected.id)
            .error(function() {
                MessageHelper.showMessageToBeTranslated("error", "message.error.delete.test");
            })
            .success(function() {
                MessageHelper.showMessageToBeTranslated("success", "message.success.delete.test");
                getTests();
            })
            .then(function(){});
		};
		
		function refreshTests(){
			$scope.tests = null;
			$scope.tests = {};
			getTest($scope.select);
		};
		
		$scope.closeDialog = function(){
			ngDialog.close();
		};
		
		$scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
	    $scope.series = ['Series A', 'Series B'];

	    $scope.data = [
	      [65, 59, 80, 81, 56, 55, 40],
	      [28, 48, 40, 19, 86, 27, 90]
	    ];
	    console.log($scope.data);
		 
		$scope.getTests = getTests;
		$scope.dialogControl = $scope.dialogControl || {};
		$scope.onDeleteTest = onDeleteTest;
		$scope.confirmDeleteTest = confirmDeleteTest;
		$scope.refreshTests = refreshTests;

		initData();
	}
	
	MenuController.$inject = ['$scope', '$filter', 'MenuService', 'MessageHelper', 'UtilsHelper','ngDialog'];
	
	return MenuController;
});