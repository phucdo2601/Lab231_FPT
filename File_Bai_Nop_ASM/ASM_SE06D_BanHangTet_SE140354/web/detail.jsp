<%-- 
    Document   : deatail
    Created on : Jan 14, 2021, 12:57:44 PM
    Author     : phucd
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.NumberFormat"%>

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

        <%
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
        %>

        <jsp:include page="header.jsp"></jsp:include>
            <section>
                <div class="container">
                    <div class="row">
                    <jsp:include page="category.jsp"></jsp:include>

                        <div class="col-sm-9 padding-right">
                            <div class="product-details"><!--product-details-->
                                <div class="col-sm-5">
                                    <div class="view-product">
                                        <img src= ${detail.image} alt= />
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
                                    <img src="images/product-details/new.jpg" class="newarrival" alt="" />
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
                                    <p><b>Sale:</b> ${detail.sale} </p>
                                    <p><b>Date of Post:</b> ${detail.dateOfPost} </p>
                                    <p><b>Brand:</b> E-SHOPPER</p>
                                    <form action="MainController" method="POST" class="productinfo text-center">
                                        <input type="hidden" name="txtProductID" value="${detail.productID}" />
                                        <input type="hidden" name="txtProductName" value="${detail.productName}" />
                                        <input type="hidden" name="txtImage" value="${detail.image}" />
                                        <input type="hidden" name="txtPrice" value="${detail.price}" />
                                        <input type="hidden" name="txtUsernameLogin" value="${sessionScope.USERNAME}" />
                                        <c:if test="${detail.quantity > 0}">
                                            <c:if test="${sessionScope.roleAcc == 'user'}">
                                                <button class="btn btn-default add-to-cart" name="action" value="Add to Cart">Add to cart</button>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${detail.quantity <= 0}">
                                            <button onclick="alert('Empty Product')" type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Empty product</button>
                                        </c:if>
                                    </form>
                                    <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
                                </div><!--/product-information-->
                            </div>
                        </div><!--/product-details-->

                        <div class="category-tab shop-details-tab"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs">
                                    <li><a href="#details" data-toggle="tab">Details</a></li>
                                    <!--<li><a href="#companyprofile" data-toggle="tab">Company Profile</a></li>-->
                                    <li><a href="#tag" data-toggle="tab">Tag</a></li>
                                    <li class="active"><a href="#reviews" data-toggle="tab">Reviews (5)</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade" id="details" >

                                    <div class="col-sm-12">
                                        <ul style="background-color: #E0E0DA">
                                            <li><a href=""><i class="fa fa-user"></i>P-SHOPPER</a></li>
                                            <li><a href=""><i class="fa fa-clock-o"></i>
                                                    <fmt:formatDate type="time" value="${detail.dateOfPost}"/>

                                                </a></li>
                                            <li><a href=""><i class="fa fa-calendar-o"></i>
                                                    <fmt:formatDate type="date" value="${detail.dateOfPost}"/>
                                                </a></li>
                                        </ul>
                                        <p>${requestScope.detail.description}</p>
                                        <p><b>Write Your Review</b></p>

                                        <form action="#">
                                            <span>
                                                <input type="text" placeholder="Your Name"/>
                                                <input type="email" placeholder="Email Address"/>
                                            </span>
                                            <textarea name="" ></textarea>
                                            <b>Rating: </b> <img src="images/product-details/rating.png" alt="" />
                                            <button type="button" class="btn btn-default pull-right">
                                                Submit
                                            </button>
                                        </form>
                                    </div>

                                </div>

                                <!--                                <div class="tab-pane fade" id="companyprofile" >
                                                                    <div class="col-sm-3">
                                                                        <div class="product-image-wrapper">
                                                                            <div class="single-products">
                                                                                <div class="productinfo text-center">
                                                                                    <img src="images/home/gallery1.jpg" alt="" />
                                                                                    <h2>$56</h2>
                                                                                    <p>Easy Polo Black Edition</p>
                                                                                    <button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-3">
                                                                        <div class="product-image-wrapper">
                                                                            <div class="single-products">
                                                                                <div class="productinfo text-center">
                                                                                    <img src="images/home/gallery3.jpg" alt="" />
                                                                                    <h2>$56</h2>
                                                                                    <p>Easy Polo Black Edition</p>
                                                                                    <button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-3">
                                                                        <div class="product-image-wrapper">
                                                                            <div class="single-products">
                                                                                <div class="productinfo text-center">
                                                                                    <img src="images/home/gallery2.jpg" alt="" />
                                                                                    <h2>$56</h2>
                                                                                    <p>Easy Polo Black Edition</p>
                                                                                    <button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-sm-3">
                                                                        <div class="product-image-wrapper">
                                                                            <div class="single-products">
                                                                                <div class="productinfo text-center">
                                                                                    <img src="images/home/gallery4.jpg" alt="" />
                                                                                    <h2>$56</h2>
                                                                                    <p>Easy Polo Black Edition</p>
                                                                                    <button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>-->

                                <div class="tab-pane fade" id="tag" >
                                    <c:forEach items="${requestScope.listRecommend}" var="dto">
                                        <div class="col-sm-3">     
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <img src="${dto.image}" alt="" />
                                                        <h2>
                                                            <fmt:formatNumber minIntegerDigits="0">
                                                                ${dto.price}
                                                            </fmt:formatNumber>
                                                            VND
                                                        </h2>
                                                        <p><a href="DetailServlet?productID=${dto.productID}&cID=${dto.categoryID}">${dto.productName}</a></p>
                                                        <form action="MainController" method="POST">
                                                            <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                            <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                            <input type="hidden" name="txtImage" value="${dto.image}" />
                                                            <input type="hidden" name="txtPrice" value="${dto.price}" />
                                                            <input type="hidden" name="txtUsernameLogin" value="${sessionScope.USERNAME}" />
                                                            <c:if test="${dto.quantity > 0}">
                                                                <c:if test="${sessionScope.roleAcc == 'user'}">
                                                                    <button class="btn btn-default add-to-cart" name="action" value="Add to Cart">Add to cart</button>
                                                                </c:if>
                                                            </c:if>
                                                            <c:if test="${dto.quantity <= 0}">
                                                                <button onclick="alert('Empty Product')" type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Empty product</button>
                                                            </c:if>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>

                                <div class="tab-pane fade active in" id="reviews" >
                                    <div class="col-sm-12">
                                        <ul>
                                            <li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
                                            <li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
                                            <li><a href=""><i class="fa fa-calendar-o"></i>31 DEC 2014</a></li>
                                        </ul>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                                        <p><b>Write Your Review</b></p>

                                        <form action="#">
                                            <span>
                                                <input type="text" placeholder="Your Name"/>
                                                <input type="email" placeholder="Email Address"/>
                                            </span>
                                            <textarea name="" ></textarea>
                                            <b>Rating: </b> <img src="images/product-details/rating.png" alt="" />
                                            <button type="button" class="btn btn-default pull-right">
                                                Submit
                                            </button>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div><!--/category-tab-->

                        <div class="recommended_items"><!--recommended_items-->
                            <h2 class="title text-center">recommended items</h2>

                            <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">

                                    <div class="item active">
                                        <c:forEach items="${requestScope.listRecommend}" var="dto">
                                            <div class="col-sm-4">

                                                <div class="product-image-wrapper">
                                                    <div class="single-products">
                                                        <div class="productinfo text-center">
                                                            <img style="max-height: 200px; min-width: 200px" src=${dto.image} alt="" />
                                                            <h2>${dto.price}</h2>
                                                            <p><a href="DetailServlet?productID=${dto.productID}&cID=${dto.categoryID}">${dto.productName}</a></p>
                                                            <form action="MainController" method="POST" class="productinfo text-center">
                                                                <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                                                <input type="hidden" name="txtProductName" value="${dto.productName}" />
                                                                <input type="hidden" name="txtImage" value="${dto.image}" />
                                                                <input type="hidden" name="txtPrice" value="${dto.price}" />
                                                                <input type="hidden" name="txtUsernameLogin" value="${sessionScope.USERNAME}" />
                                                                <c:if test="${dto.quantity > 0}">
                                                                    <c:if test="${sessionScope.roleAcc == 'user'}">
                                                                        <button class="btn btn-default add-to-cart" name="action" value="Add to Cart">Add to cart</button>
                                                                    </c:if>
                                                                </c:if>
                                                                <c:if test="${dto.quantity <= 0}">
                                                                    <button onclick="alert('Empty Product')" type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Empty product</button>
                                                                </c:if>
                                                            </form>
                                                            <!--<button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button>-->
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </c:forEach>             
                                    </div>

                                </div>
                                <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
                                    <i class="fa fa-angle-left"></i>
                                </a>
                                <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
                                    <i class="fa fa-angle-right"></i>
                                </a>			
                            </div>
                        </div><!--/recommended_items-->

                    </div>

                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
