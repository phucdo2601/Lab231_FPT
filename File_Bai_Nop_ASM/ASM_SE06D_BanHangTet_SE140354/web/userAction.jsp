<%-- 
    Document   : userAction
    Created on : Feb 25, 2021, 5:58:59 PM
    Author     : phucd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="http://fonts.googleapis.com/css?family=Varela" rel="stylesheet" />
        <link href="mainTemp/css/default.css" rel="stylesheet" type="text/css" media="all" />
        <link href="mainTemp/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />

        <!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

    </head>
    <body>
        <div id="wrapper">
            <div id="header" class="container">
                <div id="logo">
                    <h1><a href="MainController">P-Shopper</a></h1>
                </div>
                <div id="menu">
                    <ul>
                        <li class="current_page_item"><a href="MainController" accesskey="1" title="">Homepage</a></li>
                        <li><a href="UserAccountManageServlet?AccUsername=${sessionScope.USERNAME}" accesskey="2" title="">Account Management</a></li>
                        <li><a href="#" accesskey="3" title="">About Us</a></li>
                        <li><a href="#" accesskey="4" title="">Careers</a></li>
                        <li><a href="LogoutServlet" accesskey="5" title="">Log out</a></li>
                    </ul>
                </div>
            </div>
            <div id="banner">
                <div class="container">
                    <div class="title">
                        <h2>Hello ${sessionScope.USERNAME}!</h2>
                        <span class="byline">Proin gravida porttitor accumsan</span> </div>
                    <ul class="actions">
                        <c:url var="changePassword" value="MainController">
                            <c:param name="action" value="UserChangePassword"/>
                            <c:param name="id" value="${sessionScope.USERNAME}"/>
                        </c:url>
                        <li><a href="${changePassword}" class="button">Change your password</a></li>
                    </ul>
                </div>
            </div>
            <div id="extra" class="container">
                <div class="title">
                    <h2>Praesent scelerisquet</h2>
                    <span class="byline">Donec leo, vivamus fermentum nibh in augue praesent a lacus at urna congue</span> </div>
                <div id="three-column">
                    <div class="boxA">
                        <div class="box"> <span class="fa fa-cloud-download"></span>
                            <c:url var="historyPayment" value="MainController">
                                <c:param name="action" value="UserViewHistory"/>
                                <c:param name="id" value="${sessionScope.USERNAME}"/>
                            </c:url>
                            <a href="${historyPayment}">History</a>
                        </div>
                    </div>
                    <div class="boxB">
                        <div class="box"> <span class="fa fa-cogs"></span>
                            <p class="actions">
                                <c:url var="confirmOrder" value="MainController">
                                    <c:param name="action" value="UserConfirmListOrder"/>
                                    <c:param name="id" value="${sessionScope.USERNAME}"/>
                                </c:url>
                                <a href="${confirmOrder}">Confirm Orders</a>
                            </p>
                        </div>
                    </div>
                    <div class="boxC">
                        <div class="box"> <a href="MainController?action=ViewOrderCancel&id=${sessionScope.USERNAME}"><span class="fa fa-user"></span></a>
                            <a href="MainController?action=ViewOrderCancel&id=${sessionScope.USERNAME}">View Cancelling order</a>
                        </div>
                    </div>
                </div>
                <ul class="actions">
                    <li><a href="MainController" class="button">role back to home page</a></li>
                </ul>
            </div>
        </div>
        <div id="copyright" class="container">
            <p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
        </div>
                        
    </body>
</html>
