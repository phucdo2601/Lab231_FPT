<%-- 
    Document   : Manager
    Created on : May 14, 2021, 9:22:34 AM
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
    </head>
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

            <div class="container">
                <div class="search_box">
                    <form action="AOrder" method="POST">

                        <div class="row">
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="text"  class="email_boton" placeholder="Search for Booking ID" name="txtBookingIDSearch" required>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    Date Begin Borrow:
                                    <input type="date"  class="email_boton" placeholder="Time for pick up Date Begin" name="txtDateBeginSearch" required>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    Date End Borrow:
                                    <input type="date"  class="email_boton" placeholder="Time for pick up Date End" name="txtDateEndSearch" required>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="text"  class="email_boton" placeholder="Search for resource name" name="txtItemName" required>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <!--<input type="text" class="email_boton" placeholder="category" name="Email">-->
                                    <select name="cboStatusRole">
                                    <c:forEach items="${requestScope.listBookStatus}" var="cate">
                                        <option>${cate.bookStatusID}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-3">
                        <div class="form-group">
                            <button class="search_bt" type="submit" name="AAction" value="AdminSearch">Search</button>
                        </div>
                    </div>

                    <c:if test="${requestScope.errorMessage != null}">
                        <div class="fashion_menu" style="color: red">
                            <h1>${requestScope.errorMessage}</h1>
                        </div>
                    </c:if>
                </form>

            </div>

        </div>

        <c:set var="listLoad" value="${requestScope.listBookStatus}"/>
        <c:set var="countNum" value="${requestScope.pageNumAdmin}"/>
        <c:if test="${listLoad != null and countNum != null }">
            <!-- search box start -->


            <div class="search_box">
                <c:if test="${requestScope.responseAdminMsg != null}">
                    <h3>
                        <font color="brown">
                        ${requestScope.responseAdminMsg}
                        </font>
                    </h3>
                </c:if>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="col-auto">NO.</th>
                            <th class="col-auto">Username</th>
                            <th class="col-auto">Booking ID</th>
                            <th class="col-auto">Date of booking</th>
                            <th class="col-auto">Date of Confirm</th>
                            <th class="col-auto">Status</th>
                            <th class="col-auto">Approval</th>
                            <th class="col-auto">Reject</th>
                            <th class="col-auto"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="orderConfirm" value="${requestScope.AdminPageOrContent}"/>
                        <c:forEach items="${orderConfirm}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.userId}</td>
                                <td>${dto.bookingID}</td>
                                <td>${dto.dateOfBook}</td>
                                <td>
                                    <c:if test="${dto.dateOfConfirm eq null}">
                                        <h3 style="color: #003eff">WAITING CONFIRM</h3>
                                    </c:if>
                                    <c:if test="${dto.dateOfConfirm != null}">
                                        ${dto.dateOfConfirm}
                                    </c:if>
                                </td>
                                <td>${dto.status}</td>

                        <form action="AOrder" method="POST">
                            <c:if test="${dto.status eq 'New'}">

                                <td><button name="AAction" value="Approval">Approval</button></td>
                                <td><button name="AAction" value="Reject">Reject</button></td>
                            </c:if>
                            <c:if test="${dto.status eq 'Accept'}">
                                <td style="color: green">Approval Done</td>
                                <td style="color: red">Not thing</td>
                            </c:if>
                            <c:if test="${dto.status eq 'Delete'}">
                                <td style="color: red">Not thing</td>
                                <td style="color: green">Reject Done</td>
                            </c:if>
                            <c:if test="${dto.status eq 'inActive'}">
                                <td style="color: red">User Deleted</td>
                                <td style="color: red">User Deleted</td>
                            </c:if>
                            <c:if test="${dto.status eq 'Returned'}">
                                <td style="color: red">User Returned</td>
                                <td style="color: red">User Returned</td>
                            </c:if>   
                            <input type="hidden" name="txtBookingID" value="${dto.bookingID}" />
                            <td><button name="AAction" value="viewDetail">View Details</button></td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="banner_bt">
                    <c:forEach begin="1" end="${requestScope.pageNumAdmin}" var="i">
                        <a href="AdminViewOrderList?index=${i}" style="color: #ff9933">${i}</a>
                    </c:forEach>
                </div>
            </div>
        </c:if>

        <c:set var="adminSearch" value="${requestScope.adminListSearch}"/>
        <c:if test="${not empty adminSearch}">
            <div class="search_box">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="col-auto">NO.</th>
                            <th class="col-auto">Username</th>
                            <th class="col-auto">Booking ID</th>
                            <th class="col-auto">Date of booking</th>
                            <th class="col-auto">Date of Confirm</th>
                            <th class="col-auto">Status</th>
                            <th class="col-auto">Approval</th>
                            <th class="col-auto">Reject</th>
                            <th class="col-auto"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${adminSearch}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.userId}</td>
                                <td>${dto.bookingID}</td>
                                <td>${dto.dateOfBook}</td>
                                <td>
                                    <c:if test="${dto.dateOfConfirm eq null}">
                                        <h3 style="color: #003eff">WAITING CONFIRM</h3>
                                    </c:if>
                                    <c:if test="${dto.dateOfConfirm != null}">
                                        ${dto.dateOfConfirm}
                                    </c:if>
                                </td>
                                <td>${dto.status}</td>

                        <form action="AOrder" method="POST">
                            <c:if test="${dto.status eq 'New'}">

                                <td><button name="AAction" value="Approval">Approval</button></td>
                                <td><button name="AAction" value="Reject">Reject</button></td>
                            </c:if>
                            <c:if test="${dto.status eq 'Accept'}">
                                <td style="color: green">Approval Done</td>
                                <td style="color: red">Not thing</td>
                            </c:if>
                            <c:if test="${dto.status eq 'Delete'}">
                                <td style="color: red">Not thing</td>
                                <td style="color: green">Reject Done</td>
                            </c:if>
                            <c:if test="${dto.status eq 'inActive'}">
                                <td style="color: red">User Deleted</td>
                                <td style="color: red">User Deleted</td>
                            </c:if>
                            <c:if test="${dto.status eq 'Returned'}">
                                <td style="color: red">User Returned</td>
                                <td style="color: red">User Returned</td>
                            </c:if> 
                            <input type="hidden" name="txtBookingID" value="${dto.bookingID}" />
                            <td><button name="AAction" value="viewDetail">View Details</button></td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="banner_bt">
                    <c:forEach begin="1" end="${requestScope.pageNumAdmin}" var="i">
                        <a href="AdminViewOrderList?index=${i}" style="color: #ff9933">${i}</a>
                    </c:forEach>
                </div>
            </div>
        </c:if>
        <!-- search box END -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
