<%-- 
    Document   : adminUpdateCategory
    Created on : Jan 28, 2021, 9:21:07 PM
    Author     : phucd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="phucdn.dtos.CategoryErrorObject"%>
<%@page import="phucdn.dtos.CategoryDTO"%>
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
        <!--chua hoan tat-->
        <jsp:include page="header.jsp"></jsp:include>
        <%
            CategoryDTO cateDto = (CategoryDTO) request.getAttribute("cateDto");
            CategoryErrorObject errorObj = (CategoryErrorObject) request.getAttribute("INVALID");
            String categoryIDError = "";
            String categoryNameError = "";
            String descriptionError = "";
            if (errorObj != null) {
                if (errorObj.getCategoryIDError() != null) {
                    categoryIDError = errorObj.getCategoryIDError();
                }
                if (errorObj.getCategoryNameError() != null) {
                    categoryNameError = errorObj.getCategoryNameError();
                }
                if (errorObj.getCategoryDescriptionError() != null) {
                    descriptionError = errorObj.getCategoryDescriptionError();
                }
            }

        %>
        <%            if (cateDto != null) {

        %>
        <h1>Admin Update Category!</h1>
        <form action="AdminMainController" method="POST">
            Category ID : <input type="text" name="txtCategoryID" 
                                 value="<%= cateDto.getCategoryID()%>" readonly="true"/>
            <font color ="red">
            <%= categoryIDError%>
            </font>
            </br>
            Category Name : <input type="text" name="txtCategoryName"
                                   value="<%= cateDto.getCategoryName()%>" />
            <font color ="red">
            <%= categoryNameError%>
            </font>
            </br>
            Description : <input type="text" name="txtDescription" 
                                 value="<%= cateDto.getDescription()%>" />
            <font color ="red">
            <%= descriptionError%>
            </font>
            </br>
            Buying: <input type="checkbox" name="ckBuying" value="<%= cateDto.isStatus()%>"
                           <%
                               if (cateDto.isStatus()) {
                           %>
                           checked="checked"
                           <%
                               }
                           %>
                           />
            <br>
            <input type="hidden" name="txtCateLastSearchValue" value="<%= request.getParameter("txtCategory")%>" />
            <input type="submit" name="AAction" value="Update Category" />
        </form>
        <%
            }
        %>
        <c:if test="${requestScope.listProOutOfCateID != null}">
            <h1>List Product Out Of ${requestScope.txtCategoryID} </h1>
            <input type="hidden" name="txtCategoryFind" value="${requestScope.txtCategoryID}" />
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.listProOutOfCateID}" var="dto" varStatus="counter">
                        <c:if test="${dto.categoryID != requestScope.txtCategoryID}">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.productID}</td>
                                <td>${dto.productName}</td>
                                <td>
                                    <form action="AdminMainController" method="POST">
                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                        <input type="hidden" name="txtCategoryID" value="${requestScope.txtCategoryID}" />
                                        <input type="hidden" name="txtCategoryFind" value="<%= request.getParameter("txtCategoryID")%>" />
                                        <button  name="AAction" value="AddProductOnCateID">Add Product on Cart</button>
                                    </form>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach> 
                </tbody>
            </table>

        </c:if>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
