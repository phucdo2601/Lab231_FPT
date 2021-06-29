<%-- 
    Document   : adminInsert
    Created on : Jun 17, 2021, 3:10:55 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Insert Page</title>

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

        <script type="text/javascript">
            function displayImg() {
                var image = document.getElementById('image');
                image.src = document.getElementById('photo').value;
            }
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#image')
                                .attr('src', e.target.result)

                    };

                    reader.readAsDataURL(input.files[0]);
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <c:if test="${requestScope.listCate != null}">
            <h1>Insert Book</h1>
            <c:if test="${requestScope.errorInsertItemMsg != null}">
                <h3>
                    <font color='red'>
                    ${requestScope.errorInsertItemMsg}
                    </font>
                </h3>
            </c:if>
            <form action="AdminMainController" method="POST" enctype="multipart/form-data">
                Product id: <input type="text" name="txtItemID" value="" />
                <c:if test="${requestScope.errorInsertItem.itemIDErr != null}">
                    <font color ="red">
                    ${requestScope.errorInsertItem.itemIDErr}
                    </font>
                </c:if>
                </br>
                Category : 
                <select name="cboCate" style="width: 200px">
                    <c:forEach items="${requestScope.listCate}" var="dto">
                        <option>${dto.cateName}</option>
                    </c:forEach>
                </select>
                <font color ="red">

                </font>
                </br>
                Product name: <input type="text" name="txtItemName" value="" />
                <c:if test="${requestScope.errorInsertItem.itemNameErr != null}">
                    <font color ="red">
                    ${requestScope.errorInsertItem.itemNameErr}
                    </font>
                </c:if>
                </br>
                Author name: <input type="text" name="txtAuthor" value="" />
                <c:if test="${requestScope.errorInsertItem.authorErr != null}">
                    <font color ="red">
                    ${requestScope.errorInsertItem.authorErr}
                    </font>
                </c:if>
                </br>
                Image: <img id="image" width="60" src="" alt="" /> <span><input type="file" name="photo" onchange="readURL(this);" accept="image/gif, image/jpeg, image/png" /></span>
                <font color ="red">

                </font>
                </br>
                Price: <input type="text" name="txtPrice" value="" />
                <c:if test="${requestScope.errorInsertItem.priceErr != null}">
                    <font color ="red">
                    ${requestScope.errorInsertItem.priceErr}
                    </font>
                </c:if>
                </br>
                Quantity: <input type="text" name="txtQuantity" value="" />
                <c:if test="${requestScope.errorInsertItem.quantityErr != null}">
                    <font color ="red">
                    ${requestScope.errorInsertItem.quantityErr}
                    </font>
                </c:if>
                </br>

                <button type="submit" value="AInsertItem" name="AAction">
                    Insert Book
                </button>
                </br>
                <font color ="red">

                </font>
            </form>
        </c:if>

        <c:if test="${requestScope.listCate == null}">
            <h1>Insert Discount</h1>
            <form action="AdminMainController" method="POST">
                Discount id: <input type="text" name="txtDiscountID" value="" />
                <c:if test="${requestScope.errorInsertDis.discountIDErr != null}">
                    <font color ="red">
                    ${requestScope.errorInsertDis.discountIDErr}
                    </font>
                </c:if>
                </br>

                Discount name: <input type="text" name="txtDiscountName" value="" />
                <font color ="red">

                </font>
                </br>
                Rate Discount: <input type="text" name="txtRateDis" value="" />
                <c:if test="${requestScope.errorInsertDis.rateDisErr != null}">
                    <font color ="red">
                    ${requestScope.errorInsertDis.rateDisErr}
                    </font>
                </c:if>
                </br>

                <button type="submit" value="AInsertDiscount" name="AAction">
                    Insert Discount
                </button>
                </br>
                <font color ="red">

                </font>
            </form>
        </c:if>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
