/**
 * Created by heitor on 28/09/15.
 */
var app = angular.module(angularModule);

app.controller('PostController', function () {
    var post = this;
    /*
     Atributos
     */
    post.buscarPost = '';
    post.feeds = [
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
    post.usuario = {
        'id': 123456,
        'nome': 'Heitor',
        'imagem': 'url'
    };
    /*
     Metodos
     */
    post.newPost = function () {
        var newTitulo = '@' + post.usuario.nome + ' ' + '28/09/2015';
        post.feeds.unshift({'titulo': newTitulo, 'mensagem': post.mensagem, 'imagem': post.imagem});
        post.titulo = '';
        post.mensagem = '';
        post.imagem = '';
    };
    post.remove = function (feed) {
        var index = post.feeds.indexOf(feed)
        post.feeds.splice(index, 1);
    }
});




