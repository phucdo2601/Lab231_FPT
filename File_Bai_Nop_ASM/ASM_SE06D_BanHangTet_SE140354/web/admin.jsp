<%-- 
    Document   : admin
    Created on : Jan 22, 2021, 8:37:11 PM
    Author     : phucd
--%>

<%@page import="phucdn.dao.CategoryDAO"%>
<%@page import="phucdn.dtos.CategoryDTO"%>
<%@page import="phucdn.dao.AccountDAO"%>
<%@page import="phucdn.dtos.AccountDTO"%>
<%@page import="java.util.List"%>
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
        <h1>Hello <%= session.getAttribute("USERNAME")%>!</h1>

        <p><a  class="btn btn-fefault cart" href="adminAccount.jsp">
                <i class="fa fa-shopping-cart"></i>
                Management Account
            </a></p></br>
        <p><a  class="btn btn-fefault cart" href="adminCategory.jsp">
                <i class="fa fa-shopping-cart"></i>
                Management Category
            </a></p></br>
        <p><a  class="btn btn-fefault cart" href="adminProduct.jsp">
                <i class="fa fa-shopping-cart"></i>
                Management Product
            </a></p></br>
        <p><a  class="btn btn-fefault cart" href="adminOrder.jsp">
                <i class="fa fa-shopping-cart"></i>
                Management Order
            </a></p>
            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
