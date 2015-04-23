noExcel.controller('RegistrationController',
    function($scope, $location){
        $scope.login = function(){
            $location.path('/register');
        }
    }
)