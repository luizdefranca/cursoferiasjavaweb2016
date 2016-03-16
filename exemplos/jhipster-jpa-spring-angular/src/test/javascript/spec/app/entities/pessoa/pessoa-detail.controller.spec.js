'use strict';

describe('Controller Tests', function() {

    describe('Pessoa Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPessoa, MockEndereco;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPessoa = jasmine.createSpy('MockPessoa');
            MockEndereco = jasmine.createSpy('MockEndereco');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Pessoa': MockPessoa,
                'Endereco': MockEndereco
            };
            createController = function() {
                $injector.get('$controller')("PessoaDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'jhipsterApp:pessoaUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
