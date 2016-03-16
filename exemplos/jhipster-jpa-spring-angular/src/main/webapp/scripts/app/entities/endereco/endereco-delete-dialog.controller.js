'use strict';

angular.module('jhipsterApp')
	.controller('EnderecoDeleteController', function($scope, $uibModalInstance, entity, Endereco) {

        $scope.endereco = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Endereco.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
