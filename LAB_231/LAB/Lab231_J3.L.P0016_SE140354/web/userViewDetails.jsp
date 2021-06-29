<%-- 
    Document   : userViewDetails
    Created on : May 18, 2021, 4:49:29 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>User View Booking Details</title>
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
    <script src=mainTemp/js/owl.carousel.js"></script>
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
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <!-- banner section start -->
            <div class="layout_padding banner_section">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <h1 class="banner_taital">MANAGER REQUEST</h1>
                            <p class="browse_text"></p>
                            <div class="banner_bt">
                                <button class="read_bt"><a href="MainController?action=Logout">Logout</a></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- banner section end -->
            <div class="search_box">


                <form action="AOrder" method="POST">

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="col-auto">NO.</th>
                                <th class="col-auto">Booking Details ID</th>
                                <th class="col-auto">Booking ID</th>
                                <th class="col-auto">Item ID</th>
                                <th class="col-auto">Item Name</th>
                                <th class="col-auto">Img</th>
                                <th class="col-auto">Quantity</th>
                                <th class="col-auto">Date of Begin</th>
                                <th class="col-auto">Date of End</th>                           
                            </tr>
                        </thead>
                        <tbody>
                        <c:set var="details" value="${requestScope.userListDetails}"/>
                        <c:forEach items="${details}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.bookingDetailsID}</td>
                                <td>${dto.bookingID}</td>
                                <td>${dto.itemID}</td>
                                <td>${dto.itemName}</td>
                                <td> <img src="${dto.imgUrl}" style="width: 50px; height: 50px"/>
                                </td>
                                <td>${dto.quantity}</td>
                                <td>${dto.dateOfBegin}</td>
                                <td>${dto.dateOfEnd}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
