'use strict';

angular.module('jhipsterApp').controller('EnderecoDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Endereco', 'Pessoa',
        function($scope, $stateParams, $uibModalInstance, entity, Endereco, Pessoa) {

        $scope.endereco = entity;
        $scope.pessoas = Pessoa.query();
        $scope.load = function(id) {
            Endereco.get({id : id}, function(result) {
                $scope.endereco = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('jhipsterApp:enderecoUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.endereco.id != null) {
                Endereco.update($scope.endereco, onSaveSuccess, onSaveError);
            } else {
                Endereco.save($scope.endereco, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
