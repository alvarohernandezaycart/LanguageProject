define(function () {
	'use strict';

	function TestPatternsService($http) {

		function getTestPatternsRequest() {
			return '/prueba/';
		}
		
		function parseResponse(response) {
			return response.data;
		}
		
		function getAllTests() {
			return $http.get(getTestPatternsRequest() + 'list/').then(parseResponse);
		}
		
		function getTest(testId) {
			return $http.get(getTestPatternsRequest() + 'test/' + testId + '/').then(parseResponse);
		}
		
		function deleteTest(testId) {
			return $http.delete(getTestPatternsRequest() + 'delete/' + testId + '/');
		}
		
		function saveTest(id, name, surname, tlfNumber, address){
			var postBody = {'id': id, 
					'name': name, 
					'surname': surname,
					'tlfNumber': tlfNumber,
					'address': address};
			return $http.post(getTestPatternsRequest() + 'save/', postBody).then(parseResponse);
		};
		
		function updateTest(id, name, surname, tlfNumber, address){
			var postBody = {'id': id, 
					'name': name, 
					'surname': surname,
					'tlfNumber': tlfNumber,
					'address': address};
			return $http.post(getTestPatternsRequest() + 'update/', postBody).then(parseResponse);
		};

		return {
			getAllTests: getAllTests,
			getTest: getTest,
			deleteTest: deleteTest,
			saveTest:saveTest,
			updateTest:updateTest,
		};
		
		
	}
	
	TestPatternsService.$inject = ['$http'];

	return TestPatternsService;
});