<%-- 
    Document   : History
    Created on : May 14, 2021, 1:28:03 PM
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
        <jsp:include page="header.jsp"></jsp:include>
            <!-- banner section start -->
            <div class="layout_padding banner_section">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <h1 class="banner_taital">HISTORY</h1>
                            <p class="browse_text"></p>
                            <div class="banner_bt">
                                <button class="read_bt"><a href="MainController?action=Logout">Logout</a></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- banner section end -->

        <c:set var="pageConUser" value="${requestScope.pageConByUserID}"/>
        <c:set var="uNumPage" value="${requestScope.pageNumUser}"/>

        <!-- search box start -->
        <div class="container">
            <form action="Order" method="POST">

                <div class="search_box">
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <input type="text"  class="email_boton" placeholder="Search for item name" name="txtItemName" required>
                            </div>
                        </div>

                        <div class="col-sm-3">
                            <div class="form-group">
                                <button class="search_bt" type="submit" name="OAction" value="USearchBookByName">Search By Item Name</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <div class="container">
            <form action="Order" method="POST">

                <div class="search_box">
                    <div class="row">

                        <div class="col-sm-3">
                            <div class="form-group">
                                <input type="date"  class="email_boton" placeholder="Time for request" name="txtDateConfirm" required>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <button class="search_bt" type="submit" name="OAction" value="USearchBookByDate">Search By Date Confirm</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>


        <c:if test="${pageConUser != null && uNumPage != null}">
            <div class="search_box">


                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="col-auto">NO.</th>
                            <th class="col-auto">Booking ID</th>
                            <th class="col-auto">Date of Create</th>
                            <th class="col-auto">Date of Confirm</th>
                            <th class="col-auto">Status</th>
                            <th class="col-auto">Delete</th>
                            <th class="col-auto">Return</th>
                            <th class="col-auto">View Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="userPageCon" value="${requestScope.pageConByUserID}"/>
                        <c:forEach items="${userPageCon}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.bookingID}</td>
                                <td>${dto.dateOfBook}</td>
                                <td>
                                    <c:if test="${dto.dateOfConfirm eq null}">
                                        <h4 style="color: #003eff">WAITING PROCESS</h4>
                                    </c:if>
                                    <c:if test="${not empty dto.dateOfConfirm}">
                                        ${dto.dateOfConfirm}
                                    </c:if>    
                                </td>
                                <td>
                                    <c:if test="${dto.status eq 'Accept'}">
                                        <h4 style="color: green">Approved</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'New'}">
                                        <h4 style="color: brown">WAITING CONFIRM</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'Delete'}">
                                        <h4 style="color: red">Rejected</h4>
                                    </c:if> 
                                    <c:if test="${dto.status eq 'inActive'}">
                                        <h4 style="color: red">Your Deleted!</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'Returned'}">
                                        <h4 style="color: greenyellow">Your Returned!</h4>
                                    </c:if>  
                                </td>
                        <form action="Order" method="POST">
                            <input type="hidden" name="txtBookingID" value="${dto.bookingID}" />

                            <td>
                                <c:if test="${dto.status eq 'Accept'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if>
                                <c:if test="${dto.status eq 'New'}">
                                    <h5 style="color: blue">WAITING FOR PROCESS</h5>
                                    <!--<button name="OAction" value="Delete">Delete</button>-->
                                </c:if>
                                <c:if test="${dto.status eq 'Delete'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if> 
                                <c:if test="${dto.status eq 'inActive'}">
                                    <h5 style="color: red">User Deletes History!</h5>
                                </c:if>
                                <c:if test="${dto.status eq 'Returned'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if>

                            </td>
                            <td>
                                <c:if test="${dto.status eq 'New'}">
                                    <h5 style="color: blue">WAITING FOR PROCESS</h5>                                   
                                </c:if>
                                <c:if test="${dto.status eq 'Accept'}">
                                    <button name="OAction" value="Return">Return</button>
                                </c:if>  
                                <c:if test="${dto.status eq 'Delete'}">
                                    <h5 style="color: red">ADMIN REJECTED</h5>    
                                </c:if>  
                                <c:if test="${dto.status eq 'inActive'}">
                                    <h5 style="color: orangered">You Deleted!</h5>
                                </c:if>
                                <c:if test="${dto.status eq 'Returned'}">
                                    <h4 style="color: greenyellow">Return Done!</h4>
                                </c:if>
                            </td>
                            <td><button name="OAction" value="ViewDetails">View Details</button></td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>



                <div class="banner_bt">
                    <c:forEach begin="1" end="${requestScope.pageNumUser}" var="i">
                        <a href="UserViewHistory?index=${i}" style="color: #ff9933">${i}</a>
                    </c:forEach>
                </div>

            </div>

        </c:if>    

        <c:set var="listHisByItemName" value="${requestScope.listHisSearchByItemName}"/>
        <c:if test="${listHisByItemName != null}">
            <div class="search_box">


                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="col-auto">NO.</th>
                            <th class="col-auto">Booking ID</th>
                            <th class="col-auto">Date of Create</th>
                            <th class="col-auto">Date of Confirm</th>
                            <th class="col-auto">Status</th>
                            <th class="col-auto">Delete</th>
                            <th class="col-auto">Return</th>
                            <th class="col-auto">View Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="userPageCon" value="${requestScope.listHisSearchByItemName}"/>
                        <c:forEach items="${userPageCon}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.bookingID}</td>
                                <td>${dto.dateOfBook}</td>
                                <td>
                                    <c:if test="${dto.dateOfConfirm eq null}">
                                        <h4 style="color: #003eff">WAITING PROCESS</h4>
                                    </c:if>
                                    <c:if test="${not empty dto.dateOfConfirm}">
                                        ${dto.dateOfConfirm}
                                    </c:if>    
                                </td>
                                <td>
                                    <c:if test="${dto.status eq 'Accept'}">
                                        <h4 style="color: green">Approved</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'New'}">
                                        <h4 style="color: brown">WAITING CONFIRM</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'Delete'}">
                                        <h4 style="color: red">Rejected</h4>
                                    </c:if> 
                                    <c:if test="${dto.status eq 'inActive'}">
                                        <h4 style="color: red">Your Deleted!</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'Returned'}">
                                        <h4 style="color: greenyellow">Your Returned!</h4>
                                    </c:if>  
                                </td>
                        <form action="Order" method="POST">
                            <input type="hidden" name="txtBookingID" value="${dto.bookingID}" />

                            <td>
                                <c:if test="${dto.status eq 'Accept'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if>
                                <c:if test="${dto.status eq 'New'}">
                                    <h5 style="color: blue">WAITING FOR PROCESS</h5>
                                    <!--<button name="OAction" value="Delete">Delete</button>-->
                                </c:if>
                                <c:if test="${dto.status eq 'Delete'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if> 
                                <c:if test="${dto.status eq 'inActive'}">
                                    <h5 style="color: red">User Deletes History!</h5>
                                </c:if>
                                <c:if test="${dto.status eq 'Returned'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if>

                            </td>
                            <td>
                                <c:if test="${dto.status eq 'New'}">
                                    <h5 style="color: blue">WAITING FOR PROCESS</h5>                                   
                                </c:if>
                                <c:if test="${dto.status eq 'Accept'}">
                                    <button name="OAction" value="Return">Return</button>
                                </c:if>  
                                <c:if test="${dto.status eq 'Delete'}">
                                    <h5 style="color: red">ADMIN REJECTED</h5>    
                                </c:if>  
                                <c:if test="${dto.status eq 'inActive'}">
                                    <h5 style="color: orangered">You Deleted!</h5>
                                </c:if>
                                <c:if test="${dto.status eq 'Returned'}">
                                    <h4 style="color: greenyellow">Return Done!</h4>
                                </c:if>
                            </td>
                            <td><button name="OAction" value="ViewDetails">View Details</button></td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>




            </div>
        </c:if>

        <c:set var="uListHisByDateConf" value="${requestScope.uListSearchByDateConfirm}"/>
        <c:if test="${uListHisByDateConf != null}">
            <div class="search_box">


                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="col-auto">NO.</th>
                            <th class="col-auto">Booking ID</th>
                            <th class="col-auto">Date of Create</th>
                            <th class="col-auto">Date of Confirm</th>
                            <th class="col-auto">Status</th>
                            <th class="col-auto">Delete</th>
                            <th class="col-auto">Return</th>
                            <th class="col-auto">View Details</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${uListHisByDateConf}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.bookingID}</td>
                                <td>${dto.dateOfBook}</td>
                                <td>
                                    <c:if test="${dto.dateOfConfirm eq null}">
                                        <h4 style="color: #003eff">WAITING PROCESS</h4>
                                    </c:if>
                                    <c:if test="${not empty dto.dateOfConfirm}">
                                        ${dto.dateOfConfirm}
                                    </c:if>    
                                </td>
                                <td>
                                    <c:if test="${dto.status eq 'Accept'}">
                                        <h4 style="color: green">Approved</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'New'}">
                                        <h4 style="color: brown">WAITING CONFIRM</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'Delete'}">
                                        <h4 style="color: red">Rejected</h4>
                                    </c:if> 
                                    <c:if test="${dto.status eq 'inActive'}">
                                        <h4 style="color: red">Your Deleted!</h4>
                                    </c:if>
                                    <c:if test="${dto.status eq 'Returned'}">
                                        <h4 style="color: greenyellow">Your Returned!</h4>
                                    </c:if>  
                                </td>
                        <form action="Order" method="POST">
                            <input type="hidden" name="txtBookingID" value="${dto.bookingID}" />

                            <td>
                                <c:if test="${dto.status eq 'Accept'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if>
                                <c:if test="${dto.status eq 'New'}">
                                    <h5 style="color: blue">WAITING FOR PROCESS</h5>
                                    <!--<button name="OAction" value="Delete">Delete</button>-->
                                </c:if>
                                <c:if test="${dto.status eq 'Delete'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if> 
                                <c:if test="${dto.status eq 'inActive'}">
                                    <h5 style="color: red">User Deletes History!</h5>
                                </c:if>
                                <c:if test="${dto.status eq 'Returned'}">
                                    <button name="OAction" value="Delete">Delete</button>
                                </c:if>

                            </td>
                            <td>
                                <c:if test="${dto.status eq 'New'}">
                                    <h5 style="color: blue">WAITING FOR PROCESS</h5>                                   
                                </c:if>
                                <c:if test="${dto.status eq 'Accept'}">
                                    <button name="OAction" value="Return">Return</button>
                                </c:if>  
                                <c:if test="${dto.status eq 'Delete'}">
                                    <h5 style="color: red">ADMIN REJECTED</h5>    
                                </c:if>  
                                <c:if test="${dto.status eq 'inActive'}">
                                    <h5 style="color: orangered">You Deleted!</h5>
                                </c:if>
                                <c:if test="${dto.status eq 'Returned'}">
                                    <h4 style="color: greenyellow">Return Done!</h4>
                                </c:if>
                            </td>
                            <td><button name="OAction" value="ViewDetails">View Details</button></td>
                        </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </c:if>
        <!-- search box END -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
