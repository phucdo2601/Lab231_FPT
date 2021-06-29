<%-- 
    Document   : advertisementHead
    Created on : Feb 5, 2021, 5:54:49 PM
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
        <section id="slider"><!--slider-->
            <div class="container">
                <div class="row">

                    <div class="col-sm-12">

                        <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                                <li data-target="#slider-carousel" data-slide-to="1"></li>
                                <li data-target="#slider-carousel" data-slide-to="2"></li>
                            </ol>
                            <c:forEach items="${listThreeNewProductOnAdv}" var="tp">
                                <div class="carousel-inner">

                                    <div class="item active">
                                        <div class="col-sm-6">
                                            <h1><span>P</span>-SHOPPER</h1>
                                            <h2>${tp.productName}</h2>
                                            <p>
                                                <fmt:formatNumber minIntegerDigits="0">
                                                    ${tp.price} 
                                                </fmt:formatNumber>
                                                VND</p>
                                            <button type="button" class="btn btn-default get"><a href="DetailServlet?productID=${tp.productID}&cID=${tp.categoryID}">Get it now</a></button>
                                        </div>
                                        <div class="col-sm-6">
                                            <img src="${tp.image}" style="width: 200px; height: 200px" class="girl img-responsive" alt="" /> 
                                            <img src="mainTemp/images/home/newArrival.jpg"  class="pricing" alt="" />
                                        </div>

                                    </div>

                                </div>
                            </c:forEach>  
                            <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                                <i class="fa fa-angle-left"></i>
                            </a>
                            <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </div>

                    </div>

                </div>
            </div>
        </section><!--/slider-->
    </body>
</html>
