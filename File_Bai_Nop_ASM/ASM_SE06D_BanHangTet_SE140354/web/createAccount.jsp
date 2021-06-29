<%-- 
    Document   : createAccount
    Created on : Jan 26, 2021, 6:16:12 PM
    Author     : phucd
--%>

<%@page import="phucdn.dtos.AccountErrorObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="signUpTemp/fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="signUpTemp/css/style.css">
    </head>
    <body>
        <%--<jsp:include page="header.jsp"></jsp:include>--%>

        <div class="main">
            <%
                AccountErrorObject errors = (AccountErrorObject) request.getAttribute("INSERTERRS");
            %>

            <section class="signup">
                <!-- <img src="images/signup-bg.jpg" alt=""> -->
                <div class="container">
                    <div class="signup-content">
                        <form method="POST" id="signup-form" class="signup-form" action="MainController">
                            <h2 class="form-title">Create account</h2>
                            <div class="form-group">
                                <input type="text" class="form-input" name="txtUsername" id="name" placeholder="Your Username"/>
                            </div>
                            <%
                                if (errors != null) {
                                    if (errors.getUsernameError() != null) {
                            %>

                            <div class="alert alert-danger" role="alert" style="color: red">
                                <%= errors.getUsernameError()%>
                            </div>
                            <%
                                    }
                                }
                            %>
                            <div class="form-group">
                                <input type="text" class="form-input" name="txtFullname" id="email" placeholder="Your Fullname"/>
                            </div>
                            <%
                                if (errors != null) {
                                    if (errors.getFullnameError() != null) {
                            %>

                            <div class="alert alert-danger" role="alert" style="color: red">
                                <%= errors.getFullnameError()%>
                            </div>
                            <%
                                    }
                                }
                            %>
                            <div class="form-group">
                                <input type="text" class="form-input" name="txtPassword" id="password" placeholder="Password"/>
                                <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                            </div>
                            <%
                                if (errors != null) {
                                    if (errors.getPasswordError() != null) {
                            %>

                            <div class="alert alert-danger" role="alert" style="color: red">
                                <%= errors.getPasswordError()%>
                            </div>
                            <%
                                    }
                                }
                            %>
                            <div class="form-group">
                                <input type="password" class="form-input" name="txtConfirm" id="re_password" placeholder="Repeat your password"/>
                                <span toggle="#re_password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                            </div>
                            <%
                                if (errors != null) {
                                    if (errors.getConfirmError() != null) {
                            %>

                            <div class="alert alert-danger" role="alert" style="color: red">
                                <%= errors.getConfirmError()%>
                            </div>
                            <%
                                    }
                                }
                            %>
                            <!--                        <div class="form-group">
                                                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                                        <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                                                    </div>-->
                            <div class="form-group">
                                <input type="submit" name="action" id="submit" class="form-submit" value="Create new Account" />
                            </div>
                        </form>
                        <%
                            if (errors != null) {
                                if (true) {
                        %>
                        <font color ="red">
                        <%= errors.getUsernameisExisted()%>
                        </font>
                        <%
                                }
                            }
                        %>
                        <p class="loginhere">
                            Have already an account ? <a href="login.jsp" class="loginhere-link">Login here</a>
                        </p>
                        <p style="text-align: center; color: #555; font-weight: 500">
                            OR Come Back Home Page ? <a href="MainController" class="loginhere-link">Home Page</a>
                        </p>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="signUpTemp/vendor/jquery/jquery.min.js"></script>
        <script src="signUpTemp/js/main.js"></script>
        <!--===============================================================================================-->

        <%--<jsp:include page="footer.jsp"></jsp:include>--%>
    </body>
</html>
