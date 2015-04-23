var noExcel = angular.module('noExcel', ['ngMaterial', 'ngRoute', 'ngMessages', 'appController']);

var appController = angular.module('appController',[]);
 //   .controller('ListController', ['$scope', '$http', function($scope, $http){

   // }]);


noExcel.config(['$routeProvider', function($routeProvider, $mdThemingProvider){
  $routeProvider.
      when('/login',{
          templateUrl: '/login.html',
          controller: 'RegistrationController'
      }).
      when('/register',{
          templateUrl: 'views/register.html',
          controller: 'RegistrationController'
      }).
      when('/admin',{
          templateUrl: '/index.html',
          controller: 'AdminController'
      }).
      otherwise({
         redirectTo: '/login'
      });
}]);

noExcel.config(function($mdThemingProvider){
    $mdThemingProvider.theme('green').dark();
})