'use strict';

angular.module('jhipsterApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('endereco', {
                parent: 'entity',
                url: '/enderecos',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'jhipsterApp.endereco.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/endereco/enderecos.html',
                        controller: 'EnderecoController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('endereco');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('endereco.detail', {
                parent: 'entity',
                url: '/endereco/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'jhipsterApp.endereco.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/endereco/endereco-detail.html',
                        controller: 'EnderecoDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('endereco');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Endereco', function($stateParams, Endereco) {
                        return Endereco.get({id : $stateParams.id});
                    }]
                }
            })
            .state('endereco.new', {
                parent: 'endereco',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/endereco/endereco-dialog.html',
                        controller: 'EnderecoDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    logradouro: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('endereco', null, { reload: true });
                    }, function() {
                        $state.go('endereco');
                    })
                }]
            })
            .state('endereco.edit', {
                parent: 'endereco',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/endereco/endereco-dialog.html',
                        controller: 'EnderecoDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Endereco', function(Endereco) {
                                return Endereco.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('endereco', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('endereco.delete', {
                parent: 'endereco',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/endereco/endereco-delete-dialog.html',
                        controller: 'EnderecoDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Endereco', function(Endereco) {
                                return Endereco.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('endereco', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
