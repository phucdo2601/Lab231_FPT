<%-- 
    Document   : borrowItemDetail
    Created on : May 13, 2021, 8:17:54 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <script src="mainTemp/https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
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
                        <h1 class="banner_taital">All You Need Is Here & Classified</h1>
                        <p class="browse_text">Browse from more than 15,000,000 adverts while new ones come on daily bassis</p>
                        <div class="banner_bt">
                            <button class="read_bt"><a href="MainController?action=Logout">Logout</a></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- banner section end -->

        <!-- client section start -->
        <div class="layout_padding clients_section">
            <div class="container">
                <!--                <div id="client_slide" class="carousel slide" data-ride="carousel">
                                    <ol class="carousel-indicators">
                                        <li data-target="#client_slide" data-slide-to="0" class="active"></li>
                                        <li data-target="#client_slide" data-slide-to="1"></li>
                                        <li data-target="#client_slide" data-slide-to="2"></li>
                                    </ol>
                                    <div class="carousel-inner">
                                        
                                </div>-->
                <div class="carousel-item active">
                    <div class="row">
                        <form action="UserCartController" method="POST">

                            <div class="col-sm-12">
                                <c:if test="${requestScope.itDe !=  null}">
                                    <h1 class="promoted_text">ITEM <span
                                            style="border-bottom: 5px solid #4bc714;">REVIEW</span></h1>
                                    <div class="client_img"><img src="${requestScope.itDe.imgUrl}"></div>
                                    <h1 class="client_text" style="color: red">Item id: ${requestScope.itDe.itemID}</h1>
                                    <h2 class="client_text">Item name: ${requestScope.itDe.itemName}</h2>
                                    <h2 class="client_text">Quantity: ${requestScope.itDe.quantity}</h2>
                                    <input type="hidden" name="txtItemID" value="${requestScope.itDe.itemID}" />
                                    <input type="hidden" name="txtItemName" value="${requestScope.itDe.itemName}" />
                                    <input type="hidden" name="txtImg" value="${requestScope.itDe.imgUrl}" />
                                    <p class="adiser_text">${requestScope.itDe.status}</p>

                                </c:if>
                            </div>
                            <c:if test="${sessionScope.roleUser == 'ld' && requestScope.itDe.status == 'OPT'}">
                                <div class="form-group">
                                    <button class="search_bt" type="submit" name="UAction" value="Add To Cart">Add to Cart Leader</button>
                                </div>
                            </c:if>
                            <c:if test="${sessionScope.roleUser != 'mng' && requestScope.itDe.status != 'OPT'}">
                                <div class="form-group">
                                    <button class="search_bt" type="submit" name="UAction" value="Add To Cart">Add to Cart</button>
                                </div>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- client section end -->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
