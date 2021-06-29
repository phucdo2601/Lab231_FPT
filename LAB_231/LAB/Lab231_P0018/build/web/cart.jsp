<%-- 
    Document   : admin
    Created on : June 18, 2021, 12:57:44 PM
    Author     : ASUS
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.NumberFormat"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>.
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

            <section id="do_action">
                <div class="container">
                    <div class="heading">
                        <h1>${sessionScope.USERNAME}'s cart</h1>
                </div>
            </div>
        </section>
        <section>
            <div class="container">
                <div class="row">
                    <%--<jsp:include page="category.jsp"></jsp:include>--%>



                    <section id="cart_items">
                        <div class="container">
                            <!--                                <div class="breadcrumbs">
                                                                <ol class="breadcrumb">
                                                                    <li><a href="#">Home</a></li>
                                                                    <li class="active">Shopping Cart</li>
                                                                </ol>
                                                            </div>-->

                            <c:if test="${sessionScope.Cart != null}">
                                <div class="table-responsive cart_info">
                                    <table class="table table-condensed">
                                        <thead>
                                            <tr class="cart_menu">
                                                <!--<td class="quantity">No</td>-->
                                                <td class="image">Item</td>
                                                <td class="description"></td>
                                                <td class="price">Price</td>
                                                <td class="quantity">Quantity</td>
                                                <td class="total">Total</td>
                                                <td></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="shopping" value="${sessionScope.Cart.cart.values()}"/>

                                            <c:forEach items="${shopping}" var="p">
                                                <tr>
                                            <form action="MainController" method="POST">
                                                <td class="cart_product">
                                                    <a href=""><img style="max-height: 100px; min-width: 100px" src="images/${p.imgUrl}" alt=""></a>
                                                </td>
                                                <td class="cart_description">
                                                    <h4><a href=""></a>${p.itemName}</h4>
                                                    <p>Web ID: ${p.itemID}</p>
                                                    <input type="hidden" name="txtItemID" value="${p.itemID}" />
                                                </td>
                                                <td class="cart_price">
                                                    <p>${p.price} USD</p>
                                                </td>
                                                <td class="cart_quantity">
                                                    <div class="cart_quantity_button">
                                                        <a class="cart_quantity_up" href="MainController?action=increaseItemQuanAtCart&txtItemID=${p.itemID}"> + </a>
                                                        <input class="cart_quantity_input" type="text" name="txtQuantity" value="${p.quantity}"  size="2" >
                                                        <a class="cart_quantity_down" href="MainController?action=decreaseItemQuanAtCart&txtItemID=${p.itemID}"> - </a>
                                                    </div>
                                                </td>
                                                <td class="cart_total">
                                                    <p class="cart_total_price">${p.quantity * p.price} USD</p>
                                                </td>

                                                <td class="cart_delete">
                                                    <button class="cart_quantity_delete" name="action" value="deleteCart"><i class="fa fa-times"></i></button>
                                                </td>


                                            </form>

                                            </tr>
                                        </c:forEach>



                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </section> <!--/#cart_items-->

                        <section id="do_action">
                            <div class="container">
                                <div class="heading">
                                    <h3>What would you like to do next?</h3>
                                    <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
                                </div>
                                <div class="row">

                                    <div class="col-sm-6">
                                        <div class="total_area">
                                            <c:if test="${sessionScope.USERNAME != null}" var="usernameCart">

                                                <form action="UserCheckOutController" method="POST">
                                                    <c:set var="disUsed" value="requestScope.disUsing"/>
                                                    <c:if test="${requestScope.disUsing != null}">
                                                        <ul>
                                                            <li>Username <span>${sessionScope.USERNAME}</span></li>
                                                            <input type="hidden" name="txtUsername" value="${sessionScope.USERNAME}" />
                                                            <li>Receiver <span> <input type="text" name="txtCustomerName" value="${sessionScope.infoUser.fulllname}" /> </span></li>
                                                            <li>Address <span> <input type="text" name="txtAddressShipping" value="${sessionScope.infoUser.address}" /> </span></li>
                                                            <li>Phone Receiver: <span> <input type="text" name="txtPhone" value="${sessionScope.infoUser.phone}" /> </span></li>
                                                            <li>Email: <span> <input type="text" name="txtEmail" value="${sessionScope.infoUser.email}" /> </span></li>
                                                            <li>Discount ID <span>${requestScope.disUsing.disID} </span></li>
                                                            <li>Discount Rate <span>${requestScope.disUsing.rateDis}% </span></li>
                                                            <li>Sub Total <span>${sessionScope.Cart.getTotal() * requestScope.disUsing.rateDis/100}  USD </span></li>
                                                            <li>Shipping <span>${sessionScope.Cart.getTotal() * 0.2 * requestScope.disUsing.rateDis / 100}  USD </span></li>
                                                            <li>VAT <span>${sessionScope.Cart.getTotal() * 0.1 * requestScope.disUsing.rateDis / 100}  USD </span></li>
                                                                <c:set var="subTotal" value="${sessionScope.Cart.getTotal() * requestScope.disUsing.rateDis/100}"/>
                                                                <c:set var="shipping" value="${sessionScope.Cart.getTotal() * 0.2 * requestScope.disUsing.rateDis / 100}"/>
                                                                <c:set var="tax" value="${sessionScope.Cart.getTotal() * 0.1 * requestScope.disUsing.rateDis / 100}"/>

                                                            <li>TOTAL <span>${subTotal + shipping + tax}  USD </span></li>

                                                            <input type="hidden" name="txtDiscountID" value="${requestScope.disUsing.disID}" />
                                                            <input type="hidden" name="txtSubTotal" value="${subTotal}" />
                                                            <input type="hidden" name="txtShipping" value="${shipping}" />
                                                            <input type="hidden" name="txtTax" value="${tax}" />
                                                            <input type="hidden" name="txtTotal" value="${subTotal + shipping + tax}" />
                                                            <li>
                                                                <input type="radio" name="payMethod" value="rdPaypal"  />
                                                                <label>Paypal</label>
                                                            </li>
                                                            <li>
                                                                <input type="radio" name="payMethod" value="rdCash" />
                                                                <label>Cash</label>
                                                            </li>
                                                        </ul>

                                                        <button type="submit" class="btn btn-default check_out" name="action" value="Check Out">Check Out</button>
                                                    </c:if>
                                                    <c:if test="${requestScope.disUsing == null}">
                                                        <ul>
                                                            <li>Username <span>${sessionScope.USERNAME}</span></li>
                                                            <input type="hidden" name="txtUsername" value="${sessionScope.USERNAME}" />
                                                            <li>Receiver <span> <input type="text" name="txtCustomerName" value="${sessionScope.infoUser.fulllname}" /> </span></li>
                                                            <li>Address <span> <input type="text" name="txtAddressShipping" value="${sessionScope.infoUser.address}" /> </span></li>
                                                            <li>Phone Receiver: <span> <input type="text" name="txtPhone" value="${sessionScope.infoUser.phone}" /> </span></li>
                                                            <li>Email: <span> <input type="text" name="txtEmail" value="${sessionScope.infoUser.email}" /> </span></li>
                                                            <li>Sub Total <span>${sessionScope.Cart.getTotal()}  USD </span></li>
                                                            <li>Shipping <span>${sessionScope.Cart.getTotal() * 0.2}  USD </span></li>
                                                            <li>VAT <span>${sessionScope.Cart.getTotal() * 0.1}  USD </span></li>
                                                                <c:set var="subTotal" value="${sessionScope.Cart.getTotal()}"/>
                                                                <c:set var="shipping" value="${sessionScope.Cart.getTotal() * 0.2}"/>
                                                                <c:set var="tax" value="${sessionScope.Cart.getTotal() * 0.1}"/>

                                                            <li>TOTAL <span>${subTotal + shipping + tax}  USD </span></li>

                                                            <input type="hidden" name="txtDiscountID" value="${requestScope.disUsing.disID}" />
                                                            <input type="hidden" name="txtSubTotal" value="${subTotal}" />
                                                            <input type="hidden" name="txtShipping" value="${shipping}" />
                                                            <input type="hidden" name="txtTax" value="${tax}" />
                                                            <input type="hidden" name="txtTotal" value="${subTotal + shipping + tax}" />
                                                            <li>
                                                                <input type="radio" name="payMethod" value="rdPaypal"  />
                                                                <label>Paypal</label>
                                                            </li>
                                                            <li>
                                                                <input type="radio" name="payMethod" value="rdCash" />
                                                                <label>Cash</label>
                                                            </li>
                                                        </ul>

                                                        <button type="submit" class="btn btn-default check_out" name="action" value="Check Out">Check Out</button>

                                                    </c:if>  
                                                </form> 
                                            </c:if>

                                            <c:if test="${sessionScope.USERNAME == null}" var="usernameCar">
                                                <a class="btn btn-default check_out" href="login.jsp">Please login before checking out!</a>
                                            </c:if>
                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <div class="total_area">
                                            <form action="MainController" method="POST">

                                                <ul><h3>Add Discount</h3></ul>

                                                <ul>
                                                    <li>Choose Discount ID: 
                                                        <span>
                                                            <select name="discountID">
                                                                <option></option>
                                                                <c:forEach items="${sessionScope.listDiscount}" var="dto">
                                                                    <option value="${dto.disID}">${dto.disID}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </span>

                                                    </li>

                                                </ul>
                                                <!--                                                <a class="btn btn-default update" href="">Update</a>-->
                                                <button class="btn btn-default update" type="submit" name="action" value="UAddDiscountOnBill">Update</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section><!--/#do_action-->
                    </c:if>

                    <c:if test="${sessionScope.Cart == null}">
                        <section id="do_action">
                            <div class="container">
                                <div class="heading">
                                    <h1>
                                        <font color="red">
                                        Please input before checking out! 
                                        </font>
                                    </h1>
                                </div>
                            </div>
                        </section>
                    </c:if>


                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
