<%-- 
    Document   : adminItem
    Created on : Jun 17, 2021, 2:36:54 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Management Item Page</title>

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
            function myFunction_Delete_Item(itemID) {
                var result = confirm("Do you want to delete this book " + itemID + " ?");
                if (result == true) {
                    window.location.replace("AdminMainController?AAction=ADeleteItem&txtItemID=" + itemID);
                }
            }
            function myFunction_ReActivate_Item(itemID) {
                var result = confirm("Do you want to Re-Activate this book " + itemID + " ?");
                if (result == true) {
                    window.location.replace("AdminMainController?AAction=AReActivateItem&txtItemID=" + itemID);
                }
            }
        </script>
    </head>
    <body>
        <c:if test="${not empty requestScope.successMsg}">
            <script>
                swal("Successful!", "Thanks");
            </script>
        </c:if>
        <jsp:include page="header.jsp"></jsp:include>
            <form action="AdminMainController" method="POST">
                 <!--     Product: <input oninput="adminSearchByProductID(this)" type="text" name="txtProduct" value="${txtProductSeach}" />
               <input type="submit" value="Search Product" name="AAction" />
               <input type="submit" value="Reset Product" name="AAction"/>
               </br>-->
            <p><a  class="btn btn-fefault cart" href="adminInsertProduct.jsp">
                    <i class="fa fa-shopping-cart"></i>
                    Insert a Product
                </a></p>
            <button class="btn btn-fefault cart" name="AAction"
                    value="AInsertItemPage">Insert a Product</button>
        </form></br> 
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr class="cart_menu">
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Category ID</th>
                        <th>Product Name</th>
                        <th>Author</th>
                        <th class="image">image</th>
                        <th class="description">Description</th>
                        <th class="price">Price</th>
                        <th td class="quantity">Quantity</th>
                        <th>Buying</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.listItem}" var="dto" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.itemID}</td>
                            <td>${dto.cateID}</td>
                            <td>${dto.itemName}</td>
                            <td>${dto.author}</td>
                            <td><img src ='images/${dto.imgUrl}' alt='' style="height: 50px; width: 50px"/></td>               
                            <th>${dto.description}</th>
                            <td>${dto.price}</td>
                            <td>${dto.quantity}</td>
                            <td><input type="checkbox" name="chkProStatus" value="ADMIN"
                                       <c:if test="${dto.status == 'Active'}">
                                           checked="checked"
                                       </c:if>
                                       /></td>
                            <td>
                                <c:if test="${dto.status == 'Active' }">
                                    <button type="submit"  onclick="myFunction_Delete_Item('${dto.itemID}');">Delete</button>
                                </c:if>
                                <c:if test="${dto.status != 'Active' }">
                                    <button type="submit"  onclick="myFunction_ReActivate_Item('${dto.itemID}');">Re-Activate</button>
                                </c:if>
                            </td>
                            <td>
                                <form action="AdminMainController" method="POST">
                                    <input type="hidden" name="txtItemID" value="${dto.itemID}" />
                                    <button type="submit" value="AEditItem" name="AAction">Edit Book</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
