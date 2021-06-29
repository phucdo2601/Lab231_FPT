<%-- 
    Document   : historyPurchase
    Created on : Mar 5, 2021, 4:47:02 PM
    Author     : phucd
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Purchase</title>

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
        <c:if test="${requestScope.historyPurchase != null}">
            <div class="review-payment">
                <h2>History Purchase</h2>
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
                            <td>Date of Booking</td>
                            <td>Payment</td>
                            <td>Finishing</td>
                            <td>Date of Finish</td>
                            <td>Total</td>
                            <td>View Order details</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.historyPurchase}" varStatus="counter">
                            <c:if test="${dto.waiting == false && dto.finishing == true}">
                                <tr>
                                    <td>
                                        <p>${counter.count}</p>
                                    </td>
                                    <td>
                                        <p><a href="">${dto.orderID}</a></p>
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
                                        <p>${dto.dateOfBooking}</p>
                                    </td>
                                    <td>
                                        <p>${dto.payment}</p>
                                    </td>	
                                    <td>
                                        <c:if test="${dto.finishing == true}">
                                            <p>
                                                <font color="green">
                                                Done
                                                </font>
                                            </p>
                                        </c:if>
                                    </td>
                                    <td>
                                        <p>${dto.dateOfFinishing}</p>
                                    </td>
                                    <td>
                                        <p>
                                            <fmt:formatNumber minIntegerDigits="0">
                                                ${dto.totalPrice}
                                            </fmt:formatNumber>
                                            vnd</p>
                                    </td>
                                    <td>
                                        <c:url var="viewOrderDetail" value="MainController">
                                            <c:param name="action" value="ViewOrderDetail" />
                                            <c:param name="id" value="${dto.orderID}" />
                                        </c:url>
                                        <a class="btn btn-default check_out" href="${viewOrderDetail}">View Order Detail</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>


                    </tbody>
                </table>
            </div>
        </c:if>

        <c:if test="${requestScope.cancelOrder != null}">
            <div class="review-payment">
                <h2>Cancel Order</h2>
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
                            <td>Date of Booking</td>
                            <td>Payment</td>
                            <td>Finishing</td>
                            <td>Date of Finish</td>
                            <td>Total</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dtos" items="${requestScope.cancelOrder}" varStatus="counter1">
                            <c:if test="${dtos.waiting == false && dtos.finishing == false}">
                                <tr>
                                    <td>
                                        <p>${counter1.count}</p>
                                    </td>
                                    <td>
                                        <p><a href="">${dtos.orderID}</a></p>
                                    </td>
                                    <td>
                                        <p>${dtos.username}</p>
                                    </td>
                                    <td>
                                        <p>${dtos.customerName}</p>
                                    </td>
                                    <td>
                                        <p>${dtos.addressSending}</p>
                                    </td>
                                    <td>
                                        <p>${dtos.dateOfBooking}</p>
                                    </td>
                                    <td>
                                        <p>${dtos.payment}</p>
                                    </td>	
                                    <td>
                                        <c:if test="${dtos.finishing == false}">
                                            <p>
                                                <font color="red">
                                                Not Done
                                                </font>
                                            </p>
                                        </c:if>
                                    </td>
                                    <td>
                                        <p>${dtos.dateOfFinishing}</p>
                                    </td>
                                    <td>
                                        <p>
                                            <fmt:formatNumber minIntegerDigits="0">
                                                ${dtos.totalPrice}
                                            </fmt:formatNumber>  
                                            vnd</p>
                                    </td>
                                    <td>
                                        <c:url var="viewOrderDetail" value="MainController">
                                            <c:param name="action" value="ViewOrderDetail" />
                                            <c:param name="id" value="${dtos.orderID}" />
                                        </c:url>
                                        <a class="btn btn-default check_out" href="${viewOrderDetail}">View Order Detail</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>


                    </tbody>
                </table>
            </div>
        </c:if>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
