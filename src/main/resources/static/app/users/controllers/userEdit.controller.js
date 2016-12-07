(function() {
    'use strict'
    angular.module('userApp').controller('UserEditController', UserEditController);
    UserEditController.$inject = ['$scope', '$state', '$stateParams', 'User']

    function UserEditController($scope, $state, $stateParams, User) {
        $scope.updateUser = function() {
            $scope.user.$update(function() {
                $state.go('users');
            });
        };

        $scope.loadUser = function() {
            $scope.user = User.get({
                id: $stateParams.id
            });
        };

        $scope.loadUser();

    }

})();
