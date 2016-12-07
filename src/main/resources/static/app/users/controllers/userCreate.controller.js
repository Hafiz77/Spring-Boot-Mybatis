(function() {
    'use strict'
    angular.module('userApp').controller('UserCreateController', UserCreateController);
    UserCreateController.$inject = ['$scope', '$state', '$stateParams', 'User']

    function UserCreateController($scope, $state, $stateParams, User) {
        $scope.user = new User();
        $scope.addUser = function() {
            $scope.user.$save(function() {
                $state.go('users');
            });
        }

    }

})();
