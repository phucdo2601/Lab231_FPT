<%-- 
    Document   : adminUpdateProduct
    Created on : Jan 27, 2021, 11:09:19 PM
    Author     : phucd
--%>

<%@page import="phucdn.dtos.ProductErrorObject"%>
<%@page import="phucdn.dtos.ProductDTO"%>
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

            <h1>Admin Update Product!</h1>
        <%
            ProductDTO dto = (ProductDTO) request.getAttribute("DTO");
            ProductErrorObject errorObj = (ProductErrorObject) request.getAttribute("INVALID");
            String categoryError = "";
            String productNameError = "";
            String descriptionError = "";
            String priceError = "";
            String quantityError = "";
            String saleError = "";
            if (errorObj != null) {
                if (errorObj.getCategoryIDError() != null) {
                    categoryError = errorObj.getCategoryIDError();
                }
                if (errorObj.getProductNameError() != null) {
                    productNameError = errorObj.getProductNameError();
                }
                if (errorObj.getDescrptionError() != null) {
                    descriptionError = errorObj.getDescrptionError();
                }
                if (errorObj.getPriceError() != null) {
                    priceError = errorObj.getPriceError();
                }
                if (errorObj.getQuantityError() != null) {
                    quantityError = errorObj.getQuantityError();
                }
                if (errorObj.getSaleError() != null) {
                    saleError = errorObj.getSaleError();
                }

            }
        %>

        <form action="AdminMainController" method="POST">
            Product ID : <input type="text" name="txtProductID" 
                                value="<%= dto.getProductID()%>" readonly="true"/></br>
            Category ID : <input type="text" name="txtCategoryID" 
                                 value="<%= dto.getCategoryID()%>" />
            <font color ="red">
            <%= categoryError%>
            </font>
            </br>
            Product Name : <input type="text" name="txtProductName" 
                                  value="<%= dto.getProductName()%>" />
            <font color ="red">
            <%= productNameError%>
            </font>
            </br>
            Description : <input type="text" name="txtDescription" 
                                 value="<%= dto.getDescription()%>" />
            <font color ="red">
            <%= descriptionError%>
            </font>
            </br>
            Unit: <input type="text" name="txtUnit" 
                                value="<%= dto.getUnit() %>" />
            <font color ="red">
            <%= descriptionError %>
            </font>
            </br>
            Price : <input type="text" name="txtPrice" 
                           value="<%= dto.getPrice()%>" />
            <font color ="red">
            <%= priceError%>
            </font>
            </br>
            Quantity : <input type="text" name="txtQuantity" 
                              value="<%= dto.getQuantity()%>" />
            <font color ="red">
            <%= quantityError%>
            </font>
            </br>
            Sale : <input type="text" name="txtSale" 
                          value="<%= dto.getSale()%>" />
            <font color ="red">
            <%= saleError %>
            </font>
            </br>

            <input type="hidden" name="txtProduct" value="<%= request.getParameter("txtProduct")%>" />
            <input type="submit" name="AAction" value="UpdateProduct" />
        </form>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
