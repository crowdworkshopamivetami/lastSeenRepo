var headerCtrl = angular.module('headerCtrl', []);

headerCtrl.controller('headerController', ['$scope', '$location', function($scope, $location){

    $scope.name = "notItzik";
    $scope.changePage = function(newPage){
        $location.path(newPage);
    };

    $scope.rebase = function(){
        $scope.name = "itzik";
    };

}]);
