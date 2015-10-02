/**
 * Created by heitor on 28/09/15.
 */
app.controller('PostController', function ($http) {
    var post = this;
    /*
     Atributos
     */
    /*facebook*/
    post.facebook = [];
    /*twitter*/
    post.twitter = [];
    /*rede-social*/
    post.buscarPost = '';
    post.caixaEntrada = [
        {
            'remetenteNome': 'God',
            'remetenteImagem': 'assets/img/butters.jpg',
            'mensagem': 'mensagem privada 1'
        },
        {
            'remetenteNome': 'God',
            'remetenteImagem': 'assets/img/butters.jpg',
            'mensagem': 'mensagem privada 2'
        }

    ];
    post.following = [
        {
            'id': 69696969,
            'nome': 'Butters',
            'imagem': 'assets/img/butters.jpg'
        },
        {
            'id': 999999999,
            'nome': 'Butters 2',
            'imagem': 'assets/img/butters.jpg'
        }
    ];
    post.amigo =
    {
        'id': 69696969,
        'nome': 'Butters',
        'imagem': 'assets/img/butters.jpg',
        'feeds': [
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

        ]
    };

    post.followers = [
        {
            'id': 69696969,
            'nome': 'Butters',
            'imagem': 'assets/img/butters.jpg'
        },
        {
            'id': 999999999,
            'nome': 'Butters 2',
            'imagem': 'assets/img/butters.jpg'
        }
    ];
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
    timelineFake = function () {
        for (i = 1; i <= 10; i++) {
            post.facebook.push(i);
            post.twitter.push(i);
        }
    };
    timelineFake();
    /*
     Metodos
     */
    /*Rede-social*/
    post.newPost = function () {
        var newTitulo = '@' + post.usuario.nome + ' ' + '28/09/2015';
        post.feeds.unshift({'titulo': newTitulo, 'mensagem': post.mensagem, 'imagem': post.imagem});
        post.titulo = '';
        post.mensagem = '';
        post.imagem = '';
    };
    post.remove = function (feed) {
        var index = post.feeds.indexOf(feed);
        post.feeds.splice(index, 1);
    };
    /*Facebook*/
    post.publicar = function () {
        console.log('ok');
    };
    /*Twitter*/
    post.tweet = function () {

    };
    post.retweet = function (tweet) {
        var index = post.twitter.indexOf(tweet);
        var retweet = post.twitter[index];
        console.log(retweet);
    };
    /*server*/
    post.getDados = function () {
        $http({
            method: 'GET',
            url: 'recebe'
        }).then(function onSuccess(response) {
            var resp = response.data || [];
            console.log(resp);
            return resp;
        }, function onError(err) {
            $log.error(err);
            return $q.reject(err);
        });
    };
    post.setDados = function () {
        var data = {"firstName": "Heitor", "lastName": "Carneiro"};
        /*primeira*/
        $http.post('login', data);
        /*segunda*/
        $http({
            method: 'POST',
            url: 'login',
            data: {"nome": data},
            headers: {
                'Content-Type': 'application/json'
            }
        })
    };

});







