<%-- 
    Document   : itemListDetail
    Created on : May 12, 2021, 1:24:20 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            <!-- client section start -->
        <%--<c:if test="${requestScope.userItemSearch != null}">
            ${requestScope.findDone}

            <div class=" layout_padding promoted_sectipon">
                <div class="container">
                    <h1 class="promoted_text">PROMOTED <span style="border-bottom: 5px solid #4bc714;">ADS</span></h1>
                    <div class="images_main">
                        <div class="row">
                            <c:forEach items="${requestScope.userItemSearch}" var="uItemSearch">
                                <div class="col-sm-6 col-md-6 col-lg-3" style="margin-bottom: 30px">
                                    <input type="hidden" name="txtItemID" value="${userItemSearch.itemID}" />
                                    <div class="images"><img src="mainTemp/images/img-1.png" style="width: 100%;"></div>
                                    <button class="promoted_bt">${userItemSearch.itemID}</button>
                                    <div class="eye-icon">Color ID:<span class="like-icon"></span></div>
                                    <div class="eye-icon">Category:<span class="like-icon"></span></div>
                                    <div class="eye-icon">Quantity: <span class="like-icon"></span></div>

                                    <div class="numbar_text">30<span class="like-icon">01</span></div>

                                    <button class="mobile_bt" ><a href="UserViewBorrowDetailPage?index=${userItemSearch.itemID}">Borrow</a></button>

                                </div>
                            </c:forEach>    
                        </div>
                    </div>

                </div>
            </div>
        </c:if>--%>
        <!-- search box end -->
        <!-- banner section start -->
        <div class="layout_padding banner_section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <h1 class="banner_taital">SEARCH NET</h1>
                        <p class="browse_text">Browse from more than 15,000,000 adverts while new ones come on daily bassis</p>
                        <div class="banner_bt">
                            <button class="read_bt"><a href="MainController?action=Logout">Logout</a></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- banner section end -->
        <c:set var="result" value="${requestScope.userItemSearch}"/>


        <c:if test="${not empty result}">

            <div class="container">
                <div class="search_box">
                    
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="col-auto">No</th>
                                <th class="col-auto">ItemId</th>
                                <th class="col-auto">ItemName</th>
                                <th class="col-auto">CateID</th>
                                <th class="col-auto">Quantity</th>
                                <th class="col-auto">Status</th>
                                <th class="col-auto"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${result}" var="dto" varStatus="counter">
                                <tr>
                                    <td class="col-auto">${counter.count}</td>
                                    <td class="col-auto">${dto.itemID}</td>
                                    <td class="col-auto">${dto.itemName}</td>
                                    <td class="col-auto">${dto.cateID}</td>
                                    <td class="col-auto">${dto.quantity}</td>
                                    <td class="col-auto">${dto.status}</td>
                                    <td class="col-auto">
                                        <button class="mobile_bt"><a href="UserViewBorrowDetailPageController?index=${dto.itemID}">Borrow</a></button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>
        <c:if test="${empty result}">
            <h2>
                <font color="red">
                No recode for it
                </font>
            </h2>
            <button class="read_bt"><a href="LoadAllGeneralServiceController">Come Back Home Page</a></button>
        </c:if>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
