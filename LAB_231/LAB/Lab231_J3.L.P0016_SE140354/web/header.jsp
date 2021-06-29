<%-- 
    Document   : header.jsp
    Created on : May 11, 2021, 9:14:57 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>About Us</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">	
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="mainTemp/css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="mainTemp/css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="mainTemp/css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="mainTemp/images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="mainTemp/css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="mainTemp/css/owl.carousel.min.css">
        <link rel="stylesheet" href="mainTemp/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

        <script src="mainTemp/js/jquery.min.js"></script>
        <script src="mainTemp/js/popper.min.js"></script>
        <script src="mainTemp/js/bootstrap.bundle.min.js"></script>
        <script src="mainTemp/js/jquery-3.0.0.min.js"></script>
        <script src="mainTemp/js/plugin.js"></script>
        <!-- sidebar -->
        <script src="mainTemp/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="mainTemp/js/custom.js"></script>
        <!-- javascript --> 
        <script src=mainTemp/js/owl.carousel.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
        <!-- Javascript files-->

        <script>
            $(document).ready(function () {
                $(".fancybox").fancybox({
                    openEffect: "none",
                    closeEffect: "none"
                });

                $(".zoom").hover(function () {

                    $(this).addClass('transition');
                }, function () {

                    $(this).removeClass('transition');
                });
            });

        </script> 
    </head>

    <body>
        <div class="header_section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-lg-3">
                        <a href="LoadAllGeneralServiceController"><div class="logo"><img src="mainTemp/images/logo.png"></div></a>
                    </div>
                    <div class="col-sm-6">
                        <nav class="navbar navbar-expand-lg navbar-light bg-light">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                                <div class="navbar-nav">
                                    <a class="nav-item nav-link" href="LoadAllGeneralServiceController">Home</a>
                                    <!--                                    <a class="nav-item nav-link" href="browse ads.html">Browse ads</a>-->
                                    <c:if test="${sessionScope.roleUser != 'mng'}">
                                        <a class="nav-item nav-link" href="Order?OAction=viewHistory">History</a>
                                    </c:if>
                                    <c:if test="${sessionScope.roleUser eq 'mng'}">
                                        <a class="nav-item nav-link" href="AOrder?AAction=viewOrderRe">Management</a>
                                    </c:if>
                                    <a class="nav-item nav-link">${sessionScope.txtUsername}</a>
                                    <c:if test="${sessionScope.roleUser != 'mng'}">
                                        <c:set var="CartBorrow" value="${sessionScope.Cart}"/>
                                        <a class="nav-item nav-link" href="cartBorrow.jsp">Cart

                                            <c:if test="${not empty CartBorrow}">
                                                (
                                                ${sessionScope.Cart.cart.values().size()}
                                                )
                                            </c:if>
                                        </a>
                                    </c:if>
                                </div>
                            </div>
                        </nav>
                    </div>
                    <!--                    <div class="col-sm-6 col-lg-3">
                                            <div class="search_main">
                                                <button class="submit_bt"><a class="nav-item nav-link" href="MainController?action=Logout">Logout</a></button>
                                            </div>
                                        </div>-->
                </div>
            </div>
        </div>
    </body>

</html>
