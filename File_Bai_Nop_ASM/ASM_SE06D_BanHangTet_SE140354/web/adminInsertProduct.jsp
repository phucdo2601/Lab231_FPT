<%-- 
    Document   : adminInsertProduct
    Created on : Jan 29, 2021, 4:42:23 PM
    Author     : phucd
--%>

<%@page import="phucdn.dtos.ProductErrorObject"%>
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

            <h1>Insert a new Product!</h1>
        <%
            String productIDError = "";
            String categoryIDError = "";
            String productIDIsExíted = "";
            String productNameError = "";
            String imageError = "";
            String priceError = "";
            String quantityError = "";
            String saleError = "";
            String unitError = "";
            ProductErrorObject errorObjPro = (ProductErrorObject) request.getAttribute("INVALID_PRO");
            if (errorObjPro != null) {
                if (errorObjPro.getProductIDError() != null) {
                    productIDError = errorObjPro.getProductIDError();
                }
                if (errorObjPro.getProductIDIsExisted() != null) {
                    productIDIsExíted = errorObjPro.getProductIDIsExisted();
                }
                if (errorObjPro.getCategoryIDError() != null) {
                    categoryIDError = errorObjPro.getCategoryIDError();
                }
                if (errorObjPro.getProductNameError() != null) {
                    productNameError = errorObjPro.getProductNameError();
                }
                if (errorObjPro.getImageError() != null) {
                    imageError = errorObjPro.getImageError();
                }
                if (errorObjPro.getPriceError() != null) {
                    priceError = errorObjPro.getPriceError();
                }
                if (errorObjPro.getQuantityError() != null) {
                    quantityError = errorObjPro.getQuantityError();
                }
                if (errorObjPro.getSaleError() != null) {
                    saleError = errorObjPro.getSaleError();
                }
                if (errorObjPro.getUnitError() != null) {
                    unitError = errorObjPro.getUnitError();
                }
                
            }
        %>
        <form action="AdminMainController" method="POST">
            Product id: <input type="text" name="txtProductID" value="" />
            <font color ="red">
            <%= productIDError%>
            </font>
            </br>
            Category id: <input type="text" name="txtCategoryID" value="" />
            <font color ="red">
            <%= categoryIDError %>
            </font>
            </br>
            Product name: <input type="text" name="txtProductName" value="" />
            <font color ="red">
            <%= productNameError %>
            </font>
            </br>
            Image: <input type="text" name="txtImage" value="" />
            <font color ="red">
            <%= imageError %>
            </font>
            </br>
            Price: <input type="text" name="txtPrice" value="" />
            <font color ="red">
            <%= priceError %>
            </font>
            </br>
            Quantity: <input type="text" name="txtQuantity" value="" />
            <font color ="red">
            <%= quantityError %>
            </font>
            </br>
            Sale: <input type="text" name="txtSale" value="" />
            <font color ="red">
            <%= saleError %>
            </font>
            </br>
            Unit: <input type="text" name="txtUnit" value="" />
            <font color ="red">
            <%= unitError  %>
            </font>
            </br>
            <input type="submit" value="InsertProduct" name="AAction" />
            <font color ="red">
            <%= productIDIsExíted %>
            </font>
        </form>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
