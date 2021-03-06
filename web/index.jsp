<%--
  Created by IntelliJ IDEA.
  User: heitor
  Date: 06/10/15
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>CaraLivro</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!--CSS-->
    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/img/favicon-32x32.png">
    <!--REDE-SOCIAL-CSS-->
    <link href="assets/css/social-custom-template.css" rel="stylesheet">
    <!--FRAMEWORKS-->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <![endif]-->
    <script src="assets/js/jquery-1.11.1.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/angular.min.js"></script>
    <!--END FRAMEWORKS-->
    <!--REDE-SOCIAL-SCRIPTS-->
    <script src="assets/js/social-sidebar-toggle.js"></script>
    <script src="assets/proj-js/angular-app.js"></script>
    <script src="assets/proj-js/controller-post.js"></script>
    <script src="assets/proj-js/directive-proj-esquerda.js"></script>
    <script src="assets/proj-js/directive-proj-direita.js"></script>
    <script src="assets/proj-js/directive-proj-footer.js"></script>
    <script src="assets/proj-js/directive-proj-sidebar.js"></script>
    <script src="assets/proj-js/directive-proj-navbar.js"></script>
    <script src="assets/proj-js/directive-proj-modal-post.js"></script>
    <script src="assets/proj-js/directive-proj-modal-mensagens.js"></script>
    <script src="assets/proj-js/directive-proj-modal-following.js"></script>
    <script src="assets/proj-js/directive-proj-modal-followers.js"></script>
    <script src="assets/proj-js/directive-proj-modal-amigo.js"></script>
    <script src="assets/proj-js/directive-proj-modal-config.js"></script>
    <script src="assets/proj-js/directive-proj-modal-encontrado.js"></script>
</head>
<body ng-app="redeApp" ng-controller="PostController as post">
<div class="wrapper">
    <div class="box">
        <div class="row row-offcanvas row-offcanvas-left">
            <!--
            sidebar
            -->
            <paginasidebar></paginasidebar>
            <!--
            /sidebar
             -->
            <!-- coluna central do projeto -->
            <div class="column col-sm-10 col-xs-11" id="main">
                <!--
                TOP NAVBAR
                -->
                <div class="navbar navbar-blue navbar-static-top">
                    <paginanavbar></paginanavbar>
                </div>
                <!--
                /TOP NAVBAR
                -->
                <!--
                CONTEUDO PRINCIPAL
                -->
                <div class="padding">
                    <div class="full col-sm-9">
                        <!--DIV CONTEUDO PAGINA -->
                        <div class="row">
                            <!--
                           COLUNA ESQUERDA
                           -->
                            <colunaesquerda></colunaesquerda>
                            <!--
                           /COLUNA ESQUERDA
                           -->
                            <!--
                            COLUNA DIREITA
                            -->
                            <colunadireita></colunadireita>
                            <!--
                            /COLUNA DIREITA
                            -->
                            <!--
                            Footer
                            -->
                            <paginafooter></paginafooter>
                            <!--
                            /Footer
                            -->
                        </div>
                    </div>
                </div>
                <!--
                /CONTEUDO PRINCIPAL
                -->
            </div>
        </div>
    </div>
    <!--
    JANELA SO APARECE AO PRESSIONADA
    <!--
    Modal post
    -->
    <modalpost></modalpost>
    <!--
    Modal post
    -->
    <modalmensagens></modalmensagens>
    <modalfollowers></modalfollowers>
    <modalfollowing></modalfollowing>
    <modalamigo></modalamigo>
    <modalconfig></modalconfig>
    <modalencontrado></modalencontrado>
</div>
</body>
</html>