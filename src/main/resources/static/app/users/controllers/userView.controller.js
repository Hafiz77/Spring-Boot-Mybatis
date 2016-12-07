(function() {
    'use strict'
    angular.module('userApp').controller('UserViewController', UserViewController);
    UserViewController.$inject = ['$scope', '$stateParams', 'User']

    function UserViewController($scope, $stateParams, User) {
        $scope.user = User.get({
            id: $stateParams.id
        });

    }

})();
