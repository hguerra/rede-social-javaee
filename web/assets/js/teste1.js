/**
 * Created by heitor on 28/09/15.
 */
var app = angular.module('redeApp', []);

app.controller('main', function ($scope) {
    /*
     Atributos
     */
    $scope.buscarPost = '';
    $scope.feeds = [
        {
            'titulo': '@Heitor 28/09/2015',
            'mensagem': 'Ola mundo',
            'imagem': 'assets/img/bg_4.jpg'
        },
        {
            'titulo': '@Isabela 28/09/2015',
            'mensagem': 'Ola mundo',
            'imagem': 'assets/img/bg_4.jpg'
        },
        {
            'titulo': '@Alguem 28/09/2015',
            'mensagem': 'Ola mundo',
            'imagem': 'assets/img/bg_4.jpg'
        }
    ];
    /*
     Json usuario
     */
    $scope.usuario = {
        'id': 123456,
        'nome': 'Heitor',
        'imagem': 'url'
    };
    /*
     Metodos
     */
    $scope.newPost = function () {
        var newTitulo = '@' +$scope.usuario.nome+' '+'28/09/2015';
        $scope.feeds.unshift({'titulo':newTitulo, 'mensagem': $scope.mensagem, 'imagem': $scope.imagem});
        $scope.titulo = '';
        $scope.mensagem = '';
        $scope.imagem = '';
    };
    $scope.remove = function (feed) {
        var index = $scope.feeds.indexOf(feed)
        $scope.feeds.splice(index, 1);
    }

});




