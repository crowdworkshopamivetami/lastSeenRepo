var loginCtrl = angular.module('loginCtrl',[]);

loginCtrl.controller('loginController', ['$scope', '$location', function($scope, $location){

    $scope.message = "loginCotroller";

}]);