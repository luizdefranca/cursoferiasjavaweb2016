'use strict';

angular.module('jhipsterApp')
	.controller('PessoaDeleteController', function($scope, $uibModalInstance, entity, Pessoa) {

        $scope.pessoa = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Pessoa.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
