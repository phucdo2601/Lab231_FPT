<%-- 
    Document   : login
    Created on : June 17, 2021, 12:57:44 PM
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
            <form action="LoginController" method="POST">
                <input type="text" name="txtUsername" placeholder="Username" value="${param.txtUsername}" required/>
                <input type="password" name="txtPassword" placeholder="Password" required/>
                
                <input type="submit" name="action" value="Login" />
            </form>
            <div class="bottom-text">
                <input type="checkbox" name="rememeber"  /> Remember me
                <a href="#">Forgot Password?</a>

            </div>

            
           
        </div>
       

        <div id="overlay-area">

        </div>

    </body>
</html>

