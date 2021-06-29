<%-- 
    Document   : header.jsp
    Created on : Jan 14, 2021, 11:46:26 AM
    Author     : phucd
--%>

<%@page import="phucdn.dtos.CartObj"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="mainTemp/css/bootstrap.min.css" rel="stylesheet">
        <link href="mainTemp/css/font-awesome.min.css" rel="stylesheet">
        <link href="mainTemp/css/prettyPhoto.css" rel="stylesheet">
        <link href="mainTemp/css/price-range.css" rel="stylesheet">
        <link href="mainTemp/css/animate.css" rel="stylesheet">
        <link href="mainTemp/css/main.css" rel="stylesheet">
        <link href="mainTemp/css/responsive.css" rel="stylesheet">
    </head>
    <body>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="MainController"><img src="mainTemp/images/home/logo.png" alt="" /></a>
                            </div>
                            <div class="btn-group pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                        USA
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Canada</a></li>
                                        <li><a href="#">UK</a></li>
                                    </ul>
                                </div>

                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                        DOLLAR
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Canadian Dollar</a></li>
                                        <li><a href="#">Pound</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <!--                                    <li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>-->
                                    <%
                                        CartObj shoppingCart = (CartObj) session.getAttribute("cart");

                                    %>
                                    <li><a href="cart.jsp"><i class="fa fa-shopping-cart"></i> Cart
                                            <%                                                if (shoppingCart != null) {
                                            %>
                                            (
                                            <%= shoppingCart.getCart().values().size()%>
                                            )
                                            <%
                                                }
                                            %>
                                        </a></li>
                                        <c:if test="${sessionScope.USERNAME == 'admin'}">
                                        <li><a href="admin.jsp"><i class="fa fa-crosshairs"></i> Admin Management</a></li>
                                        <li><a href="LogoutServlet" ><i class="fa fa-lock"></i>Logout</a></li>
                                        <li><a href="#"><i class="fa fa-user"></i> ${sessionScope.USERNAME}</a></li>
                                        </c:if>

                                    <c:if test="${sessionScope.roleAcc == 'user'}">
                                        <li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                                        <li><a>
                                                <form action="UserAccountManageServlet" method="POST">
                                                    <li><a href="UserAccountManageServlet?AccUsername=${sessionScope.USERNAME}"><i class="fa fa-crosshairs"></i> Account Management</a></li>
                                                </form>
                                            </a></li>
                                        </c:if>

                                    <c:if test="${sessionScope.USERNAME == null}">
                                        <li><a href="login.jsp"><i class="fa fa-lock"></i> Login</a></li>
                                        <li><a href="createAccount.jsp"><i class="fa fa-lock"></i> Sign Up</a></li>

                                    </c:if>

                                    <c:if test="${sessionScope.USERNAME != null && sessionScope.USERNAME != 'admin'}">
                                        <li><a>
                                                <form action="UserAccountGeneral" method="POST">
                                                    <li><a href="UserAccountGeneral?AccGenUsername=${sessionScope.USERNAME}"><i class="fa fa-user"></i> ${sessionScope.USERNAME}</a></li>
                                                </form>
                                            </a></li>
                                        <li><a href="LogoutServlet" ><i class="fa fa-lock"></i>Logout</a></li>
                                        </c:if>


                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="MainController" class="active">Home</a></li>
                                    <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <li><a href="MainController">Products</a></li>
                                                <c:if test="${sessionScope.roleAcc =='user'}">
                                                <li><a href="checkout.jsp">Checkout</a></li> 
                                                </c:if>

                                            <li><a href="cart.jsp">Cart</a></li> 
                                                <c:if test="${sessionScope.USERNAME == null}">
                                                <li><a href="login.jsp">Login</a></li>
                                                </c:if>
                                                <c:if test="${sessionScope.USERNAME != null}">
                                                <li><a href="LogoutServlet">Logout</a></li>

                                            </c:if>
                                            <c:if test="${sessionScope.roleAcc == 'user'}">
                                                <c:url var="historyPayment" value="MainController">
                                                    <c:param name="action" value="UserViewHistory"/>
                                                    <c:param name="id" value="${sessionScope.USERNAME}"/>
                                                </c:url>
                                                <li><a href="${historyPayment}">History</a></li>
                                                </c:if>
                                        </ul>
                                    </li> 
                                    <c:if test="${sessionScope.roleAcc == 'user'}">
                                        <li class="dropdown"><a href="#">Personal<i class="fa fa-angle-down"></i></a>
                                            <ul role="menu" class="sub-menu">
                                                <li><a href="MainController?action=UserConfirmListOrder&id=${sessionScope.USERNAME}">Confirm</a></li>
                                                <li><a href="MainController?action=ViewOrderCancel&id=${sessionScope.USERNAME}">Cancel</a></li>
                                            </ul>
                                        </li> 
                                    </c:if>
                                    <li><a href="error.jsp">404</a></li>
                                        <c:if test="${sessionScope.roleAcc =='user'}">
                                        <li><a href="${historyPayment}">History</a></li>
                                        </c:if>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div >
                                <form action="MainController" method="POST" class="search_box pull-right">
                                    <input oninput="searchByName(this)" type="text" placeholder="Search" name="txtSearch" value="${txtValueSearch}" />
                                    <button type="submit" name="action" value="Search by Product Name">
                                        <i class="search_box pull-right">Search</i>
                                    </button>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->
        </header><!--/header-->
    </body>
</html>
