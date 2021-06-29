<%-- 
    Document   : itemList
    Created on : May 12, 2021, 6:53:17 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        <!-- section PROMOTED start -->
        <c:if test="${requestScope.pageConItem != null}" >
            <div class=" layout_padding promoted_sectipon">
                <div class="container">
                    <h1 class="promoted_text">PROMOTED <span style="border-bottom: 5px solid #4bc714;">ADS</span></h1>
                    <div class="images_main">
                        <font color="red">
                        <c:if test="${requestScope.errorMessage != null}">
                            <h1 class="promoted_text">${requestScope.errorMessage}</h1>
                        </c:if>
                        </font>
                        <div class="row">
                            <c:forEach items="${requestScope.pageConItem}" var="dto">
                                <div class="col-sm-6 col-md-6 col-lg-3" style="margin-bottom: 30px">
                                    <input type="hidden" name="txtItemID" value="${dto.itemID}" />
                                    <div class="images"><img src="${dto.imgUrl}" style="width: 200px; height: 200px"></div>
                                    <button class="promoted_bt">${dto.itemName}</button>
                                    <div class="eye-icon">Color ID:<span class="like-icon">${dto.color}</span></div>
                                    <div class="eye-icon">Category:<span class="like-icon">${dto.cateID}</span></div>
                                    <div class="eye-icon">Quantity: <span class="like-icon">${dto.quantity}</span></div>
                                    <div class="eye-icon">DateOfPost: <span class="like-icon">${dto.dateOfPost}</span></div>
<!--                                    <div class="numbar_text">30<span class="like-icon">01</span></div>-->

                                    <button class="mobile_bt" ><a href="UserViewBorrowDetailPageController?index=${dto.itemID}">Borrow</a></button>

                                </div>
                            </c:forEach>    
                        </div>
                    </div>

                    <div class=" layout_padding promoted_sectipon">
                        <div class="numbar_text">
                            <c:forEach begin="1" end="${requestScope.pageNum}" var="i">
                                <a href="LoadAllGeneralServiceController?index=${i}">${i}</a>
                            </c:forEach>
                        </div>
                    </div>

                </div>
            </div>
        </c:if>
        <!-- section PROMOTED end -->

        <c:if test="${requestScope.uItemSearch != null}">
            ${requestScope.findDone}
            <div class=" layout_padding promoted_sectipon">
                <div class="container">
                    <h1 class="promoted_text">PROMOTED <span style="border-bottom: 5px solid #4bc714;">ADS</span></h1>
                    <div class="images_main">

                        <div class="row">
                            <c:forEach items="${requestScope.uItemSearch}" var="dtos">
                                <div class="col-sm-6 col-md-6 col-lg-3" style="margin-bottom: 30px">
                                    <input type="hidden" name="txtItemID" value="${dtos.itemID}" />
                                    <div class="images"><img src="mainTemp/images/img-1.png" style="width: 100%;"></div>
                                    <button class="promoted_bt">${dtos.itemName}</button>
                                    <div class="eye-icon">Color ID:<span class="like-icon">${dtos.color}</span></div>
                                    <div class="eye-icon">Category:<span class="like-icon">${dtos.cateID}</span></div>
                                    <div class="eye-icon">Quantity: <span class="like-icon">${dtos.quantity}</span></div>

                                    <div class="numbar_text">30<span class="like-icon">01</span></div>

                                    <button class="mobile_bt" ><a href="UserViewBorrowDetailPage?index=${dtos.itemID}">Borrow</a></button>

                                </div>
                            </c:forEach>    
                        </div>
                    </div>

                    <c:forEach begin="1" end="${requestScope.pageNum}" var="i">
                        <a href="LoadAllGeneralServiceController?index=${i}">${i}</a>
                    </c:forEach>
                

                </div>
            </div>
        </c:if>
    </body>

</html>