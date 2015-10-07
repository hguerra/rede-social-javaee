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
    /*perfil do amigo*/
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
                }]
        },
        {
            'id': 999999999,
            'nome': 'Butters 2',
            'imagem': 'assets/img/butters.jpg'
        }
    ];
    post.feeds = [
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
    /*Rede-social*/
    /*server*/
    post.login = function () {
        var accessName = $("#form-last-name").val();
        var password = $("#form-password").val();
        if (accessName !== '' && password !== '') {
            var data = {"user": accessName, "pwd": password};
            $http.post('login', data).then(onSuccess, onError);
            function onSuccess(response) {
                window.location.href = "index.jsp";
            }

            function onError(err) {
                var accessName = $("#form-last-name").val('');
                var password = $("#form-password").val('');
            }
        }
    };
    function updateFeeds(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.feeds.unshift(feed);
        });
    };
    post.getDados = function () {
        $http.get('/rest').then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            console.log(resp);
            updateFeeds(resp);
        }

        function onError(err) {
            console.log(err);
        }
    };
    /*restore*/
    post.getDados();
    /*/restore*/
    post.newPost = function () {
        var data = {
            'mensagem': post.mensagem,
            'imagem': post.imagem
        };
        if (post.mensagem !== '') {
            $http.post('post', data).then(onSuccess, onError);
            function onSuccess(response) {
                var feed = response.data || [];
                console.log(feed);
                post.feeds.unshift({'titulo': feed.titulo, 'mensagem': feed.mensagem, 'imagem': feed.imagem});
                post.titulo = '';
                post.mensagem = '';
                post.imagem = '';
            }

            function onError(err) {
                console.log(err);
            }
        }
    };
    post.remove = function (feed) {
        $http.post('removepost', feed).then(onSuccess, onError);
        function onSuccess(response) {
            var success = response.data || [];
            var index = post.feeds.indexOf(feed);
            post.feeds.splice(index, 1);
        }

        function onError(err) {
            console.log(err);
        }
    };
    post.repost = function (feed) {
        var index = post.feeds.indexOf(feed);
        var repost = post.feeds[index];
        if (post.publicartweet !== '') {
            $http.post('/post', repost).then(onSuccess, onError);
            function onSuccess(response) {
                var resp = response.data || [];
                updateFeeds(resp);
            }

            function onError(err) {
                console.log(err)
            }
        }
    };
    /*Facebook*/
    post.publicar = function () {
        var data = {
            'publicar': post.publicarpost,
            'imagem': post.publicarposturl
        };
        if (post.publicarpost !== '') {
            $http.post('/facebook', data).then(onSuccess, onError);
            function onSuccess(response) {
                var resp = response.data || [];
                updateFacebook(resp);
                post.publicarpost = '';
                post.publicarposturl = '';
            }

            function onError(err) {
                post.publicarpost = '';
                post.publicarposturl = '';
            }
        }
    };
    function updateFacebook(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.facebook.unshift(feed);
        });
    };
    /*Twitter*/
    post.tweet = function () {
        var data = {
            'tweet': post.publicartweet,
            'imagem': post.publicartweeturl
        };
        if (post.publicartweet !== '') {
            $http.post('/tweet', data).then(onSuccess, onError);
            function onSuccess(response) {
                var resp = response.data || [];
                updateTwitter(resp);
                post.publicartweet = '';
                post.publicartweeturl = '';
            }

            function onError(err) {
                post.publicartweet = '';
                post.publicartweeturl = '';
            }
        }

    };
    post.retweet = function (tweet) {
        var index = post.twitter.indexOf(tweet);
        var retweet = post.twitter[index];
        if (post.publicartweet !== '') {
            $http.post('/tweet', retweet).then(onSuccess, onError);
            function onSuccess(response) {
                var resp = response.data || [];
                updateTwitter(resp);
                post.publicartweet = '';
                post.publicartweeturl = '';
            }

            function onError(err) {
                post.publicartweet = '';
                post.publicartweeturl = '';
            }
        }
    };
    function updateTwitter(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.twitter.unshift(feed);
        });
    };
    post.buscarUsuario = function () {
        var data = {'user': post.buscarusuario}
        if (post.buscarusuario !== '') {
            $http.post('/buscarusuario', data).then(onSuccess, onError);
            function onSuccess(response) {
                var resp = response.data || [];
                post.amigo = resp;
                $('#perfilAmigoModal').modal({
                    show: 'true'
                });
                post.buscarusuario = '';
            }

            function onError(err) {
                post.buscarusuario = '';
            }
        }
    }
    post.selecionarUsuario = function (follow) {
        post.amigo = follow;
        $('#perfilAmigoModal').modal({
            show: 'true'
        });
    }
});







