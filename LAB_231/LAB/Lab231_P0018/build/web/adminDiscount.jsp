<%-- 
    Document   : adminDiscount
    Created on : Jun 17, 2021, 3:38:32 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Management Discount Page</title>
    </head>

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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        function myFunction(userID, discountID) {
            var result = confirm("Do you want to add " + userID + " this " + discountID + " ?");
            if (result == true) {
                window.location.replace("AdminMainController?AAction=ARemoveUserDiscount&txtDiscountID=" + discountID + "&txtUserID=" + userID);
            }
        }
    </script>
    <body>
        <c:if test="${not empty requestScope.successMSG}">
            <script>
                swal("Successful!", "Thanks");
            </script>
        </c:if>
        <jsp:include page="header.jsp"></jsp:include>
            <h1>Hello World!</h1>
            <form action="AdminMainController" method="POST">
                             <!--     Product: <input oninput="adminSearchByProductID(this)" type="text" name="txtProduct" value="${txtProductSeach}" />
                           <input type="submit" value="Search Product" name="AAction" />
                           <input type="submit" value="Reset Product" name="AAction"/>
                           </br>-->
            <p><a  class="btn btn-fefault cart" href="adminInsert.jsp">
                    <i class="fa fa-shopping-cart"></i>
                    Insert a Discount
                </a></p>
        </form></br> 

        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr class="cart_menu">
                        <th>No</th>
                        <th>Discount ID</th>
                        <th>Discount Name</th>                     
                        <th class="price">Rate</th>
                        <th td class="quantity">Using</th>
                        <th td class="quantity">Add to Account</th>
                        <th>UserID</th>
                        <th>Date Of Create</th>
                        <th>Status</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.listDiscount}" var="dto" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.disID}</td>
                            <td>${dto.disName}</td>
                            <td>${dto.rateDis}</td>

                            <td><input type="checkbox" name="chkUsing" value="ADMIN"
                                       <c:if test="${dto.isUsing == true}">
                                           checked="checked"
                                       </c:if>
                                       /></td>
                            <td>
                                <input type="checkbox" name="chkAddAcc" value="ADMIN"
                                       <c:if test="${dto.isAddAcc == true}">
                                           checked="checked"
                                       </c:if>
                                       /></td>
                            </td>
                            <td>
                                <form name="AdminMainController" method="post">
                                    <input type="hidden" name="AAction" value="AAddAccToDis" />
                                    <input type="hidden" name="txtDisID" value="${dto.disID}" />
                                    <c:if test="${dto.userID == null}">
                                        <select name="userList"
                                                onchange='if (this.value != "") {
                                                            this.form.submit();
                                                        }'
                                                >
                                            <option></option>
                                            <c:forEach items="${requestScope.listAcc}" var="p">
                                                <c:if test="${p.userID == dto.userID}">
                                                    <option selected>
                                                        ${p.userID}
                                                    </option>
                                                </c:if>
                                                <c:if test="${p.userID != dto.userID}">
                                                    <option >
                                                        ${p.userID}
                                                    </option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </c:if>
                                    <c:if test="${dto.userID != null}">
                                        ${dto.userID}
                                    </c:if>
                                </form>
                            </td>


                            <td>
                                ${dto.dateOfCreate}
                            </td>
                            <td>
                                <c:if test="${dto.isAddAcc != true}">

                                    <h4>
                                        <font color="blue">
                                        This discount is not to add someone!
                                        </font>
                                    </h4>

                                </c:if>
                                <c:if test="${dto.isAddAcc == true}">
                                    <h4>
                                        <font color="green">
                                        This discount is belong to someone!
                                        </font>
                                    </h4>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${dto.isUsing != true && dto.isAddAcc == true}">

                                    <input type="hidden" name="txtUserID" value="" />
                                    <input type="hidden" name="txtProductID" value="${dto.disID}" />

                                    <button type="submit" onclick="myFunction('${dto.userID}', '${dto.disID}')">Remove User</button>

                                </c:if>
                                <c:if test="${dto.isUsing == true && dto.isAddAcc == true}">
                                    <h4>
                                        <font color="orange">
                                        This discount is used by ${dto.userID}!
                                        </font>
                                    </h4>
                                </c:if>

                                    <c:if test="${dto.isUsing == false && dto.isAddAcc == false}">
                                    <h4>
                                        <font color="brown">
                                        This discount is not added to someone!
                                        </font>
                                    </h4>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>   
    </body>
</html>
