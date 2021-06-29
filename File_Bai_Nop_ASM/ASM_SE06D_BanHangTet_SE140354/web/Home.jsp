<%-- 
    Document   : Home
    Created on : Jan 22, 2021, 5:28:14 PM
    Author     : phucd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ban Hang Tet 2021</title>

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
            <section>
                <div class="container">
                <jsp:include page="advertisementHead.jsp"></jsp:include> 
                <%
                    String user = "";
                    user = (String) session.getAttribute("USERNAME");
                    if (user != null) {
                        user = (String) session.getAttribute("USERNAME");
                    }
                %>
                <h1>Welcome <%= user%> to PhucDN's Store</h1>
                
                
                <a href="login.jsp">Sign in</a>
                <a href="createAccount.jsp">Sign Up</a>
                <div class="row">
                    <jsp:include page="category.jsp"></jsp:include>
                    <jsp:include page="product.jsp"></jsp:include>
                    </div>
                </div>
            </section>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
