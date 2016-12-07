(function() {
    'use strict';
    angular.module('userApp').factory('User', User).service('PopupService', PopupService);
    User.$inject = ['$resource'];
    PopupService.$inject = ['$window'];

    function User($resource) {
        return $resource('http://localhost:8080/api/users/:id', {
            id: '@id'
        }, {
            update: {
                method: 'PUT'
            }
        });

    }

    function PopupService($window) {
        this.showPopup = function(message) {
            return $window.confirm(message);
        }
    }

})();
