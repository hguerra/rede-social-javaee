/**
 * Created by heitor on 28/09/15.
 */
var app = angular.module('redeApp', []);

app.controller('main', function ($scope) {
    $scope.user = 'Heitor';
    // Create the array to hold the list of feeds
    $scope.feeds = [
        {
            'post': 'Teste 1',
            'image': 'url'
        },
        {
            'post': 'Teste 2',
            'image': 'url'
        },
        {
            'post': 'Teste 3',
            'image': 'url'
        }
    ];
    // Create the function to push the data into the "feeds" array
    $scope.newPost = function () {
        console.log({'post': $scope.mensagem, 'image': $scope.imagem});
        $scope.feeds.unshift({'post': $scope.mensagem, 'image': $scope.imagem});
        $scope.mensagem = '';
        $scope.imagem = '';
    };
    $scope.remove = function (feed) {
        var index = $scope.feeds.indexOf(feed)
        $scope.feeds.splice(index, 1);
    }
});



