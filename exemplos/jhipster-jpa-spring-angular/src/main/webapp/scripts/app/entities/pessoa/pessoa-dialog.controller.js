'use strict';

angular.module('jhipsterApp').controller('PessoaDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Pessoa', 'Endereco',
        function($scope, $stateParams, $uibModalInstance, entity, Pessoa, Endereco) {

        $scope.pessoa = entity;
        $scope.enderecos = Endereco.query();
        $scope.load = function(id) {
            Pessoa.get({id : id}, function(result) {
                $scope.pessoa = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('jhipsterApp:pessoaUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.pessoa.id != null) {
                Pessoa.update($scope.pessoa, onSaveSuccess, onSaveError);
            } else {
                Pessoa.save($scope.pessoa, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
