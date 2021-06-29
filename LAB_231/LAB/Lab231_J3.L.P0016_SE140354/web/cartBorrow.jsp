<%-- 
    Document   : cartBorrow
    Created on : May 13, 2021, 2:02:16 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>

        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>About Us</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">	
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="mainTemp/css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="mainTemp/css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="mainTemp/css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="mainTemp/images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="mainTemp/css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="mainTemp/css/owl.carousel.min.css">
        <link rel="stylesheet" href="mainTemp/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

        <script src="mainTemp/js/jquery.min.js"></script>
        <script src="mainTemp/js/popper.min.js"></script>
        <script src="mainTemp/js/bootstrap.bundle.min.js"></script>
        <script src="mainTemp/js/jquery-3.0.0.min.js"></script>
        <script src="mainTemp/js/plugin.js"></script>
        <!-- sidebar -->
        <script src="mainTemp/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="mainTemp/js/custom.js"></script>
        <!-- javascript --> 
        <script src="mainTemp/js/owl.carousel.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
        <!-- Javascript files-->

        <script>
            $(document).ready(function () {
                $(".fancybox").fancybox({
                    openEffect: "none",
                    closeEffect: "none"
                });

                $(".zoom").hover(function () {

                    $(this).addClass('transition');
                }, function () {

                    $(this).removeClass('transition');
                });
            });

        </script> 
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h1>Welcome ${sessionScope.txtUsername} to Home Page!</h1>
        <!-- banner section start -->
        <div class="layout_padding banner_section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <h1 class="banner_taital">BORROW CART</h1>
                        <p class="browse_text">Browse from more than 15,000,000 adverts while new ones come on daily bassis</p>
                        <div class="banner_bt">
                            <button class="read_bt"><a href="MainController?action=Logout">Logout</a></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- banner section end -->


        <!-- search box start -->
        <div class="container">
            <div class="search_box">
                <c:if test="${sessionScope.Cart == null}">
                    <h3><font color="red">Please add to cart about something</font></h3>
                    </c:if>
                    <c:if test="${requestScope.wrongQuantity != null}">
                    <font color="red">${requestScope.wrongQuantity}</font>
                </c:if>
                <c:if test="${sessionScope.Cart != null || sessionScope.Cart.cart.size() > 0}">
                    <form action="Order" method="POST">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="date"  class="email_boton" placeholder="Search for item name" name="txtDateBegin" required>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="date"  class="email_boton" placeholder="Time for pick up" name="txtDateReturn" required>
                                </div>
                            </div>                     
                        </div>


                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th class="col-auto">NO.</th>
                                    <th class="col-auto">Item ID</th>
                                    <th class="col-auto">Item Name</th>
                                    <th class="col-auto">Image</th>
                                    <th class="col-auto">Quantity</th>
<!--                                    <th class="col-auto">Date of Begin</th>
                                    <th class="col-auto">Date of End</th>-->
                                    <th class="col-auto"></th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="shop" value="${sessionScope.Cart.cart.values()}"/>
                                <c:forEach items="${shop}" var="dto" varStatus="counter"> 
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${dto.itemID}</td>
                                        <td><img src="${dto.imgUrl}" style="width: 50xp; height: 50px"/></td>
                                        <td>${dto.itemName}</td>
                                        <td>
                                            <c:if test="${dto.quantity > 1}">
                                                <button><a href="UserCartController?UAction=Decrease&txtItemDown=${dto.itemID}" style="color: black">-</a></button>
                                            </c:if>
                                            <input class="input-qty" type="text" name="txtQuan" value="${dto.quantity}"/>
                                            <button><a href="UserCartController?UAction=Update&txtItemUp=${dto.itemID}" style="color: black">+</a></button>
                                        </td>
<!--                                        <td> <input type="date" name="txtDateBegin" value="" required/> </td>
                                        <td><input type="date" name="txtDateReturn" value="" required/></td>-->
                                        <td><button><a href="UserCartController?UAction=Cancel&txtItemIRe=${dto.itemID}">Cancel</a></button></td>

                                <input type="hidden" name="txtItemID" value="${dto.itemID}" />
                                <input type="hidden" name="txtItemName" value="${dto.itemName}" />
                                <input type="hidden" name="txtQuantity" value="${dto.quantity}" />
                                <input type="hidden" name="txtImg" value="${dto.imgUrl}" />
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <div class="banner_bt">
                            <button class="read_bt" name="OAction" value="Booking">Confirm</button>
                        </div>


                    </form>
                </c:if>
            </div>
        </div>
        <!-- search box END -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
