<%-- 
    Document   : adminInsertCategory
    Created on : Jan 30, 2021, 9:06:02 PM
    Author     : phucd
--%>

<%@page import="phucdn.dtos.CategoryErrorObject"%>
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
            String categoryIDError = "";
            String categoryNameError = "";

            CategoryErrorObject errorObj = (CategoryErrorObject) request.getAttribute("INVALID");
            if (errorObj != null) {
                if (errorObj.getCategoryIDError() != null) {
                    categoryIDError = errorObj.getCategoryIDError();
                }
                if (errorObj.getCategoryNameError() != null) {
                    categoryNameError = errorObj.getCategoryNameError();
                }
            }

            if (errorObj != null) {
                if (true) {
        %>
        <div class="alert alert-danger" role="alert">
            <!--<font color ="red">-->
            <%= errorObj.getCategoryIDisExsited()%>
            <!--</font>-->
        </div>
        <%
                }
            }
        %>
        <section id="form">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="signup-form">
                            <h1>Welcome to Insert Category!</h1>
                            <form action="AdminMainController" method="POST">
                                Category ID: <input type="text" name="txtCategoryID" value="" />
                                <font color="red">
                                <%= categoryIDError %> 
                                </font>
                                </br>
                                Category Name: <input type="text" name="txtCategoryName" value="" />
                                <font color="red">
                                <%= categoryNameError%> 
                                </font>
                                </br>
                                Description: <input type="text" name="txtDescription" value="" />
                                </br>
<!--                                <input type="submit" value="InsertCategory" name="AAction" />-->
                                <button type="submit" value="InsertCategory" name="AAction" class="btn btn-default">InsertCategory</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>   
</html>
