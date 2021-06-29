<%-- 
    Document   : header
    Created on : Jun 11, 2021, 4:59:46 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Bootshop online Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--Less styles -->
        <!-- Other Less css file //different less files has different color scheam
             <link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
        -->
        <!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
        <script src="themes/js/less.js" type="text/javascript"></script> -->

        <!-- Bootstrap style --> 
        <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
        <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
        <!-- Bootstrap style responsive -->	
        <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
        <!-- Google-code-prettify -->	
        <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
        <!-- fav and touch icons -->
        <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
        <style type="text/css" id="enject"></style>
    </head>
    <body>
        <div id="header">
            <div class="container">
                <div id="welcomeLine" class="row">
                    <div class="span6">Welcome!<strong> ${sessionScope.txtUsername}</strong></div>
                    <div class="span6">
                        <div class="pull-right">
                            <a href="#"><span class="">Rank Promo ${requestScope.accLogin.promoStatus}</span></a>
                            <c:if test="${requestScope.accLogin.promoStatus eq 'Manager'}">
                                <span class="btn btn-mini">This Account is the BOSS of this page</span>
                            </c:if>

                            <c:if test="${requestScope.accLogin.promoStatus != 'Manager'}">
                                <span class="btn btn-mini">${requestScope.accLogin.rankPromo}</span>
                            </c:if>

                            <c:if test="${sessionScope.txtRole eq 'admin'}">
                                <c:set var="CartPromo" value="${sessionScope.Cart}"/>
                                <a href="cartPromo.jsp"><span class="btn btn-mini btn-primary"><i
                                            class="icon-shopping-cart icon-white"></i> [ 
                                        <c:if test="${not empty CartPromo}">
                                            
                                            ${sessionScope.Cart.cart.values().size()}
                                            
                                        </c:if>
                                        ] Itemes in your cart </span> </a>
                                    </c:if>
                        </div>
                    </div>
                </div>
                <!-- Navbar ================================================== -->
                <div id="logoArea" class="navbar">
                    <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <div class="navbar-inner">
                        <a class="brand" href="loadAllService"><img src="themes/images/logo.png" alt="Bootsshop" /></a>
                            <c:if test="${sessionScope.txtRole eq 'admin'}">
                            <form class="form-inline navbar-search" method="POST" action="ASearch">
                                <input  class="srchTxt" type="text" name="txtSearch"/>

                                <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                            </form>
                        </c:if>
                        <ul id="topMenu" class="nav pull-right">

                            <c:if test="${sessionScope.txtRole eq 'admin'}">
                                <li class=""><a href="AViewHisProPage">Specials Promotion</a></li>                   
                                <li class=""><a href="ASignUpPage">Create Account</a></li>
                                </c:if>
                            <li class="">
                                <button class="btn btn-large btn-success" ><a href="logout">LOGOUT</a></button>
                                <!--                                <a href="logout" role="button" data-toggle="modal" style="padding-right:0"><span
                                                                        class="btn btn-large btn-success"><LOGOUT</span></a>-->
                                <!--                                <div id="login" class="modal hide fade in" tabindex="-1" role="dialog"
                                                                     aria-labelledby="login" aria-hidden="false">
                                                                    <div class="modal-header">
                                                                        <button type="button" class="close" data-dismiss="modal"
                                                                                aria-hidden="true">×</button>
                                                                        <h3>Login Block</h3>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <form class="form-horizontal loginFrm">
                                                                            <div class="control-group">
                                                                                <input type="text" id="inputEmail" placeholder="Email">
                                                                            </div>
                                                                            <div class="control-group">
                                                                                <input type="password" id="inputPassword" placeholder="Password">
                                                                            </div>
                                                                            <div class="control-group">
                                                                                <label class="checkbox">
                                                                                    <input type="checkbox"> Remember me
                                                                                </label>
                                                                            </div>
                                                                        </form>
                                                                        <button type="submit" class="btn btn-success">Sign in</button>
                                                                        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                                                                    </div>
                                                                </div>-->
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
