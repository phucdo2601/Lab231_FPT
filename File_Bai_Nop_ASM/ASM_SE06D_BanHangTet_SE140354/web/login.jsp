<%-- 
    Document   : Login
    Created on : Jan 22, 2021, 5:34:47 PM
    Author     : phucd
--%>

<%@page import="phucdn.dtos.AccountErrorObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="loginTemp/images/icons/favicon.ico" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="loginTemp/css/util.css">
        <link rel="stylesheet" type="text/css" href="loginTemp/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <%--<jsp:include page="header.jsp"></jsp:include>--%> 
        <%
            AccountErrorObject errroObj = (AccountErrorObject) request.getAttribute("INVALID");
            String usernameError = "";
            String passwordError = "";
            String username = request.getParameter("txtUsername");
            if (username == null) {
                username = "";
            }
            if (errroObj != null) {
                if (errroObj.getUsernameError() != null) {
                    usernameError = errroObj.getUsernameError();
                }
                if (errroObj.getPasswordError() != null) {
                    passwordError = errroObj.getPasswordError();
                }
            }
        %>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('loginTemp/images/bg-02.png');">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                    <form class="login100-form validate-form" action="MainController" method="POST">
                        <span class="login100-form-title p-b-49">
                            Login
                        </span>
                        <%
                            String errorLogin = (String) request.getAttribute("ERROR_LOGIN");
                            if (errorLogin != null) {
                        %>
                        <div class="alert alert-danger" role="alert">
                            <%= errorLogin%>
                        </div>
                        <%
                            }
                        %>


                        <div class="wrap-input100 validate-input m-b-23" data-validate="Username is reauired">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="txtUsername" placeholder="Type your username" value="<%= username%>">
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <span class="label-input100">Password</span>
                            <input class="input100" type="password" name="txtPassword" placeholder="Type your password">
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>

                        <div class="text-right p-t-8 p-b-31">
                            <a href="#">
                                Forgot password?
                            </a>
                        </div>
                        <p><input type="checkbox" name="remember-me" /> Remember me</p>

                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn" type="submit" name="action" value="Login">
                                    Login
                                </button>
                            </div>
                        </div>

                        <!-- <div class="txt1 text-center p-t-54 p-b-20">
                                <span>
                                        Or Sign Up Using
                                </span>
                        </div>

                        <div class="flex-c-m">
                                <a href="#" class="login100-social-item bg1">
                                        <i class="fa fa-facebook"></i>
                                </a>

                                <a href="#" class="login100-social-item bg2">
                                        <i class="fa fa-twitter"></i>
                                </a>

                                <a href="#" class="login100-social-item bg3">
                                        <i class="fa fa-google"></i>
                                </a>
                        </div> -->

                        <div class="flex-col-c p-t-155">
                            <span class="txt1 p-b-17">
                                Or Sign Up Using
                            </span>

                            <a href="createAccount.jsp" class="txt2">
                                Sign Up
                            </a>
                            
                            <a href="MainController" class="txt2" style="margin-top: 20px; color: #FE980F">
                                Or Come back Home Page. 
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="loginTemp/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="loginTemp/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="loginTemp/vendor/bootstrap/js/popper.js"></script>
        <script src="loginTemp/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="loginTemp/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="loginTemp/vendor/daterangepicker/moment.min.js"></script>
        <script src="loginTemp/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="loginTemp/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="loginTemp/js/main.js"></script>

        <%--<jsp:include page="footer.jsp"></jsp:include>--%>   
    </body>
</html>
