(function() {
    'use strict'
    angular.module('userApp').controller('UserListController', UserListController);
    UserListController.$inject = ['$scope', '$window', 'PopupService', 'User']

    function UserListController($scope, $window, PopupService, User) {
        $scope.users = User.query();

        $scope.deleteUser = function(user) {
            if (PopupService.showPopup('Really delete this?')) {
                user.$delete(function() {
                    $window.location.href = '';
                });
            }
        }

    }

})();
