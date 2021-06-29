<%-- 
    Document   : login
    Created on : May 11, 2021, 9:00:33 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="loginTemp/css/main.css" />

        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body>

        <div class="wrapper">
            <h1>Sign in</h1>
            <c:set var = "errorRole" value="${requestScope.errorMessageRole}"/>
            <c:if test="${errorRole != null}">
                <h5><font color="red">${requestScope.errorMessageRole}</font></h5>
            </c:if>
            <form action="MainController" method="POST">
                <input type="text" name="txtUsername" placeholder="Username" value="${param.txtUsername}" required/>
                <input type="password" name="txtPassword" placeholder="Password" required/>
                <div class="g-recaptcha"
                     data-sitekey="6LdLGLAaAAAAAKcI8h43-Tbe1FYIHuXZIiBKRA6C"></div>
                <br>
                <input type="submit" name="action" value="Login" />
            </form>
            <div class="bottom-text">
                <input type="checkbox" name="rememeber"  /> Remember me
                <a href="#">Forgot Password?</a>

            </div>

            <div class="socials">
                <!--                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>-->
                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/Lab231_J3.L.P0016_SE140354/LoginGoogleController&response_type=code
                   &client_id=644463496670-6n6oc4gsgk7be3i1v5dkboov3sv32l8r.apps.googleusercontent.com&approval_prompt=force">
                    <i class="fa fa-google"></i>
                </a>
                <!--<a href="#"><i class="fa fa-linkedin"></i></a>-->
            </div>

            <div class="signup_link">Not a member ? <a href="MainController?action=changeSignUp">Signup</a></div> 
        </div>
       

        <div id="overlay-area">

        </div>

    </body>
</html>

