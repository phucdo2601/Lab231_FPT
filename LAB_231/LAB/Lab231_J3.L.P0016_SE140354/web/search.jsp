<%-- 
    Document   : search
    Created on : May 11, 2021, 9:19:28 PM
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

            $(function () {
                $("#txtDate").datepicker({dateFormat: 'dd-mm-yy'});
            });

        </script> 
    </head>

    <body>
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
        <!-- search box start -->
        <div class="container">
            <div class="search_box">
                <form action="MainController" method="POST">

                    <div class="row">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <input type="text"  class="email_boton" placeholder="Search for item name" name="txtItemName" required>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <input type="date"  class="email_boton" placeholder="Time for pick up" name="txtDateSearch" required>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <!--<input type="text" class="email_boton" placeholder="category" name="Email">-->
                                <select name="cboRole">
                                    <c:forEach items="${requestScope.cateList}" var="cate">
                                        <option>${cate.cateName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <button class="search_bt" type="submit" name="action" value="SearchItem">Search</button>
                            </div>
                        </div>
                        <c:if test="${requestScope.errorMessage != null}">
                            <div class="fashion_menu" style="color: red">
                                <h1>${requestScope.errorMessage}</h1>
                            </div>
                        </c:if>
                    </div>
                </form>

            </div>
            
        </div>
        <!-- search box end -->

    </body>

</html>
