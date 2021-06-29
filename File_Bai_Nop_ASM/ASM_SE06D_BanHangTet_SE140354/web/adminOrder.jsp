<%-- 
    Document   : adminOrder
    Created on : Feb 28, 2021, 10:46:56 PM
    Author     : phucd
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.LinkedList"%>
<%@page import="phucdn.dao.OrderDAO"%>
<%@page import="phucdn.dtos.OrderDTO"%>
<%@page import="java.util.List"%>
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
            <h1>Welcome to Admin Management Order!</h1>
        <%
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
            List<OrderDTO> listOrder = null;
            listOrder = (List<OrderDTO>) request.getAttribute("SearchOrderInfo");
        %>
        <form action="AdminMainController" method="POST">
            Username: <input type="text" name="txtAdminSearchOrder" value="${txtAdminSearchOrder}" />
            <input type="submit" value="SearchOrder" name="AAction" />
            <input type="submit" value="ResetOrder"  name="AAction"/>
        </form>

        <%
            if (listOrder != null) {
                if (listOrder.size() > 0) {
        %>
        <table class="table table-condensed">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Order ID</th>
                    <th>Username</th>
                    <th>Customer Name</th>
                    <th>Address Sending</th>
                    <th>Phone</th>
                    <th>Total Price</th>
                    <th>Date Of Booking</th>
                    <th>Waiting</th>
                    <th>Finishing</th>
                    <th>Date of Finishing</th>
                    <th>View order detail</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int countOrder1 = 0;
                    for (OrderDTO orderDto : listOrder) {
                        countOrder1++;
                %>
                <tr>
                    <td><%= countOrder1%></td>
                    <td><%= orderDto.getOrderID()%></td>
                    <td><%= orderDto.getUsername()%></td>
                    <td><%= orderDto.getCustomerName()%></td>
                    <td><%= orderDto.getAddressSending()%></td>
                    <td><%= orderDto.getPhoneNumber()%></td>
                    <td><%= nf.format(orderDto.getTotalPrice())%> VND</td>
                    <td><%= orderDto.getDateOfBooking()%></td>
                    <td>
                        <%--<%= orderDTO.isWaiting()%>--%>
                        <%
                            if (orderDto.isWaiting() == true) {
                        %>
                        <font color="brown">
                        Waiting
                        </font>
                        <%
                        } else {
                        %>
                        <font color="green">
                        Completed
                        </font>
                        <%
                            }
                        %>
                    </td>
                    <td>
                        <%--<%= orderDTO.isFinishing()%>--%>
                        <%
                            if (orderDto.isFinishing() == true) {
                        %>
                        <font color="green">
                        Finished
                        </font>
                        <%
                        } else {
                        %>
                        <font color="red">
                        Waiting for confirm
                        </font>
                        <%
                            }
                        %>
                    </td>
                    <td>
                        <%--<%= orderDTO.getDateOfFinishing()%>--%>
                        <%
                            if (orderDto.getDateOfFinishing() == null) {
                        %>
                        <font color="red">
                        Not done
                        </font>
                        <%
                        } else {
                        %>
                        <%= orderDto.getDateOfFinishing()%>
                        <%
                            }
                        %>
                    </td>
                    <td>
                        <form action="AdminMainController" method="POST">
                            <input type="hidden" name="txtOrderID" value="<%= orderDto.getOrderID()%>" />
                            <input type="hidden" name="txtAdminSearchOrder" value="<%= request.getParameter("txtAdminSearchOrder")%>" />
                            <button  name="AAction" value="AdminViewOrderDetail">View Order Detail</button>
                        </form>
                    </td>
                </tr>
                <%
                        }
                    }
                } else {
                    int count2 = 0;
                    OrderDAO orderDAO = new OrderDAO();
                    listOrder = orderDAO.findOrderLikeByOrderId("");
                %>
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Order ID</th>
                        <th>Username</th>
                        <th>Customer Name</th>
                        <th>Address Sending</th>
                        <th>Phone</th>
                        <th>Total Price</th>
                        <th>Date Of Booking</th>
                        <th>Waiting</th>
                        <th>Finishing</th>
                        <th>Date of Finishing</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (OrderDTO orderDTO : listOrder) {
                            count2++;
                    %>
                    <tr>
                        <td><%= count2%></td>
                        <td><%= orderDTO.getOrderID()%></td>
                        <td><%= orderDTO.getUsername()%></td>
                        <td><%= orderDTO.getCustomerName()%></td>
                        <td><%= orderDTO.getAddressSending()%></td>
                        <td><%= orderDTO.getPhoneNumber()%></td>
                        <td><%= nf.format(orderDTO.getTotalPrice())%> VND</td>
                        <td><%= orderDTO.getDateOfBooking()%></td>
                        <td>
                            <%--<%= orderDTO.isWaiting()%>--%>
                            <%
                                if (orderDTO.isWaiting() == true) {
                            %>
                            <font color="brown">
                            Waiting
                            </font>
                            <%
                            } else {
                            %>
                            <font color="green">
                            Completed
                            </font>
                            <%
                                }
                            %>
                        </td>
                        <td>
                            <%--<%= orderDTO.isFinishing()%>--%>
                            <%
                                if (orderDTO.isFinishing() == true) {
                            %>
                            <font color="green">
                            Finished
                            </font>
                            <%
                            } else {
                            %>
                            <font color="red">
                            Waiting for confirm
                            </font>
                            <%
                                }
                            %>
                        </td>
                        <td>
                            <%--<%= orderDTO.getDateOfFinishing()%>--%>
                            <%
                                if (orderDTO.getDateOfFinishing() == null) {
                            %>
                            <font color="red">
                            Not done
                            </font>
                            <%
                            } else {
                            %>
                            <%= orderDTO.getDateOfFinishing()%>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
            <form action="AdminMainController" method="POST">
                <input type="submit" value="Role Back" name="AAction"/>
            </form>

            <jsp:include page="footer.jsp"></jsp:include>
    </body>

    <script>

    </script>
</html>
