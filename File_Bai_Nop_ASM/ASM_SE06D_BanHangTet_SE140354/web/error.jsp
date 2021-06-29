<%-- 
    Document   : error
    Created on : Jan 22, 2021, 8:37:39 PM
    Author     : phucd
--%>

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
        
        <link rel="icon" type="image/png" href="mainTemp/images/icons/MainPage.ico" />

        <script src="mainTemp/js/jquery.js"></script>
        <script src="mainTemp/js/bootstrap.min.js"></script>
        <script src="mainTemp/js/jquery.scrollUp.min.js"></script>
        <script src="mainTemp/js/price-range.js"></script>
        <script src="mainTemp/js/jquery.prettyPhoto.js"></script>
        <script src="mainTemp/js/main.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            String error = (String) request.getAttribute("ERROR");

        %> 
        <div class="container text-center">
            <div class="logo-404">
                <a href="index.jsp"><img src="images/home/logo.png" alt="" /></a>
            </div>
            <div class="content-404">
                <img src="mainTemp/images/404/404.png" class="img-responsive" alt="" />
                <h1><b>OPPS!</b> We Couldn’t Find this Page</h1>
                <p><font color ="red">
                    <%= error %>
                    </font></p>
                <h2><a href="MainController">Bring me back Home</a></h2>
                <div style="clear: both; margin-bottom: 40px"></div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
