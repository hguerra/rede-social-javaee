/**
 * Created by heitor on 28/09/15.
 */
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
        'imagem': 'assets/img/storm-user.jpg'
    };
    post.hashtag = [{'hashtag': '#um'}, {'hashtag': '#dois'}, {'hashtag': '#tres'},
        {'hashtag': '#quatro'}, {'hashtag': '#cinco'}, {'hashtag': '#seis'},
        {'hashtag': '#sete'}, {'hashtag': '#oito'}, {'hashtag': '#nove'}, {'hashtag': '#dez'}];
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







