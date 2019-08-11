angular.module('guoApp', ['ngRoute'])
    .controller('loginCtrl', function($scope, $http) {
        $scope.username = 'zhangshan';

        $scope.login = function() {
            var payload = "username=" + $scope.username + "&password=" + $scope.password;
            $http.post('/signin', payload).then(function success(resp) {
                console.log(resp);
            }, function failed(resp) {
                console.log(resp);
            })
        }
    })
    .controller('homeCtrl', function($scope, $http) {
        $scope.logout = function() {
            $http.post('/signout').then(function success(resp) {
                console.log(resp);
            }, function failed(resp) {
                console.log(resp);
            })
        }
    })