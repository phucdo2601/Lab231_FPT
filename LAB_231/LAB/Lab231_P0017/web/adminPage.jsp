<%-- 
    Document   : adminPage
    Created on : Jun 11, 2021, 5:26:00 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ADMIN PAGE</title>
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
                                <li class="active"> PROMOTION HISTORY</li>
                            </ul>
                            <h3> PROMOTION HISTORY [ <small>3 Item(s) </small>]</h3>
                            <hr class="soft" />

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Image</th>
                                        <th>UserID</th>
                                        <th>Fullname</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Promo Rank</th>
                                        <th>Date Of adding Promotion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.listHisPromo}" var="dto" varStatus="counter">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td> <img width="60" src="images/${dto.imgURL}" alt="" /></td>
                                        <td>${dto.userID}</td>
                                        <td>${dto.fullname}</td>
                                        <td>
                                            ${dto.email}
                                        </td>
                                        <td>${dto.phone}</td>
                                        <td>${dto.rankPromo}</td>
                                        <td>${dto.dateOfAddPromo}</td>
                                    </tr>
                                </c:forEach>  
                            </tbody>
                        </table>
                        <a href="loadAllService" class="btn btn-large"> Go Back HOMEPAGE </a>
                        
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
