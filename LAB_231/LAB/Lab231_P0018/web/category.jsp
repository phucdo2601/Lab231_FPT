<%-- 
    Document   : category
    Created on : June 17, 2021, 12:57:44 PM
    Author     : ASUS
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
                        <div class="price-range"><!--price-range-->
                            <h2>Price Range</h2>
                            <div class="well text-center">
                                <!--                                <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
                                                                <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>-->
                                <form action="MainController" method="POST">
                                    <input type="text" placeholder="Price Begin" name="txtPriceBegin" value=""/>
                                    <input type="text" placeholder="Price End" name="txtPriceEnd" value="" />
                                    <button name="action" value="searchPriceRange">Search</button>
                                </form>
                            </div>
                        </div><!--/price-range-->
                        <h2>Category</h2>
                        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                            <c:forEach items="${requestScope.listCategory}" var="o">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <c:url var="searchCate" value="MainController">
                                                <c:param name="action" value="searchByCateID"/>
                                                <c:param name="id" value="${o.cateID}"/>

                                            </c:url>
                                            <ul class="btn btn-default add-to-cart ${tag == o.cateID ? "active":""}"><a href="${searchCate}">${o.cateName}</a></ul>    
                                        </h4>
                                    </div>
                                </div>
                            </c:forEach>

                        </div><!--/category-products-->

                        <div class="shipping text-center"><!--shipping-->
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">

                                        <img src="images/${requestScope.lastProduct.imgUrl}" alt="" />
                                        <h2>
                                            <fmt:formatNumber minIntegerDigits="0">
                                                ${requestScope.lastProduct.price}
                                            </fmt:formatNumber>
                                            VND</h2>
                                        <p>${requestScope.lastProduct.itemName} </p>
                                        <div class="row">

                                            <p>Day Of Post:${lastProduct.dateOfCreate}</p>
                                        </div>
<!--                                        <a href="CartControlServlet?productID=${lastProduct.itemID}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>-->

                                        <form action="MainController" method="POST" class="productinfo text-center">
                                            <input type="hidden" name="txtProductID" value="${lastProduct.itemID}" />
                                            <input type="hidden" name="txtProductName" value="${lastProduct.itemName}" />
                                            <input type="hidden" name="txtImage" value="${lastProduct.imgUrl}" />
                                            <input type="hidden" name="txtPrice" value="${lastProduct.price}" />
                                            <input type="hidden" name="txtUsernameLogin" value="${sessionScope.USERNAME}" />
                                            <c:if test="${lastProduct.quantity > 0}">
                                                <c:if test="${sessionScope.roleAcc != 'admin'}">
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
