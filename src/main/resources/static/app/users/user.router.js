(function() {
    'use strict'
    angular.module('userApp').config(function($stateProvider) {
        $stateProvider.state('users', { // state for showing all users
            url: '/users',
            templateUrl: 'app/users/views/users.html',
            controller: 'UserListController'
        }).state('viewUser', { //state for showing single user
            url: '/users/:id/view',
            templateUrl: 'app/users/views/user-view.html',
            controller: 'UserViewController'
        }).state('newUser', { //state for adding a new user
            url: '/users/new',
            templateUrl: 'app/users/views/user-add.html',
            controller: 'UserCreateController'
        }).state('editUser', { //state for updating a user
            url: '/users/:id/edit',
            templateUrl: 'app/users/views/user-edit.html',
            controller: 'UserEditController'
        });
    }).run(function($state) {
        $state.go('users');
    });

})();
