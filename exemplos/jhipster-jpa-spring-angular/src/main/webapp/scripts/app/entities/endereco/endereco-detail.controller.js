'use strict';

angular.module('jhipsterApp')
    .controller('EnderecoDetailController', function ($scope, $rootScope, $stateParams, entity, Endereco, Pessoa) {
        $scope.endereco = entity;
        $scope.load = function (id) {
            Endereco.get({id: id}, function(result) {
                $scope.endereco = result;
            });
        };
        var unsubscribe = $rootScope.$on('jhipsterApp:enderecoUpdate', function(event, result) {
            $scope.endereco = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
