<%-- 
    Document   : category
    Created on : Jan 14, 2021, 12:06:36 PM
    Author     : phucd
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.NumberFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <form action="MainController" method="POST">
            <section>
                <div class="col-sm-3">
                    <div class="left-sidebar">
                        <h2>Category</h2>
                        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                            <c:forEach items="${requestScope.listCategory}" var="o">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <ul class="btn btn-default add-to-cart ${tag == o.categoryID ? "active":""}"><a href="UserCategoryServlet?cateID=${o.categoryID}">${o.categoryName}</a></ul>    
                                        </h4>
                                    </div>
                                </div>
                            </c:forEach>

                        </div><!--/category-products-->

                        <div class="shipping text-center"><!--shipping-->
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">

                                        <img src="${requestScope.lastProduct.image}" alt="" />
                                        <h2>
                                            <fmt:formatNumber minIntegerDigits="0">
                                                ${requestScope.lastProduct.price}
                                            </fmt:formatNumber>
                                            VND</h2>
                                        <p>${requestScope.lastProduct.productName} </p>
                                        <div class="row">
                                            <p>Unit:<a href="#" style="color: red"> ${lastProduct.unit}</a></p>
                                            <p>Day Of Post:${lastProduct.dateOfPost}</p>
                                        </div>
<!--                                        <a href="CartControlServlet?productID=${lastProduct.productID}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>-->

                                        <form action="MainController" method="POST" class="productinfo text-center">
                                            <input type="hidden" name="txtProductID" value="${lastProduct.productID}" />
                                            <input type="hidden" name="txtProductName" value="${lastProduct.productName}" />
                                            <input type="hidden" name="txtImage" value="${lastProduct.image}" />
                                            <input type="hidden" name="txtPrice" value="${lastProduct.price}" />
                                            <input type="hidden" name="txtUsernameLogin" value="${sessionScope.USERNAME}" />
                                            <c:if test="${lastProduct.quantity > 0}">
                                                <c:if test="${sessionScope.roleAcc == 'user'}">
                                                    <button class="btn btn-default add-to-cart" name="action" value="Add to Cart">Add to cart</button>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${lastProduct.quantity <= 0}">
                                                <button onclick="alert('Empty Product')" type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Empty product</button>
                                            </c:if>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div><!--/shipping-->

                        <div style="clear: both; margin-bottom: 40px"></div>
                    </div>
                </div>
            </section> 
        </form> 
    </body>
</html>
