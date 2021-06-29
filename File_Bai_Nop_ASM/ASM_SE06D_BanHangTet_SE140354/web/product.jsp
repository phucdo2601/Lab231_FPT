<%-- 
    Document   : product
    Created on : Feb 5, 2021, 6:10:00 PM
    Author     : phucd
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="col-sm-9 padding-right">
            <div class="features_items"><!--features_items-->
                <h2 class="title text-center"> <a href="MainController" style="color: #FE980F">Features Items</a> </h2>
                <div id="ajaxContent" class="row">
                    <c:forEach items="${requestScope.listProduct}" var="p">

                        <div class="productByAjax col-12 col-md-6 col-lg-4">       
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <img src="${p.image}" style="width: 200px; height: 200px" alt="" />
                                        <h2>
                                            <fmt:formatNumber minIntegerDigits="0">
                                                ${p.price} 
                                            </fmt:formatNumber>
                                            VND</h2>
                                        <p><a href="DetailServlet?productID=${p.productID}">${p.productName}</a></p>
                                        <input type="hidden" name="txtCategory" value="${p.categoryID}" />
                                        <!--<a href="CartControlServlet?productID=${p.productID}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>-->
                                        <form action="MainController" method="POST" class="productinfo text-center">
                                            <input type="hidden" name="txtProductID" value="${p.productID}" />
                                            <input type="hidden" name="txtProductName" value="${p.productName}" />
                                            <input type="hidden" name="txtImage" value="${p.image}" />
                                            <input type="hidden" name="txtPrice" value="${p.price}" />
                                            <input type="hidden" name="txtUsernameLogin" value="${sessionScope.USERNAME}" />
                                            <c:if test="${p.quantity > 0}">
                                                <c:if test="${sessionScope.roleAcc == 'user'}">
                                                    <button class="btn btn-default add-to-cart" name="action" value="Add to Cart">Add to cart</button>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${p.quantity <= 0}">
                                                <button onclick="alert('Empty Product')" type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Empty product</button>
                                            </c:if>
                                        </form>
                                    </div>
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <h2>${p.price} VND</h2>
                                            <p><a href="DetailServlet?productID=${p.productID}">${p.productName}</a></p>
                                            <input type="hidden" name="txtCategory" value="${p.categoryID}" />
                                            <!--<a href="CartControlServlet?productID=${p.productID}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>-->
                                            <form action="MainController" method="POST" class="productinfo text-center">
                                                <input type="hidden" name="txtProductID" value="${p.productID}" />
                                                <input type="hidden" name="txtProductName" value="${p.productName}" />
                                                <input type="hidden" name="txtImage" value="${p.image}" />
                                                <input type="hidden" name="txtPrice" value="${p.price}" />
                                                <input type="hidden" name="txtUsernameLogin" value="${sessionScope.USERNAME}" />
                                                <c:if test="${p.quantity > 0}">
                                                    <c:if test="${sessionScope.roleAcc == 'user'}">
                                                        <button class="btn btn-default add-to-cart" name="action" value="Add to Cart">Add to cart</button>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${p.quantity <= 0}">
                                                    <button onclick="alert('Empty Product')" type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Empty product</button>
                                                </c:if>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="choose">
                                    <ul class="nav nav-pills nav-justified">
                                        <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                        <li><a href="DetailServlet?productID=${p.productID}&cID=${p.categoryID}"><i class="fa fa-plus-square"></i>View More</a></li>
                                    </ul>
                                </div>
                            </div>         
                        </div>

                    </c:forEach>
                </div>
                <button onclick="loadMore()" class="btn btn-default get" >Load More</button>
            </div>

        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
                    function loadMore() {
                        var amount = document.getElementsByClassName("productByAjax").length;
                        $.ajax({
                            //duong dan chay den servlet giai quyet viec load them 3 san pham
                            url: "/ASM_SE06D_BanHangTet_SE140354/LoadMoreServelet",
                            type: "get", //send it through get method
                            data: {
                                exits: amount
                            },
                            success: function (data) {
                                var row = document.getElementById("ajaxContent");
                                row.innerHTML += data;
                            },
                            error: function (xhr) {
                                //Do Something to handle error
                            }
                        });
                    }

                    function searchByName(param) {
                        var txtSearchAjax = param.value;
                        $.ajax({
                            //duong dan chay den servlet giai quyet viec search tu dong
                            url: "/ASM_SE06D_BanHangTet_SE140354/UserSearchByAjaxServlet",
                            type: "get", //send it through get method
                            data: {
                                txtSearch: txtSearchAjax
                            },
                            success: function (data) {
                                var row = document.getElementById("ajaxContent");
                                row.innerHTML = data;
                            },
                            error: function (xhr) {
                                //Do Something to handle error
                            }
                        });
                    }
        </script>
    </body>
</html>
