'use strict';

angular.module('jhipsterApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('pessoa', {
                parent: 'entity',
                url: '/pessoas',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'jhipsterApp.pessoa.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/pessoa/pessoas.html',
                        controller: 'PessoaController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('pessoa');
                        $translatePartialLoader.addPart('sexoEnum');
                        $translatePartialLoader.addPart('global');
                        return $translate.refresh();
                    }]
                }
            })
            .state('pessoa.detail', {
                parent: 'entity',
                url: '/pessoa/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'jhipsterApp.pessoa.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/pessoa/pessoa-detail.html',
                        controller: 'PessoaDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('pessoa');
                        $translatePartialLoader.addPart('sexoEnum');
                        return $translate.refresh();
                    }],
                    entity: ['$stateParams', 'Pessoa', function($stateParams, Pessoa) {
                        return Pessoa.get({id : $stateParams.id});
                    }]
                }
            })
            .state('pessoa.new', {
                parent: 'pessoa',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/pessoa/pessoa-dialog.html',
                        controller: 'PessoaDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    nome: null,
                                    sexo: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('pessoa', null, { reload: true });
                    }, function() {
                        $state.go('pessoa');
                    })
                }]
            })
            .state('pessoa.edit', {
                parent: 'pessoa',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/pessoa/pessoa-dialog.html',
                        controller: 'PessoaDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Pessoa', function(Pessoa) {
                                return Pessoa.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('pessoa', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('pessoa.delete', {
                parent: 'pessoa',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/pessoa/pessoa-delete-dialog.html',
                        controller: 'PessoaDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Pessoa', function(Pessoa) {
                                return Pessoa.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('pessoa', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
