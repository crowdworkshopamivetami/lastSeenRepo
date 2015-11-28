
	
var app = angular.module('lastSeen', []);

app.controller('mainCtrl', function($scope, $http, $location){

	var baseUrl = 'http://' + $location.host() + ':' + $location.port() + '/lastSeen';


	$scope.user = "";
	$scope.response = "";
	$scope.DBnotOk = false;
    $scope.DBok=false;
	
	$scope.restTest = function(){
		$http({method: 'GET', url: baseUrl + '/rest/testRest/sayHello?name='+$scope.user}).success(
			function(data, status, response, header) {
				$scope.response = data.message;
			}).error(
             function(data, status, response, header){
           		$scope.response = "DB problems.";
           	});
	}
	
	$scope.dbConnectionTest = function(){
		 $http({method: 'GET', url: baseUrl +'/rest/testRest/findAllContacts'}).success(
            function(data, status, response, header) {
				$scope.DBok = true;
				$scope.DBnotOk = false;
				$scope.contacts = data.data;

			}).error(
			function(data, status, response, header){
				$scope.DBnotOk = true;
				$scope.DBok=false;
			});
			
		
			

	}

})