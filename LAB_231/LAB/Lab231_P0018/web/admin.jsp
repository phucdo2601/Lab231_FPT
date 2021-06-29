<%-- 
    Document   : admin
    Created on : June 17, 2021, 12:57:44 PM
    Author     : ASUS
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
        <h1>Welcome ${sessionScope.USERNAME} to PhucDN's Store !</h1>



        <p><a  class="btn btn-fefault cart" href="AdminMainController?AAction=ALoadItemPage">
                <i class="fa fa-shopping-cart"></i>
                Management Product
            </a></p></br>
        <!--        <p><a  class="btn btn-fefault cart" href="AdminMainController?AAction=ALoadDiscountPage">
                        <i class="fa fa-shopping-cart"></i>
                        Management Discount
                    </a></p>-->
        <form action="AdminMainController" method="POST">
            <button class="btn btn-fefault cart" type="submit" name="AAction" value="ALoadDiscountPage"><i class="fa fa-shopping-cart"></i>Management Discount</button>
        </form>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
