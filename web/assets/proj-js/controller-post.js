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
    post.usuario = {};
    post.usuariosEncontrados = [];
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
    post.hashtag = [];
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
    post.logout = function () {
        $http.post('logout').then(onSuccess, onError);
        function onSuccess(response) {
            window.location.href = "login.jsp";
        }

        function onError(err) {
            console.log(err);
        }
    }
    function updateFeeds(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.feeds.unshift(feed);
        });
    };
    function updateFollowing(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.following.unshift(feed);
        });
    };
    function updateFollower(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.followers.unshift(feed);
        });
    };
    function updateInbox(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.caixaEntrada.unshift(feed);
        });
    };
    function updateHashtag(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.hashtag.unshift(feed);
        });
    };
    function updateEncontrados(feedsList) {
        $.each(feedsList, function (index, feed) {
            post.usuariosEncontrados.unshift(feed);
        });
    };
    post.getUser = function () {
        $http.get('/restuser').then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            console.log(resp);
            post.usuario = {
                'id': resp.id,
                'nome': resp.nome,
                'imagem': resp.imagem
            };
            updateFeeds(resp.feeds);
        }

        function onError(err) {
            console.log(err);
        }
    };
    post.getFollowing = function () {
        $http.get('/restfollowing').then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            updateFollowing(resp);
        }

        function onError(err) {
            console.log(err);
        }
    };
    post.getFollower = function () {
        $http.get('/restfollowers').then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            updateFollower(resp);
        }

        function onError(err) {
            console.log(err);
        }
    };
    post.getInbox = function () {
        $http.get('/restinbox').then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            updateInbox(resp);
        }

        function onError(err) {
            console.log(err);
        }
    };
    post.getHashtag = function () {
        $http.get('/resthashtag').then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            updateHashtag(resp);
        }

        function onError(err) {
            console.log(err);
        }
    };
    post.getUser();
    post.getFollowing();
    post.getFollower();
    post.getInbox();
    post.getHashtag();
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
    post.getFacebook = function () {
        $http.get('/facebook').then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            updateFacebook(resp);
        }

        function onError(err) {
            console.log(err)
        }
    };
    //post.getFacebook();
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
    post.getTweet = function () {
        $http.get('/tweet').then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            updateTwitter(resp);
        }

        function onError(err) {
            console.log(err)
        }

    };
    //post.getTweet();
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
                console.log(resp);
                updateEncontrados(resp);
                $('#searchModal').modal({
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
    post.followingAdd = function (follow) {
        $http.post('/following', follow).then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            updateFollowing(resp);
        }

        function onError(err) {

        }


    }
    post.followingRemove = function (follow) {
        $http.post('/following', follow).then(onSuccess, onError);
        function onSuccess(response) {
            var success = response.data || [];
            var index = post.following.indexOf(follow);
            post.following.splice(index, 1);
        }

        function onError(err) {
            console.log(err);
        }

    }
    post.followerAdd = function (follow) {
        $http.post('/follower', follow).then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            updateFollowing(resp);
        }

        function onError(err) {

        }

    }
    post.followerRemove = function (follow) {
        $http.post('/follower', follow).then(onSuccess, onError);
        function onSuccess(response) {
            var success = response.data || [];
            var index = post.following.indexOf(follow);
            post.following.splice(index, 1);
        }

        function onError(err) {
            console.log(err);
        }
    }
    post.updateConfiguracao = function () {
        var data = {
            'id': post.usuario.id,
            'name': post.updatenome,
            'image': post.updatefile,
            'password': post.updatepassword,
            'email': post.updateemail
        };
        $http.post('/update', data).then(onSuccess, onError);
        function onSuccess(response) {
            var resp = response.data || [];
            console.log(resp);
            post.usuario = {
                'id': resp.id,
                'nome': resp.nome,
                'imagem': resp.imagem
            };
        }

        function onError(err) {
            console.log(err);
        }
    }
});







