'use strict';

angular.module('jhipsterApp')
    .controller('PessoaDetailController', function ($scope, $rootScope, $stateParams, entity, Pessoa, Endereco) {
        $scope.pessoa = entity;
        $scope.load = function (id) {
            Pessoa.get({id: id}, function(result) {
                $scope.pessoa = result;
            });
        };
        var unsubscribe = $rootScope.$on('jhipsterApp:pessoaUpdate', function(event, result) {
            $scope.pessoa = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
