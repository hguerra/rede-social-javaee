<%--
  Created by IntelliJ IDEA.
  User: heitor
  Date: 06/10/15
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CaraLivro</title>

    <!-- Javascript -->
    <script src="assets/js/jquery-1.11.1.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.backstretch.min.js"></script>
    <script src="assets/js/retina-1.1.0.min.js"></script>
    <script src="assets/js/social-login.js"></script>
    <script src="assets/js/angular.min.js"></script>
    <script src="assets/proj-js/angular-app.js"></script>
    <script src="assets/proj-js/controller-post.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/social-form-elements.css">
    <link rel="stylesheet" href="assets/css/social-custom-login.css">


    <link rel="icon" type="image/png" sizes="32x32" href="assets/img/favicon-32x32.png">
</head>

<body ng-app="redeApp" ng-controller="PostController as post">

<!-- Top menu -->
<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">FatecBook</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
							<span class="li-text">
								Register:
							</span>
							<span class="li-social">
								<a href="register.jsp"><i class="fa fa-pencil"></i></a>
							</span>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-7 text">
                    <h1><strong>FatecBook</strong> Login</h1>
                </div>
                <div class="col-sm-5 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login</h3>

                            <p>Fill in the form below to get instant access:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-users"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" class="registration-form">
                            <div class="form-group">
                                <label class="sr-only">Access Name</label>
                                <input type="text" name="user" placeholder="Access Name..."
                                       class="form-last-name form-control" id="form-last-name">
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Password</label>
                                <input type="password" name="pwd" placeholder="Password..."
                                       class="form-email form-control" id="form-password">
                            </div>
                            <button data-ng-click="post.login()" type="submit" class="btn">Login!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<footer>
    <a> &copy; 2015 By : Heitor and Isabela</a>
</footer>
<!-- /. FOOTER  -->
</body>

</html>