<%-- 
    Document   : accountManagement
    Created on : Feb 18, 2021, 8:44:06 AM
    Author     : phucd
--%>

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
            <section id="form">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="signup-form">

                                <h1>Welcome ${userInfo.username} to Update Account!</h1>
                                <form action="UserMainController" method="POST">

                                    Username: <input type="text" name="txtUsername" value="${userInfo.username}" readonly="true"/>

                                </br>
                                Fullname: <input type="text" name="txtFullname" value="${userInfo.fullname}" />

                                </br>
                                Address: <input type="text" name="txtAddress" value="${userInfo.address}" />

                                </br>
                                Phone: <input type="text" name="txtPhone" value="${userInfo.phone}" />

                                </br>
                                Email: <input type="text" name="txtEmail" value="${userInfo.email}" />

                                <br>

                                <button onclick="reloadUserInfoEditPage()" type="submit" value="UpdateAccount" name="UAction" class="btn btn-default">Update Account</button>
                                <input type="hidden" name="lastSearchValue" value="<%= request.getParameter("txtUsername")%>" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            function reloadUserInfoEditPage() {
                window.history.back();
            }
        </script>
    </body>
</html>
