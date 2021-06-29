<%-- 
    Document   : viewOrderDetail
    Created on : Mar 9, 2021, 9:42:55 PM
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
        <jsp:include page="header.jsp"></jsp:include>
            <section>
                <div class="container">
                    <div class="row">

                    <c:forEach items="${UVdetail}" var="detail" varStatus="counter">
                        <div class="col-sm-9 padding-right">
                            <div class="product-details"><!--product-details-->
                                <div class="col-sm-5">
                                    <div class="view-product">
                                        <img src= "${detail.image}" style="height: 300px; width: 300px" alt= />
                                        <h3>${detail.orderDetailID}</h3>
                                        <!--                                        <h3>ZOOM</h3>-->
                                    </div>
                                    <!--                                    <div id="similar-product" class="carousel slide" data-ride="carousel">
                                    
                                                                             Wrapper for slides 
                                                                            <div class="carousel-inner">
                                                                                <div class="item active">
                                                                                    <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
                                                                                    <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
                                                                                    <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
                                                                                </div>
                                                                                <div class="item">
                                                                                    <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
                                                                                    <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
                                                                                    <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
                                                                                </div>
                                                                                <div class="item">
                                                                                    <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
                                                                                    <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
                                                                                    <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
                                                                                </div>
                                    
                                                                            </div>
                                    
                                                                             Controls 
                                                                            <a class="left item-control" href="#similar-product" data-slide="prev">
                                                                                <i class="fa fa-angle-left"></i>
                                                                            </a>
                                                                            <a class="right item-control" href="#similar-product" data-slide="next">
                                                                                <i class="fa fa-angle-right"></i>
                                                                            </a>
                                                                        </div>-->

                                </div>
                                <div class="col-sm-7">
                                    <div class="product-information"><!--/product-information-->
                                        <img src="mainTemp/images/product-details/new.jpg" class="newarrival" alt="" />
                                        <h2>${detail.productName}</h2>
                                        <p>ID Product: ${detail.productID} </p>
                                        <!--                                    <img src="images/product-details/rating.png" alt="" />-->
                                        <span>
                                            <span>
                                                <fmt:formatNumber minIntegerDigits="0">
                                                ${detail.price} 
                                                </fmt:formatNumber>
                                                VND</span>
                                            <!--                                            <label>Quantity:</label>
                                                                                        <input type="text" value="3" />-->

                                        </span>
                                        <%--<p><a  class="btn btn-fefault cart" href="CartControlServlet?productID=${detail.productID}">
                                            <i class="fa fa-shopping-cart"></i>
                                            Add to cart
                                        </a></p>--%>


                                        <p><b>Quantity:</b>${detail.quantity} </p>
                                        <p><b>Brand:</b> E-SHOPPER</p>
                                        <!--                                        
                                                                                </form>-->
                                        <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
                                    </div><!--/product-information-->
                                </div>
                            </div><!--/product-details-->
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
