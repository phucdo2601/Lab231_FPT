<%-- 
    Document   : adminEdit
    Created on : Jun 17, 2021, 8:46:49 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Edit Page</title>

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
        <c:if test="${requestScope.itemByID != nulls}">
            <c:set var="itemByID" value="${requestScope.itemByID}"/>
            <c:if test="${requestScope.errUpdateItem != null}">
                <h3>
                    <font color="red">
                        ${requestScope.errUpdateItem}
                    </font>
                </h3>
            </c:if>
            <form action="AdminMainController" method="POST" enctype="multipart/form-data">
                Product id: <input type="text" name="txtItemID" value="${itemByID.itemID}" />
                <font color ="red">

                </font>
                </br>
                Category : 
                <select name="cboCate" style="width: 200px">
                    <c:forEach items="${requestScope.listCate}" var="dto">                        
                        <c:if test="${dto.cateID == itemByID.cateID}">
                            <option selected>${dto.cateName}</option>
                        </c:if>
                        <c:if test="${dto.cateID != itemByID.cateID}">
                            <option>${dto.cateName}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <font color ="red">

                </font>
                </br>
                Product name: <input type="text" name="txtItemName" value="${itemByID.itemName}" />
                <font color ="red">

                </font>
                </br>
                Author name: <input type="text" name="txtAuthor" value="${itemByID.author}" />
                <font color ="red">

                </font>
                </br>
                Image: <img id="image" width="60" src="images/${itemByID.imgUrl}" alt="" /> <span><input type="file" name="photo" onchange="readURL(this);" accept="image/gif, image/jpeg, image/png" /></span>
                <font color ="red">

                </font>
                </br>
                Price: <input type="text" name="txtPrice" value="${itemByID.price}" />
                <font color ="red">

                </font>
                </br>
                Quantity: <input type="text" name="txtQuantity" value="${itemByID.quantity}" />
                <font color ="red">

                </font>
                </br>
                <input type="hidden" name="imgUrl" value="${itemByID.imgUrl}" />
                <button type="submit" value="AUpdateItem" name="AAction">
                    Update Book
                </button>
                </br>
                <font color ="red">

                </font>
            </form>
        </c:if>



        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
