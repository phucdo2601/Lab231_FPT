<%-- 
    Document   : cartPromo
    Created on : Jun 11, 2021, 5:00:46 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>CART PROMOTIONS</title>
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
        <jsp:include page="header.jsp"></jsp:include>

            <div id="mainBody">
                <div class="container">
                    <div class="row">
                        <div class="span9">
                            <ul class="breadcrumb">
                                <li><a href="loadAllService">Home</a> <span class="divider">/</span></li>
                                <li class="active"> Promotion CART</li>
                            </ul>
                        <c:if test="${sessionScope.Cart == null}">
                            <h3><font color="red">Please add to cart about something</font></h3>
                            </c:if>
                            <c:if test="${sessionScope.Cart != null || sessionScope.Cart.cart.size() > 0}">
                            <h3> SHOPPING CART [ <small>3 Item(s) </small>]<a href="loadAllService"
                                                                              class="btn btn-large pull-right"><i class="icon-arrow-left"></i> Continue Add Promotion </a></h3>
                            <hr class="soft" />
                            <form action="AConfirmPromo" method="POST">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Image</th>
                                            <th>UserID</th>
                                            <th>Fullname</th>
                                            <th>Email</th>
                                            <th>Phone</th>
                                            <th>Rank Promo</th>
                                            <th>Cancel</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="cartPromo" value="${sessionScope.Cart.cart.values()}"/>
                                        <c:forEach items="${cartPromo}" var="dto" varStatus="counter">
                                            <tr>
                                                <td>${counter.count}</td>
                                                <td> <img width="60" src="images/${dto.imgURL}" alt="" /></td>
                                                <td>${dto.userID}</td>
                                                <td>${dto.fullname}</td>
                                                <td>
                                                    ${dto.email}
                                                </td>
                                                <td>${dto.phone}</td>
                                                <td>
                                                    <div class="input-append"><input class="span1" style="max-width:34px"
                                                                                     value="${dto.rankPromo}" size="16" type="text">

                                                        <input type="hidden" name="txtItemDown" value="" />
                                                        <a href="AUpRankCart?id=${dto.userID}"><button class="btn" type="button">+</button></a>



                                                        <a href="ADownRankCart?id=${dto.userID}"><button class="btn" type="button">-</button> </a> 


                                                    </div>
                                                </td>
                                                <td>

                                                    <a href="ACancelRankCart?id=${dto.userID}">
                                                        <button class="btn btn-danger">
                                                            Cancel
                                                        </button>
                                                    </a>
                                                </td>
                                            </tr>
                                        <input type="hidden" name="txtUserID" value="${dto.userID}" />                                
                                        
                                        <input type="hidden" name="txtRankPro" value="${dto.rankPromo}" />
                                    </c:forEach> 
                                    </tbody>
                                </table>


                                <button class="btn btn-large pull-right">Confirm </button>
                            </form>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
