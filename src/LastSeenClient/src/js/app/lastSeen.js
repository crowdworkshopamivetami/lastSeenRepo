var lastSeen = angular.module('lastSeen', [
    'ngRoute',
    'ngAnimate',
    'addMissingPerson',
    'missingPersons',
    'headerCtrl',
    'trackYourTripMainCtrl',
    'loginCtrl'
]);

lastSeen.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/missingPersons', {
                templateUrl: 'LastSeenClient/src/js/missingPerson/missingPersons.html',
                controller: 'missingPersonsController'
            }).
            when('/addMissingPerson', {
                templateUrl: 'LastSeenClient/src/js/missingPerson/addMissingPerson.html',
                controller: 'addMissingPersonsController'
            }).
            when('/trackYourTrip', {
                templateUrl: 'LastSeenClient/src/js/tripTracker/trackYourTripMain.html',
                controller: 'trackYourTripMainController'
            }).
            when('/login', {
                templateUrl: 'LastSeenClient/src/js/login/loginPage.html',
                controller: 'loginController'
            }).
            when('/about', {
                templateUrl: 'LastSeenClient/src/js/about/about.html',
            }).
            otherwise({
                redirectTo: '/missingPersons'
            });
    }]);