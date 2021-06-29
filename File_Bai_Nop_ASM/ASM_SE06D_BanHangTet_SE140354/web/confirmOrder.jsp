<%-- 
    Document   : confirmOrder
    Created on : Mar 5, 2021, 6:44:35 PM
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
        <h1>Hello ${sessionScope.USERNAME}</h1>
        <form action="MainController" method="POST">
            <input type="hidden" name="txtUserConfirm" value="${sessionScope.USERNAME}" />
        </form>

        <div class="review-payment">
            <h2>Review & Payment</h2>
        </div>

        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr class="cart_menu">
                        <td>NO.</td>
                        <td>Order ID</td>
                        <td>Username</td>
                        <td>Customer Name</td>
                        <td>Address Sending</td> 
                        <td>Phone</td>
                        <td>Date of Booking</td>
                        <td>Payment</td>
                        <td>Waiting</td>
                        <td>Total</td>
                        <td></td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.DTO}" varStatus="counter">
                        <c:if test="${dto.finishing == false && dto.waiting == true}">
                            <tr>
                                <td>
                                    <p>${counter.count}</p>
                                </td>
                                <td>
                                    <h4><a href="">${dto.orderID}</a></h4>
                                </td>
                                <td>
                                    <p>${dto.username}</p>
                                </td>
                                <td>
                                    <p>${dto.customerName}</p>
                                </td>
                                <td>
                                    <p>${dto.addressSending}</p>
                                </td>
                               <td>
                                    <p>${dto.phoneNumber}</p>
                                </td>
                                <td>
                                    <p>${dto.dateOfBooking}</p>
                                </td>
                                <td>
                                    <p>${dto.payment} </p>
                                </td>	
                                <td>
                                    <p>${dto.waiting}</p>
                                </td>
                                <td>
                                    <span>
                                        <fmt:formatNumber minIntegerDigits="0">
                                        ${dto.totalPrice} 
                                        </fmt:formatNumber>
                                        VND
                                    </span>
                                </td>
                                <c:url var="cancelOrder" value="MainController">
                                    <c:param name="action" value="CancelOrder"/>
                                    <c:param name="id" value="${dto.orderID}" /> 

                                </c:url>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="${cancelOrder}"><i class="fa fa-times"></i></a>
                                </td>
                                <c:url var="confirmOrder" value="MainController">
                                    <c:param name="action" value="ConfirmOrder"/>
                                    <c:param name="id" value="${dto.orderID}" /> 

                                </c:url>
                                <td>
                                    <a onclick="userConfirmOrder(this)" class="btn btn-default add-to-cart" href="${confirmOrder}">Confirm</a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>


                </tbody>
            </table>
        </div>


        <jsp:include page="footer.jsp"></jsp:include> 
        <script>

        </script>
    </body>
</html>
