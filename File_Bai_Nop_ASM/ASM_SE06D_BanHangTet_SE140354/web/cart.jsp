<%-- 
    Document   : cart
    Created on : Jan 14, 2021, 1:19:12 PM
    Author     : phucd
--%>

<%@page import="phucdn.dtos.ProductDTO"%>
<%@page import="phucdn.dtos.CartObj"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%
            CartObj shoppingCart = (CartObj) session.getAttribute("cart");
            String userCart;
            if (shoppingCart == null) {
                userCart = "";
            } else {
                userCart = shoppingCart.getUsername();
            }
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
        %>
        <section id="do_action">
                        <div class="container">
                            <div class="heading">
                                <h1><%= userCart%>'s cart</h1>
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
                            <%
                                if (shoppingCart != null && shoppingCart.getCart().size() > 0) {
                            %>
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
                                        <%
                                            int count = 0;
                                            for (ProductDTO dto : shoppingCart.getCart().values()) {
                                        %>

                                        <%--<c:forEach items="${listProCart}" var="p">--%>
                                        <tr>
                                    <form action="MainController" method="POST">
                                        <td class="cart_product">
                                            <a href=""><img style="max-height: 100px; min-width: 100px" src="<%= dto.getImage()%>" alt=""></a>
                                        </td>
                                        <td class="cart_description">
                                            <h4><a href=""></a><%= dto.getProductName()%></h4>
                                            <p>Web ID: <%= dto.getProductID()%></p>
                                            <input type="hidden" name="txtProductID" value="<%= dto.getProductID()%>" />
                                        </td>
                                        <td class="cart_price">
                                            <p><%= nf.format(dto.getPrice())%> VND</p>
                                        </td>
                                        <td class="cart_quantity">
                                            <div class="cart_quantity_button">
                                                <a class="cart_quantity_up" href=""> + </a>
                                                <input class="cart_quantity_input" type="text" name="txtQuantity" value="<%= dto.getQuantity()%>"  size="2" >
                                                <a class="cart_quantity_down" href="#"> - </a>
                                            </div>
                                        </td>
                                        <td class="cart_total">
                                            <p class="cart_total_price"><%= nf.format(dto.getPrice() * dto.getQuantity())%> VND</p>
                                        </td>

                                        <td class="cart_delete">
                                            <button class="cart_quantity_delete" name="action" value="Delete"><i class="fa fa-times"></i></button>
                                        </td>

                                        <td class="cart_delete">
                                            <button class="cart_quantity_delete" name="action" value="Update">Update</button>

                                        </td>
                                    </form>

                                    </tr>
                                    <%
                                        }
                                    %>
                                    <%--</c:forEach>--%>

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

                                            <form action="MainController" method="POST">
                                                <ul>
                                                    <li>Username <span>${sessionScope.USERNAME}</span></li>
                                                    <input type="hidden" name="txtUsername" value="${sessionScope.USERNAME}" />
                                                    <li>Receiver <span> <input type="text" name="txtCustomerName" value="" /> </span></li>
                                                    <li>Address <span> <input type="text" name="txtAddressShipping" value="" /> </span></li>
                                                    <li>Phone Receiver: <span> <input type="text" name="txtPhone" value="" /> </span></li>
                                                    <li>Total <span> <%= nf.format(shoppingCart.getTotal())%> VND </span></li>
                                                    <input type="hidden" name="txtTotal" value="<%= shoppingCart.getTotal()%>" />
                                                    <li>
                                                        <input type="checkbox" name="chkCard">
                                                        <label>Card</label>
                                                    </li>
                                                    <li>
                                                        <input type="checkbox" name="chkCash">
                                                        <label>Cash</label>
                                                    </li>
                                                </ul>
                                                
                                                <button class="btn btn-default check_out" name="action" value="Check Out">Check Out</button>

                                            </form> 
                                        </c:if>

                                        <c:if test="${sessionScope.USERNAME == null}" var="usernameCar">
                                            <a class="btn btn-default check_out" href="login.jsp">Please login before checking out!</a>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section><!--/#do_action-->

                    <%
                        }else {
                    %>
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

                    <%
                        }
                    %>

                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
